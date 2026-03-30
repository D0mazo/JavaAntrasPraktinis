package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;
import viko.eif.lt.simanaviciusd.PI24SN.task2.service.SiuntosServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link SiuntosServiceImpl} klasei.
 */
class SiuntosServiceImplTest {

    /** Testuojamas servisas. */
    private SiuntosServiceImpl service;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        service = new SiuntosServiceImpl();
    }

    /**
     * Tikrina ar gaуtiVisasSiuntas grąžina visas siuntas.
     */
    @Test
    void gaуtiVisasSiuntas_turėtų_grąžintiVisasSiuntas() {
        List<Siunta> result = service.gautiVisasSiuntas();
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina teisingą siuntą.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiTeisingąSiuntą() {
        Siunta result = service.gautiSiuntaPagalId(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Jonas Jonaitis", result.getGavejas());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina null kai ID nerastas.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiNull_kaiNerastas() {
        Siunta result = service.gautiSiuntaPagalId(999);
        assertNull(result);
    }

    /**
     * Tikrina ar pridеtiSiunta teisingai prideda naują siuntą.
     */
    @Test
    void pridеtiSiunta_turėtų_pridėtiNaująSiuntą() {
        List<Produktas> produktai = Arrays.asList(
                new Produktas(10, "Telefonas", 1, 499.99f, 'A', false)
        );
        Siunta nauja = new Siunta(4, "Vardenis Pavardenis",
                "Naujas g. 1, Vilnius",
                1.0f, 8.00f, false, 'B', produktai);

        Siunta result = service.pridetiSiunta(nauja);

        assertNotNull(result);
        assertEquals(4, result.getId());
        assertEquals(4, service.gautiVisasSiuntas().size());
    }

    /**
     * Tikrina ar atnaujintiStatusa teisingai atnaujina statusą.
     */
    @Test
    void atnaujintiStatusa_turėtų_atnaujintiPristatymoStatusą() {
        Siunta result = service.atnaujintiStatusa(2, true);
        assertNotNull(result);
        assertTrue(result.isPristatyta());
    }

    /**
     * Tikrina ar atnaujintiStatusa grąžina null kai ID nerastas.
     */
    @Test
    void atnaujintiStatusa_turėtų_grąžintiNull_kaiNerastas() {
        Siunta result = service.atnaujintiStatusa(999, true);
        assertNull(result);
    }

    /**
     * Tikrina ar istrintiSiunta teisingai ištrina siuntą.
     */
    @Test
    void istrintiSiunta_turėtų_ištrinti_siuntą() {
        boolean result = service.istrintiSiunta(1);
        assertTrue(result);
        assertEquals(2, service.gautiVisasSiuntas().size());
        assertNull(service.gautiSiuntaPagalId(1));
    }

    /**
     * Tikrina ar istrintiSiunta grąžina false kai ID nerastas.
     */
    @Test
    void istrintiSiunta_turėtų_grąžintiFalse_kaiNerastas() {
        boolean result = service.istrintiSiunta(999);
        assertFalse(result);
    }
}