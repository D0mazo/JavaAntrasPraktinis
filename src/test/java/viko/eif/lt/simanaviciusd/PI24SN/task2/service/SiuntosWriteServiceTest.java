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
 * Vienetų testai {@link SiuntosWriteService} sąsajai.
 */
@ExtendWith(MockitoExtension.class)
class SiuntosWriteServiceTest {

    /** Imituojama repozitorija. */
    @Mock
    private SiuntosRepository repository;

    /** Testuojamas servisas. */
    private SiuntosWriteService service;

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
                2.5f, 12.99f, false, 'A', produktai);

        when(repository.count()).thenReturn(1L);
        service = new SiuntosServiceImpl(repository);
    }

    /**
     * Tikrina ar pridetiSiunta prideda siuntą.
     */
    @Test
    void pridetiSiunta_turėtų_pridėtiSiuntą() {
        when(repository.save(any(Siunta.class))).thenReturn(siunta);
        when(repository.findAll()).thenReturn(Arrays.asList(siunta));

        Siunta result = service.pridetiSiunta(siunta);

        assertNotNull(result);
        verify(repository, times(1)).save(siunta);
    }

    /**
     * Tikrina ar atnaujintiStatusa atnaujina statusą.
     */
    @Test
    void atnaujintiStatusa_turėtų_atnaujintiStatusą() {
        when(repository.findById(1)).thenReturn(Optional.of(siunta));
        when(repository.save(any(Siunta.class))).thenReturn(siunta);
        when(repository.findAll()).thenReturn(Arrays.asList(siunta));

        Siunta result = service.atnaujintiStatusa(1, true);

        assertNotNull(result);
        assertTrue(result.isPristatyta());
    }

    /**
     * Tikrina ar istrintiSiunta ištrina siuntą.
     */
    @Test
    void istrintiSiunta_turėtų_ištrinti() {
        when(repository.existsById(1)).thenReturn(true);
        when(repository.findAll()).thenReturn(Arrays.asList());

        boolean result = service.istrintiSiunta(1);

        assertTrue(result);
        verify(repository, times(1)).deleteById(1);
    }

    /**
     * Tikrina ar istrintiSiunta grąžina false kai nerastas.
     */
    @Test
    void istrintiSiunta_turėtų_grąžintiFalse() {
        when(repository.existsById(999)).thenReturn(false);

        boolean result = service.istrintiSiunta(999);

        assertFalse(result);
    }
}