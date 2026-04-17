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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Vienetų testai {@link SiuntosServiceImpl} klasei.
 */
@ExtendWith(MockitoExtension.class)
class SiuntosServiceImplTest {

    /** Imituojama repozitorija. */
    @Mock
    private SiuntosRepository repository;

    /** Testuojamas servisas. */
    private SiuntosServiceImpl service;

    /** Testuojama siunta. */
    private Siunta siunta1;

    /** Testuojama siunta. */
    private Siunta siunta2;

    /**
     * Inicializuoja testų duomenis prieš kiekvieną testą.
     */
    @BeforeEach
    void setUp() {
        List<Produktas> produktai1 = Arrays.asList(
                new Produktas(1, "Kompiuteris", 1, 899.99f, 'A', false)
        );
        List<Produktas> produktai2 = Arrays.asList(
                new Produktas(2, "Knyga", 3, 14.99f, 'B', false)
        );

        siunta1 = new Siunta(1, "Jonas Jonaitis",
                "Gedimino pr. 1, Vilnius",
                2.5f, 12.99f, true, 'A', produktai1);

        siunta2 = new Siunta(2, "Petras Petraitis",
                "Laisves al. 15, Kaunas",
                0.8f, 5.49f, false, 'B', produktai2);

        when(repository.count()).thenReturn(1L);
        service = new SiuntosServiceImpl(repository);
    }

    /**
     * Tikrina ar gautiVisasSiuntas grąžina visas siuntas.
     */
    @Test
    void gautiVisasSiuntas_turėtų_grąžintiVisasSiuntas() {
        when(repository.findAll()).thenReturn(Arrays.asList(siunta1, siunta2));

        List<Siunta> result = service.gautiVisasSiuntas();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    /**
     * Tikrina ar gautiSiuntaPagalId grąžina teisingą siuntą.
     */
    @Test
    void gautiSiuntaPagalId_turėtų_grąžintiTeisingąSiuntą() {
        when(repository.findById(1)).thenReturn(Optional.of(siunta1));

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
        when(repository.findById(999)).thenReturn(Optional.empty());

        Siunta result = service.gautiSiuntaPagalId(999);

        assertNull(result);
    }

    /**
     * Tikrina ar pridetiSiunta teisingai prideda naują siuntą.
     */
    @Test
    void pridetiSiunta_turėtų_pridėtiNaująSiuntą() {
        when(repository.save(any(Siunta.class))).thenReturn(siunta1);
        when(repository.findAll()).thenReturn(Arrays.asList(siunta1));

        Siunta result = service.pridetiSiunta(siunta1);

        assertNotNull(result);
        verify(repository, times(1)).save(siunta1);
    }

    /**
     * Tikrina ar atnaujintiStatusa teisingai atnaujina statusą.
     */
    @Test
    void atnaujintiStatusa_turėtų_atnaujintiPristatymoStatusą() {
        siunta2.setPristatyta(false);
        when(repository.findById(2)).thenReturn(Optional.of(siunta2));
        when(repository.save(any(Siunta.class))).thenReturn(siunta2);
        when(repository.findAll()).thenReturn(Arrays.asList(siunta2));

        Siunta result = service.atnaujintiStatusa(2, true);

        assertNotNull(result);
        assertTrue(result.isPristatyta());
    }

    /**
     * Tikrina ar atnaujintiStatusa grąžina null kai ID nerastas.
     */
    @Test
    void atnaujintiStatusa_turėtų_grąžintiNull_kaiNerastas() {
        when(repository.findById(999)).thenReturn(Optional.empty());

        Siunta result = service.atnaujintiStatusa(999, true);

        assertNull(result);
    }

    /**
     * Tikrina ar istrintiSiunta teisingai ištrina siuntą.
     */
    @Test
    void istrintiSiunta_turėtų_ištrinti_siuntą() {
        when(repository.existsById(1)).thenReturn(true);
        when(repository.findAll()).thenReturn(Arrays.asList(siunta2));

        boolean result = service.istrintiSiunta(1);

        assertTrue(result);
        verify(repository, times(1)).deleteById(1);
    }

    /**
     * Tikrina ar istrintiSiunta grąžina false kai ID nerastas.
     */
    @Test
    void istrintiSiunta_turėtų_grąžintiFalse_kaiNerastas() {
        when(repository.existsById(999)).thenReturn(false);

        boolean result = service.istrintiSiunta(999);

        assertFalse(result);
    }
}