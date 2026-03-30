package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link TransformationService} klasei.
 */
class TransformationServiceTest {

    /** Laikinas katalogas testų failams. */
    @TempDir
    File tempDir;

    /** Testuojamas servisas. */
    private TransformationService service;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        service = new TransformationService(
                new HtmlTransformer(),
                new PdfTransformer()
        );
    }

    /**
     * Tikrina ar HTML transformacija sukuria failą.
     */
    @Test
    void transformToHtml_turėtų_sukurtiHtmlFailą() throws Exception {
        String outputPath = tempDir.getAbsolutePath() + File.separator + "output.html";
        service.transformToHtml(outputPath);
        File outputFile = new File(outputPath);
        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
    }

    /**
     * Tikrina ar PDF transformacija sukuria failą.
     */
    @Test
    void transformToPdf_turėtų_sukurtiPdfFailą() throws Exception {
        String outputPath = tempDir.getAbsolutePath() + File.separator + "output.pdf";
        service.transformToPdf(outputPath);
        File outputFile = new File(outputPath);
        assertTrue(outputFile.exists());
        assertTrue(outputFile.length() > 0);
    }
}