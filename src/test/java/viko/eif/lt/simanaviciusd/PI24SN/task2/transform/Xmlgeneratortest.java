package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link XmlGenerator} klasei.
 */
class XmlGeneratorTest {

    /** Testuojamas generatorius. */
    private XmlGenerator generator;

    /** Laikinas katalogas testų failams. */
    @TempDir
    File tempDir;

    /** Testuojamų siuntų sąrašas. */
    private List<Siunta> siuntos;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        generator = new XmlGenerator();

        List<Produktas> produktai = Arrays.asList(
                new Produktas(1, "Kompiuteris", 1, 899.99f, 'A', false)
        );
        siuntos = Arrays.asList(
                new Siunta(1, "Jonas Jonaitis",
                        "Gedimino pr. 1, Vilnius",
                        2.5f, 12.99f, true, 'A', produktai)
        );
    }

    /**
     * Tikrina ar generatorius sukuria XML failą.
     */
    @Test
    void generate_turėtų_sukurtiXmlFailą() throws Exception {
        File xmlFile = new File(tempDir, "output.xml");

        generator.generate(siuntos, xmlFile);

        assertTrue(xmlFile.exists());
        assertTrue(xmlFile.length() > 0);
    }

    /**
     * Tikrina ar sugeneruotas XML failas turi teisingą turinį.
     */
    @Test
    void generate_turėtų_turėtiTeisingąTurinį() throws Exception {
        File xmlFile = new File(tempDir, "output.xml");

        generator.generate(siuntos, xmlFile);

        String content = new String(Files.readAllBytes(xmlFile.toPath()));
        assertTrue(content.contains("<siuntos>"));
        assertTrue(content.contains("Jonas Jonaitis"));
        assertTrue(content.contains("Kompiuteris"));
        assertTrue(content.contains("Gedimino pr. 1, Vilnius"));
    }

    /**
     * Tikrina ar generatorius veikia su tuščiu sąrašu.
     */
    @Test
    void generate_turėtų_veiktiSuTuščiuSąrašu() throws Exception {
        File xmlFile = new File(tempDir, "empty.xml");

        generator.generate(Arrays.asList(), xmlFile);

        assertTrue(xmlFile.exists());
        String content = new String(Files.readAllBytes(xmlFile.toPath()));
        assertTrue(content.contains("<siuntos>"));
        assertTrue(content.contains("</siuntos>"));
    }
}