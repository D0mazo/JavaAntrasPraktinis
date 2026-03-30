package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link SiuntosWriteService} sąsajai.
 */
class SiuntosWriteServiceTest {

    /** Testuojamas servisas. */
    private SiuntosWriteService service;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        service = new SiuntosServiceImpl();
    }

    /**
     * Tikrina ar pridetiSiunta prideda siuntą.
     */
    @Test
    void pridetiSiunta_turėtų_pridėtiSiuntą() {
        List<Produktas> produktai = Arrays.asList(
                new Produktas(10, "Telefonas", 1, 499.99f, 'A', false)
        );
        Siunta nauja = new Siunta(4, "Vardenis Pavardenis",
                "Naujas g. 1, Vilnius",
                1.0f, 8.00f, false, 'B', produktai);

        Siunta result = service.pridetiSiunta(nauja);
        assertNotNull(result);
        assertEquals(4, result.getId());
    }

    /**
     * Tikrina ar atnaujintiStatusa atnaujina statusą.
     */
    @Test
    void atnaujintiStatusa_turėtų_atnaujintiStatusą() {
        Siunta result = service.atnaujintiStatusa(2, true);
        assertNotNull(result);
        assertTrue(result.isPristatyta());
    }

    /**
     * Tikrina ar istrintiSiunta ištrina siuntą.
     */
    @Test
    void istrintiSiunta_turėtų_ištrinti() {
        boolean result = service.istrintiSiunta(1);
        assertTrue(result);
    }

    /**
     * Tikrina ar istrintiSiunta grąžina false kai nerastas.
     */
    @Test
    void istrintiSiunta_turėtų_grąžintiFalse() {
        boolean result = service.istrintiSiunta(999);
        assertFalse(result);
    }
}