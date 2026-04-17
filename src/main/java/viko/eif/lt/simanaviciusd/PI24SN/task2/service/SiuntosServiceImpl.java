package viko.eif.lt.simanaviciusd.PI24SN.task2.service;

import jakarta.jws.WebService;
import org.springframework.stereotype.Component;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;
import viko.eif.lt.simanaviciusd.PI24SN.task2.repository.SiuntosRepository;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.HtmlTransformer;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.PdfTransformer;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.TransformationService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.transform.XmlGenerator;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * JAX-WS Web serviso implementacija siuntos operacijoms.
 * Realizuoja {@link SiuntosService} sąsają.
 * Duomenys saugomi SQLite duomenų bazėje.
 * Po kiekvieno pakeitimo automatiškai regeneruojami HTML ir PDF failai.
 */
@Component
@WebService(endpointInterface =
        "viko.eif.lt.simanaviciusd.PI24SN.task2.service.SiuntosService")
public class SiuntosServiceImpl implements SiuntosService {

    /** Siuntų repozitorija darbui su duomenų baze. */
    private final SiuntosRepository repository;

    /** XML generatorius. */
    private final XmlGenerator xmlGenerator;

    /** Transformacijos servisas HTML ir PDF generavimui. */
    private final TransformationService transformationService;

    /**
     * Konstruktorius su repozitorija (Dependency Injection).
     *
     * @param repository siuntų repozitorija
     */
    public SiuntosServiceImpl(SiuntosRepository repository) {
        this.repository = repository;
        this.xmlGenerator = new XmlGenerator();
        this.transformationService = new TransformationService(
                new HtmlTransformer(),
                new PdfTransformer()
        );
        inicializuotiDuomenis();
    }

    /**
     * Inicializuoja pradines siuntas jei duomenų bazė tuščia.
     */
    private void inicializuotiDuomenis() {
        if (repository.count() > 0) {
            return;
        }

        List<Produktas> produktai1 = Arrays.asList(
                new Produktas(0, "Nesiojamas kompiuteris", 1, 899.99f, 'A', false),
                new Produktas(0, "Pele", 2, 25.00f, 'B', false)
        );

        List<Produktas> produktai2 = Arrays.asList(
                new Produktas(0, "Knyga", 3, 14.99f, 'B', false),
                new Produktas(0, "Sasiuvinis", 5, 2.50f, 'C', false)
        );

        List<Produktas> produktai3 = Arrays.asList(
                new Produktas(0, "Sporto bateliai", 1, 79.99f, 'A', false),
                new Produktas(0, "Kojines", 4, 4.99f, 'C', false)
        );

        repository.save(new Siunta(0, "Jonas Jonaitis",
                "Gedimino pr. 1, Vilnius",
                2.5f, 12.99f, true, 'A', produktai1));

        repository.save(new Siunta(0, "Petras Petraitis",
                "Laisves al. 15, Kaunas",
                0.8f, 5.49f, false, 'B', produktai2));

        repository.save(new Siunta(0, "Ona Onaite",
                "Tilzes g. 22, Klaipeda",
                5.1f, 18.00f, true, 'A', produktai3));
    }

    /**
     * Regeneruoja HTML ir PDF failus iš dabartinių duomenų bazės duomenų.
     */
    private void regeneruotiFailus() {
        try {
            File xmlFile = new File("generated-data.xml");
            xmlGenerator.generate(gautiVisasSiuntas(), xmlFile);
            transformationService.transformToHtml("output.html", xmlFile);
            transformationService.transformToPdf("output.pdf", xmlFile);
            System.out.println("HTML ir PDF automatiškai atnaujinti!");
        } catch (Exception e) {
            System.err.println("Regeneravimo klaida: " + e.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Siunta> gautiVisasSiuntas() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Siunta gautiSiuntaPagalId(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Siunta pridetiSiunta(Siunta siunta) {
        Siunta issaugota = repository.save(siunta);
        regeneruotiFailus();
        return issaugota;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Siunta atnaujintiStatusa(int id, boolean pristatyta) {
        Siunta siunta = gautiSiuntaPagalId(id);
        if (siunta != null) {
            siunta.setPristatyta(pristatyta);
            Siunta atnaujinta = repository.save(siunta);
            regeneruotiFailus();
            return atnaujinta;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean istrintiSiunta(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            regeneruotiFailus();
            return true;
        }
        return false;
    }
}