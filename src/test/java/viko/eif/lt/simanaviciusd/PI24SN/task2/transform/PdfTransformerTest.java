package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link PdfTransformer} klasei.
 */
class PdfTransformerTest {

    /** Testuojamas transformatorius. */
    private PdfTransformer transformer;

    /** Laikinas katalogas testų failams. */
    @TempDir
    File tempDir;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        transformer = new PdfTransformer();
    }

    /**
     * Tikrina ar transformacija sėkmingai sukuria PDF failą.
     */
    @Test
    void transform_turėtų_sukurtiPdfFailą() throws Exception {
        URL xmlUrl = getClass().getResource("/data.xml");
        assertNotNull(xmlUrl, "data.xml nerastas resursų aplanke");

        File xmlFile = new File(xmlUrl.getFile());
        File outputFile = new File(tempDir, "output.pdf");

        transformer.transform(xmlFile, outputFile);

        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
    }

    /**
     * Tikrina ar sugeneruotas PDF failas prasideda su PDF antrašte.
     */
    @Test
    void transform_turėtų_sukurtiValidųPdf() throws Exception {
        URL xmlUrl = getClass().getResource("/data.xml");
        assertNotNull(xmlUrl);

        File xmlFile = new File(xmlUrl.getFile());
        File outputFile = new File(tempDir, "output.pdf");

        transformer.transform(xmlFile, outputFile);

        byte[] bytes = java.nio.file.Files.readAllBytes(outputFile.toPath());
        String header = new String(bytes, 0, Math.min(5, bytes.length));
        assertEquals("%PDF-", header, "Failas turėtų prasidėti su PDF antrašte");
    }

    /**
     * Tikrina ar transformacija meta klaidą kai XML failas nerastas.
     */
    @Test
    void transform_turėtų_mestiKlaidą_kaiXmlNerastas() {
        File neegzistuojantis = new File(tempDir, "nerastas.xml");
        File outputFile = new File(tempDir, "output.pdf");

        assertThrows(Exception.class,
                () -> transformer.transform(neegzistuojantis, outputFile));
    }
}