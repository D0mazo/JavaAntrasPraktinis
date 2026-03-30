package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import jakarta.jws.WebService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JAX-WS Web serviso implementacija siuntos operacijoms.
 * Realizuoja {@link SiuntosService} sąsają.
 */
@WebService(endpointInterface =
        "viko.eif.lt.simanaviciusd.PI24SN.task2.service.SiuntosService")
public class SiuntosServiceImpl implements SiuntosService {

    /** Siuntų sąrašas (duomenų saugykla). */
    private final List<Siunta> siuntos = new ArrayList<>();

    /**
     * Konstruktorius — inicializuoja pradines siuntas.
     */
    public SiuntosServiceImpl() {
        inicializuotiDuomenis();
    }

    /**
     * Inicializuoja pradines siuntas su testiniais duomenimis.
     */
    private void inicializuotiDuomenis() {
        List<Produktas> produktai1 = Arrays.asList(
                new Produktas(1, "Nesiojamas kompiuteris", 1, 899.99f, 'A', false),
                new Produktas(2, "Pele", 2, 25.00f, 'B', false)
        );

        List<Produktas> produktai2 = Arrays.asList(
                new Produktas(3, "Knyga", 3, 14.99f, 'B', false),
                new Produktas(4, "Sasiuvinis", 5, 2.50f, 'C', false)
        );

        List<Produktas> produktai3 = Arrays.asList(
                new Produktas(5, "Sporto bateliai", 1, 79.99f, 'A', false),
                new Produktas(6, "Kojines", 4, 4.99f, 'C', false)
        );

        siuntos.add(new Siunta(1, "Jonas Jonaitis",
                "Gedimino pr. 1, Vilnius",
                2.5f, 12.99f, true, 'A', produktai1));

        siuntos.add(new Siunta(2, "Petras Petraitis",
                "Laisves al. 15, Kaunas",
                0.8f, 5.49f, false, 'B', produktai2));

        siuntos.add(new Siunta(3, "Ona Onaite",
                "Tilzes g. 22, Klaipeda",
                5.1f, 18.00f, true, 'A', produktai3));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Siunta> gautiVisasSiuntas() {
        return new ArrayList<>(siuntos);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Siunta gautiSiuntaPagalId(int id) {
        return siuntos.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Siunta pridetiSiunta(Siunta siunta) {
        siuntos.add(siunta);
        return siunta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Siunta atnaujintiStatusa(int id, boolean pristatyta) {
        Siunta siunta = gautiSiuntaPagalId(id);
        if (siunta != null) {
            siunta.setPristatyta(pristatyta);
        }
        return siunta;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean istrintiSiunta(int id) {
        return siuntos.removeIf(s -> s.getId() == id);
    }
}