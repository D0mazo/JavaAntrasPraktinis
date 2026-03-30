package viko.eif.lt.simanaviciusd.PI24SN.task2.model;

/**
 * Klasė, reprezentuojanti produktą siuntoje.
 */
public class Produktas {

    /** Unikalus produkto identifikatorius. */
    private int id;

    /** Produkto pavadinimas. */
    private String pavadinimas;

    /** Produkto kiekis. */
    private int kiekis;

    /** Produkto kaina eurais. */
    private float kaina;

    /** Produkto kategorijos simbolis (pvz. 'A', 'B', 'C'). */
    private char kategorija;

    /** Ar produktas yra trapus. */
    private boolean trapus;

    /**
     * Tuščias konstruktorius, reikalingas JAXB serializacijai.
     */
    public Produktas() {
    }

    /**
     * Konstruktorius su visais laukais.
     *
     * @param id          unikalus identifikatorius
     * @param pavadinimas produkto pavadinimas
     * @param kiekis      produkto kiekis
     * @param kaina       produkto kaina
     * @param kategorija  produkto kategorija
     * @param trapus      ar produktas trapus
     */
    public Produktas(int id, String pavadinimas, int kiekis,
                     float kaina, char kategorija, boolean trapus) {
        this.id = id;
        this.pavadinimas = pavadinimas;
        this.kiekis = kiekis;
        this.kaina = kaina;
        this.kategorija = kategorija;
        this.trapus = trapus;
    }

    /**
     * Grąžina produkto identifikatorių.
     *
     * @return produkto id
     */
    public int getId() {
        return id;
    }

    /**
     * Nustato produkto identifikatorių.
     *
     * @param id produkto id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Grąžina produkto pavadinimą.
     *
     * @return pavadinimas
     */
    public String getPavadinimas() {
        return pavadinimas;
    }

    /**
     * Nustato produkto pavadinimą.
     *
     * @param pavadinimas produkto pavadinimas
     */
    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    /**
     * Grąžina produkto kiekį.
     *
     * @return kiekis
     */
    public int getKiekis() {
        return kiekis;
    }

    /**
     * Nustato produkto kiekį.
     *
     * @param kiekis produkto kiekis
     */
    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    /**
     * Grąžina produkto kainą.
     *
     * @return kaina
     */
    public float getKaina() {
        return kaina;
    }

    /**
     * Nustato produkto kainą.
     *
     * @param kaina produkto kaina
     */
    public void setKaina(float kaina) {
        this.kaina = kaina;
    }

    /**
     * Grąžina produkto kategoriją.
     *
     * @return kategorija
     */
    public char getKategorija() {
        return kategorija;
    }

    /**
     * Nustato produkto kategoriją.
     *
     * @param kategorija produkto kategorija
     */
    public void setKategorija(char kategorija) {
        this.kategorija = kategorija;
    }

    /**
     * Grąžina ar produktas yra trapus.
     *
     * @return true jei trapus, false jei ne
     */
    public boolean isTrapus() {
        return trapus;
    }

    /**
     * Nustato ar produktas yra trapus.
     *
     * @param trapus trapumo požymis
     */
    public void setTrapus(boolean trapus) {
        this.trapus = trapus;
    }

    /**
     * Grąžina produkto tekstinį atvaizdavimą.
     *
     * @return produkto informacija kaip tekstas
     */
    @Override
    public String toString() {
        return "Produktas{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", kiekis=" + kiekis +
                ", kaina=" + kaina +
                ", kategorija=" + kategorija +
                ", trapus=" + trapus +
                '}';
    }
}