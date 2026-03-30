package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link HtmlTransformer} klasei.
 */
class HtmlTransformerTest {

    /** Testuojamas transformatorius. */
    private HtmlTransformer transformer;

    /** Laikinas katalogas testų failams. */
    @TempDir
    File tempDir;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        transformer = new HtmlTransformer();
    }

    /**
     * Tikrina ar transformacija sėkmingai sukuria HTML failą.
     */
    @Test
    void transform_turėtų_sukurtiHtmlFailą() throws Exception {
        URL xmlUrl = getClass().getResource("/data.xml");
        assertNotNull(xmlUrl, "data.xml nerastas resursų aplanke");

        File xmlFile = new File(xmlUrl.getFile());
        File outputFile = new File(tempDir, "output.html");

        transformer.transform(xmlFile, outputFile);

        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
    }

    /**
     * Tikrina ar sugeneruotas HTML failo turinys turi HTML žymes.
     */
    @Test
    void transform_turėtų_sukurtiValidųHtml() throws Exception {
        URL xmlUrl = getClass().getResource("/data.xml");
        assertNotNull(xmlUrl);

        File xmlFile = new File(xmlUrl.getFile());
        File outputFile = new File(tempDir, "output.html");

        transformer.transform(xmlFile, outputFile);

        String content = new String(java.nio.file.Files.readAllBytes(outputFile.toPath()));
        assertTrue(content.contains("<html"));
        assertTrue(content.contains("Siuntos"));
        assertTrue(content.contains("Jonas Jonaitis"));
    }
}