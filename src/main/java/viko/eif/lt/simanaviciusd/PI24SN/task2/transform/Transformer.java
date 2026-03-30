package viko.eif.lt.simanaviciusd.PI24SN.task2.transform;

import javax.xml.transform.TransformerException;
import java.io.File;

/**
 * Sąsaja XML transformacijoms.
 * Leidžia įgyvendinti skirtingus transformacijų tipus.
 */
public interface Transformer {

    /**
     * Transformuoja XML failą į išvesties failą.
     *
     * @param xmlFile    įvesties XML failas
     * @param outputFile išvesties failas
     * @throws Exception jei transformacija nepavyksta
     */
    void transform(File xmlFile, File outputFile) throws Exception;
}