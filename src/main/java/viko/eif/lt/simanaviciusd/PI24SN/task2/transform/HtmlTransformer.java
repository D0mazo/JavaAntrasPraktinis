package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;

/**
 * Klasė, atsakinga už XML duomenų transformavimą į HTML formatą
 * naudojant XSL stilių lapą.
 */
public class HtmlTransformer {

    /** XSL failo kelias resursų aplanke. */
    private static final String XSL_PATH = "/to-html.xsl";

    /**
     * Transformuoja XML failą į HTML failą naudojant XSL stilių lapą.
     *
     * @param xmlFile    įvesties XML failas
     * @param outputFile išvesties HTML failas
     * @throws TransformerException jei transformacija nepavyksta
     */
    public void transform(File xmlFile, File outputFile) throws TransformerException {
        InputStream xslStream = getClass().getResourceAsStream(XSL_PATH);

        if (xslStream == null) {
            throw new TransformerException("XSL failas nerastas: " + XSL_PATH);
        }

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xslStream));

        transformer.transform(
                new StreamSource(xmlFile),
                new StreamResult(outputFile)
        );

        System.out.println("HTML transformacija sekminga: " + outputFile.getAbsolutePath());
    }
}