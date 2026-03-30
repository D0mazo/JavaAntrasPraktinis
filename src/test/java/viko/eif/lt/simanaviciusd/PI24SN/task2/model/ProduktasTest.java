package viko.eif.lt.simanaviciusd.PI24SN.task2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link Produktas} klasei.
 */
class ProduktasTest {

    /** Testuojamas produktas. */
    private Produktas produktas;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        produktas = new Produktas(1, "Nesiojamas kompiuteris",
                1, 899.99f, 'A', false);
    }

    /**
     * Tikrina ar konstruktorius teisingai nustato visus laukus.
     */
    @Test
    void konstruktorius_turėtų_teisingaiNustatytiLaukus() {
        assertEquals(1, produktas.getId());
        assertEquals("Nesiojamas kompiuteris", produktas.getPavadinimas());
        assertEquals(1, produktas.getKiekis());
        assertEquals(899.99f, produktas.getKaina(), 0.01f);
        assertEquals('A', produktas.getKategorija());
        assertFalse(produktas.isTrapus());
    }

    /**
     * Tikrina ar tuščias konstruktorius sukuria objektą.
     */
    @Test
    void tuščiasKonstruktorius_turėtų_sukurtiObjektą() {
        Produktas tuscias = new Produktas();
        assertNotNull(tuscias);
    }

    /**
     * Tikrina setId ir getId metodus.
     */
    @Test
    void setId_turėtų_teisingaiNustatytiId() {
        produktas.setId(99);
        assertEquals(99, produktas.getId());
    }

    /**
     * Tikrina setPavadinimas ir getPavadinimas metodus.
     */
    @Test
    void setPavadinimas_turėtų_teisingaiNustatytiPavadinimą() {
        produktas.setPavadinimas("Pele");
        assertEquals("Pele", produktas.getPavadinimas());
    }

    /**
     * Tikrina setKiekis ir getKiekis metodus.
     */
    @Test
    void setKiekis_turėtų_teisingaiNustatytiKiekį() {
        produktas.setKiekis(5);
        assertEquals(5, produktas.getKiekis());
    }

    /**
     * Tikrina setKaina ir getKaina metodus.
     */
    @Test
    void setKaina_turėtų_teisingaiNustatytiKainą() {
        produktas.setKaina(25.50f);
        assertEquals(25.50f, produktas.getKaina(), 0.01f);
    }

    /**
     * Tikrina setKategorija ir getKategorija metodus.
     */
    @Test
    void setKategorija_turėtų_teisingaiNustatytiKategoriją() {
        produktas.setKategorija('B');
        assertEquals('B', produktas.getKategorija());
    }

    /**
     * Tikrina setTrapus ir isTrapus metodus.
     */
    @Test
    void setTrapus_turėtų_teisingaiNustatytiTrapumą() {
        produktas.setTrapus(true);
        assertTrue(produktas.isTrapus());
    }

    /**
     * Tikrina toString metodą.
     */
    @Test
    void toString_turėtų_grąžintiTekstą() {
        String result = produktas.toString();
        assertNotNull(result);
        assertTrue(result.contains("Nesiojamas kompiuteris"));
        assertTrue(result.contains("899"));
    }
}