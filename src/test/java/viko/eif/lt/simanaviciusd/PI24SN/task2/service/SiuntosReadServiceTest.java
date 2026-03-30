package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vienetų testai {@link SiuntosReadService} sąsajai.
 */
class SiuntosReadServiceTest {

    /** Testuojamas servisas. */
    private SiuntosReadService service;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        service = new SiuntosServiceImpl();
    }

    /**
     * Tikrina ar gautiVisasSiuntas grąžina sąrašą.
     */
    @Test
    void gautiVisasSiuntas_turėtų_grąžintiSąrašą() {
        List<Siunta> result = service.gautiVisasSiuntas();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina teisingą siuntą.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiSiuntą() {
        Siunta result = service.gautiSiuntaPagalId(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina null kai nerastas.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiNull() {
        Siunta result = service.gautiSiuntaPagalId(999);
        assertNull(result);
    }
}