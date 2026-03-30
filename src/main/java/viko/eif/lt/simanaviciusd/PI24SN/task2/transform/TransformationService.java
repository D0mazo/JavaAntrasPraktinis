package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.net.URL;

/**
 * Servisas, valdantis visas transformacijas.
 * Naudoja {@link Transformer} sąsają pagal Dependency Inversion principą.
 */
public class TransformationService {

    /** HTML transformacijos objektas. */
    private final Transformer htmlTransformer;

    /** PDF transformacijos objektas. */
    private final Transformer pdfTransformer;

    /**
     * Konstruktorius su injektuojamais transformatoriais (Dependency Injection).
     *
     * @param htmlTransformer HTML transformatorius
     * @param pdfTransformer  PDF transformatorius
     */
    public TransformationService(Transformer htmlTransformer,
                                 Transformer pdfTransformer) {
        this.htmlTransformer = htmlTransformer;
        this.pdfTransformer = pdfTransformer;
    }

    /**
     * Vykdo XML transformaciją į HTML formatą.
     *
     * @param outputPath išvesties HTML failo kelias
     * @throws Exception jei transformacija nepavyksta
     */
    public void transformToHtml(String outputPath) throws Exception {
        File xmlFile = getXmlFile();
        File outputFile = new File(outputPath);
        htmlTransformer.transform(xmlFile, outputFile);
    }

    /**
     * Vykdo XML transformaciją į PDF formatą.
     *
     * @param outputPath išvesties PDF failo kelias
     * @throws Exception jei transformacija nepavyksta
     */
    public void transformToPdf(String outputPath) throws Exception {
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