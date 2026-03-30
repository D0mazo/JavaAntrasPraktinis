package viko.eif.lt.simanaviciusd.PI24SN.task2.client;

import viko.eif.lt.simanaviciusd.PI24SN.task2.generated.SiuntosServiceImplService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.generated.SiuntosService;
import viko.eif.lt.simanaviciusd.PI24SN.task2.generated.Siunta;

import java.util.List;

/**
 * JAX-WS Web serviso klientas, sugeneruotas wsimport įrankiu.
 * Testuoja visas serviso operacijas per sugeneruotą klientą.
 */
public class SiuntosClient {

    /**
     * Pagrindinis metodas, paleidžiantis klientą ir testuojantis servisą.
     *
     * @param args komandinės eilutės argumentai
     */
    public static void main(String[] args) {
        SiuntosServiceImplService service = new SiuntosServiceImplService();
        SiuntosService port = service.getSiuntosServiceImplPort();

        System.out.println("=== Visos siuntos ===");
        List<Siunta> siuntos = port.gautiVisasSiuntas();
        for (Siunta s : siuntos) {
            System.out.println("Siunta #" + s.getId()
                    + " | " + s.getGavejas()
                    + " | " + s.getAdresas()
                    + " | Pristatyta: " + s.isPristatyta());
        }

        System.out.println("\n=== Siunta pagal ID=1 ===");
        Siunta siunta = port.gautiSiuntaPagalId(1);
        if (siunta != null) {
            System.out.println("Rastas: " + siunta.getGavejas()
                    + " | " + siunta.getAdresas());
        }

        System.out.println("\n=== Atnaujinti statusa ID=2 ===");
        Siunta atnaujinta = port.atnaujintiStatusa(2, true);
        if (atnaujinta != null) {
            System.out.println("Atnaujinta: " + atnaujinta.getGavejas()
                    + " | Pristatyta: " + atnaujinta.isPristatyta());
        }

        System.out.println("\n=== Istrinti siunta ID=3 ===");
        boolean istrintas = port.istrintiSiunta(3);
        System.out.println("Istrinta: " + istrintas);

        System.out.println("\n=== Visos siuntos po pakeitimu ===");
        List<Siunta> galutines = port.gautiVisasSiuntas();
        for (Siunta s : galutines) {
            System.out.println("Siunta #" + s.getId()
                    + " | " + s.getGavejas()
                    + " | Pristatyta: " + s.isPristatyta());
        }
    }
}