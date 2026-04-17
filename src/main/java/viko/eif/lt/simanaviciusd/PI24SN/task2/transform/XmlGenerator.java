package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Produktas;
import viko.eif.lt.simanaviciusd.PI24SN.task2.model.Siunta;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;


/**
 * Klasė, generuojanti XML failą iš serviso duomenų.
 */
public class XmlGenerator {

    /**
     * Generuoja XML failą iš siuntų sąrašo.
     *
     * @param siuntos siuntų sąrašas
     * @param xmlFile išvesties XML failas
     * @throws Exception jei nepavyksta rašyti į failą
     */
    public void generate(List<Siunta> siuntos, File xmlFile) throws Exception {
        try (PrintWriter writer = new PrintWriter(xmlFile, "UTF-8")) {
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<siuntos>");

            for (Siunta s : siuntos) {
                writer.println("    <siunta>");
                writer.println("        <id>" + s.getId() + "</id>");
                writer.println("        <gavėjas>" + s.getGavejas() + "</gavėjas>");
                writer.println("        <adresas>" + s.getAdresas() + "</adresas>");
                writer.println("        <svoris>" + s.getSvoris() + "</svoris>");
                writer.println("        <kaina>" + s.getKaina() + "</kaina>");
                writer.println("        <pristatyta>" + s.isPristatyta() + "</pristatyta>");
                writer.println("        <prioritetas>" + s.getPrioritetas() + "</prioritetas>");
                writer.println("        <produktai>");

                for (Produktas p : s.getProduktai()) {
                    writer.println("            <produktas>");
                    writer.println("                <id>" + p.getId() + "</id>");
                    writer.println("                <pavadinimas>" + p.getPavadinimas() + "</pavadinimas>");
                    writer.println("                <kiekis>" + p.getKiekis() + "</kiekis>");
                    writer.println("                <kaina>" + p.getKaina() + "</kaina>");
                    writer.println("            </produktas>");
                }

                writer.println("        </produktai>");
                writer.println("    </siunta>");
            }

            writer.println("</siuntos>");
        }
        System.out.println("XML sugeneruotas iš serviso duomenų: "
                + xmlFile.getAbsolutePath());
    }
}