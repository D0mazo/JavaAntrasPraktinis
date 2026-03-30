package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Klasė, atsakinga už XML duomenų transformavimą į PDF formatą
 * naudojant XSL-FO stilių lapą ir Apache FOP biblioteką.
 */
public class PdfTransformer {

    /** XSL-FO failo kelias resursų aplanke. */
    private static final String XSL_PATH = "/to-pdf.xsl";

    /**
     * Transformuoja XML failą į PDF failą naudojant XSL-FO stilių lapą.
     *
     * @param xmlFile    įvesties XML failas
     * @param outputFile išvesties PDF failas
     * @throws TransformerException jei XSL transformacija nepavyksta
     * @throws FOPException         jei FOP apdorojimas nepavyksta
     * @throws IOException          jei įvyksta įvesties/išvesties klaida
     */
    public void transform(File xmlFile, File outputFile)
            throws TransformerException, FOPException, IOException {

        InputStream xslStream = getClass().getResourceAsStream(XSL_PATH);

        if (xslStream == null) {
            throw new TransformerException("XSL failas nerastas: " + XSL_PATH);
        }

        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

        try (OutputStream out = new FileOutputStream(outputFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslStream));

            Result result = new SAXResult(fop.getDefaultHandler());
            transformer.transform(new StreamSource(xmlFile), result);
        }

        System.out.println("PDF transformacija sekminga: " + outputFile.getAbsolutePath());
    }
}
