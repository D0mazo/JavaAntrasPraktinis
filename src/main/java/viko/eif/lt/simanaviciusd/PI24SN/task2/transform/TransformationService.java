package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import org.apache.fop.apps.FOPException;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Servisas, valdantis visas transformacijas.
 * Naudoja {@link HtmlTransformer} ir {@link PdfTransformer}
 * XML duomenims paversti į HTML ir PDF formatus.
 */
public class TransformationService {

    /** HTML transformacijos objektas. */
    private final HtmlTransformer htmlTransformer;

    /** PDF transformacijos objektas. */
    private final PdfTransformer pdfTransformer;

    /**
     * Konstruktorius, inicializuojantis transformatorius.
     */
    public TransformationService() {
        this.htmlTransformer = new HtmlTransformer();
        this.pdfTransformer = new PdfTransformer();
    }

    /**
     * Vykdo XML transformaciją į HTML formatą.
     *
     * @param outputPath išvesties HTML failo kelias
     * @throws TransformerException jei transformacija nepavyksta
     */
    public void transformToHtml(String outputPath) throws TransformerException {
        File xmlFile = getXmlFile();
        File outputFile = new File(outputPath);
        htmlTransformer.transform(xmlFile, outputFile);
    }

    /**
     * Vykdo XML transformaciją į PDF formatą.
     *
     * @param outputPath išvesties PDF failo kelias
     * @throws TransformerException jei XSL transformacija nepavyksta
     * @throws FOPException         jei FOP apdorojimas nepavyksta
     * @throws IOException          jei įvyksta įvesties/išvesties klaida
     */
    public void transformToPdf(String outputPath)
            throws TransformerException, FOPException, IOException {
        File xmlFile = getXmlFile();
        File outputFile = new File(outputPath);
        pdfTransformer.transform(xmlFile, outputFile);
    }

    /**
     * Grąžina XML duomenų failą iš resursų aplanko.
     *
     * @return XML failas
     * @throws TransformerException jei failas nerastas
     */
    private File getXmlFile() throws TransformerException {
        URL xmlUrl = getClass().getResource("/data.xml");
        if (xmlUrl == null) {
            throw new TransformerException("XML failas nerastas: /data.xml");
        }
        return new File(xmlUrl.getFile());
    }
}