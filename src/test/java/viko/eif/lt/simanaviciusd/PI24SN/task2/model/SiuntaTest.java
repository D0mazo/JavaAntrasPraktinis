package viko.eif.lt.simanaviciusd.PI24SN.task2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link Siunta} klasei.
 */
class SiuntaTest {

    /** Testuojama siunta. */
    private Siunta siunta;

    /** Testuojamų produktų sąrašas. */
    private List<Produktas> produktai;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        produktai = Arrays.asList(
                new Produktas(1, "Nesiojamas kompiuteris", 1, 899.99f, 'A', false),
                new Produktas(2, "Pele", 2, 25.00f, 'B', false)
        );
        siunta = new Siunta(1, "Jonas Jonaitis",
                "Gedimino pr. 1, Vilnius",
                2.5f, 12.99f, true, 'A', produktai);
    }

    /**
     * Tikrina ar konstruktorius teisingai nustato visus laukus.
     */
    @Test
    void konstruktorius_turėtų_teisingaiNustatytiLaukus() {
        assertEquals(1, siunta.getId());
        assertEquals("Jonas Jonaitis", siunta.getGavejas());
        assertEquals("Gedimino pr. 1, Vilnius", siunta.getAdresas());
        assertEquals(2.5f, siunta.getSvoris(), 0.01f);
        assertEquals(12.99f, siunta.getKaina(), 0.01f);
        assertTrue(siunta.isPristatyta());
        assertEquals('A', siunta.getPrioritetas());
        assertEquals(2, siunta.getProduktai().size());
    }

    /**
     * Tikrina ar tuščias konstruktorius sukuria objektą.
     */
    @Test
    void tuščiasKonstruktorius_turėtų_sukurtiObjektą() {
        Siunta tuscia = new Siunta();
        assertNotNull(tuscia);
    }

    /**
     * Tikrina setId ir getId metodus.
     */
    @Test
    void setId_turėtų_teisingaiNustatytiId() {
        siunta.setId(99);
        assertEquals(99, siunta.getId());
    }

    /**
     * Tikrina setGavejas ir getGavejas metodus.
     */
    @Test
    void setGavejas_turėtų_teisingaiNustatytiGavėją() {
        siunta.setGavejas("Petras Petraitis");
        assertEquals("Petras Petraitis", siunta.getGavejas());
    }

    /**
     * Tikrina setAdresas ir getAdresas metodus.
     */
    @Test
    void setAdresas_turėtų_teisingaiNustatytiAdresą() {
        siunta.setAdresas("Laisves al. 15, Kaunas");
        assertEquals("Laisves al. 15, Kaunas", siunta.getAdresas());
    }

    /**
     * Tikrina setSvoris ir getSvoris metodus.
     */
    @Test
    void setSvoris_turėtų_teisingaiNustatytiSvorį() {
        siunta.setSvoris(5.0f);
        assertEquals(5.0f, siunta.getSvoris(), 0.01f);
    }

    /**
     * Tikrina setKaina ir getKaina metodus.
     */
    @Test
    void setKaina_turėtų_teisingaiNustatytiKainą() {
        siunta.setKaina(20.00f);
        assertEquals(20.00f, siunta.getKaina(), 0.01f);
    }

    /**
     * Tikrina setPristatyta ir isPristatyta metodus.
     */
    @Test
    void setPristatyta_turėtų_teisingaiNustatytiStatusą() {
        siunta.setPristatyta(false);
        assertFalse(siunta.isPristatyta());
    }

    /**
     * Tikrina setPrioritetas ir getPrioritetas metodus.
     */
    @Test
    void setPrioritetas_turėtų_teisingaiNustatytiPrioritetą() {
        siunta.setPrioritetas('B');
        assertEquals('B', siunta.getPrioritetas());
    }

    /**
     * Tikrina setProduktai ir getProduktai metodus.
     */
    @Test
    void setProduktai_turėtų_teisingaiNustatytiProduktus() {
        List<Produktas> nauji = Arrays.asList(
                new Produktas(3, "Knyga", 3, 14.99f, 'B', false)
        );
        siunta.setProduktai(nauji);
        assertEquals(1, siunta.getProduktai().size());
        assertEquals("Knyga", siunta.getProduktai().get(0).getPavadinimas());
    }

    /**
     * Tikrina toString metodą.
     */
    @Test
    void toString_turėtų_grąžintiTekstą() {
        String result = siunta.toString();
        assertNotNull(result);
        assertTrue(result.contains("Jonas Jonaitis"));
        assertTrue(result.contains("Vilnius"));
    }
}