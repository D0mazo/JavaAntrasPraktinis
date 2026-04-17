package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;
import viko.eif.lt.simanaviciusd.PI24SN.task2.repository.SiuntosRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Vienetų testai {@link SiuntosReadService} sąsajai.
 */
@ExtendWith(MockitoExtension.class)
class SiuntosReadServiceTest {

    /** Imituojama repozitorija. */
    @Mock
    private SiuntosRepository repository;

    /** Testuojamas servisas. */
    private SiuntosReadService service;

    /** Testuojama siunta. */
    private Siunta siunta;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        List<Produktas> produktai = Arrays.asList(
                new Produktas(1, "Kompiuteris", 1, 899.99f, 'A', false)
        );
        siunta = new Siunta(1, "Jonas Jonaitis",
                "Gedimino pr. 1, Vilnius",
                2.5f, 12.99f, true, 'A', produktai);

        when(repository.count()).thenReturn(1L);
        service = new SiuntosServiceImpl(repository);
    }

    /**
     * Tikrina ar gautiVisasSiuntas grąžina sąrašą.
     */
    @Test
    void gautiVisasSiuntas_turėtų_grąžintiSąrašą() {
        when(repository.findAll()).thenReturn(Arrays.asList(siunta));

        List<Siunta> result = service.gautiVisasSiuntas();

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina teisingą siuntą.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiSiuntą() {
        when(repository.findById(1)).thenReturn(Optional.of(siunta));

        Siunta result = service.gautiSiuntaPagalId(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina null kai nerastas.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiNull() {
        when(repository.findById(999)).thenReturn(Optional.empty());

        Siunta result = service.gautiSiuntaPagalId(999);

        assertNull(result);
    }
}