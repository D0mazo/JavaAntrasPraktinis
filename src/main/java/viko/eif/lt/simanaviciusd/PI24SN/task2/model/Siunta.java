package viko.eif.lt.simanaviciusd.PI24SN.task2.model;

import java.util.List;

/**
 * Klasė, reprezentuojanti siuntą logistikos sistemoje.
 * Siunta turi sąrašą {@link Produktas} objektų.
 */
public class Siunta {

    /** Unikalus siuntos identifikatorius. */
    private int id;

    /** Siuntos gavėjo vardas ir pavardė. */
    private String gavejas;

    /** Pristatymo adresas. */
    private String adresas;

    /** Siuntos svoris kilogramais. */
    private float svoris;

    /** Siuntos pristatymo kaina eurais. */
    private float kaina;

    /** Ar siunta jau pristatyta. */
    private boolean pristatyta;

    /** Siuntos prioriteto lygis (pvz. 'A', 'B', 'C'). */
    private char prioritetas;

    /** Produktų, esančių siuntoje, sąrašas. */
    private List<Produktas> produktai;

    /**
     * Tuščias konstruktorius, reikalingas JAXB serializacijai.
     */
    public Siunta() {
    }

    /**
     * Konstruktorius su visais laukais.
     *
     * @param id          unikalus identifikatorius
     * @param gavejas     gavėjo vardas
     * @param adresas     pristatymo adresas
     * @param svoris      svoris kg
     * @param kaina       pristatymo kaina
     * @param pristatyta  ar pristatyta
     * @param prioritetas prioriteto lygis
     * @param produktai   produktų sąrašas
     */
    public Siunta(int id, String gavejas, String adresas, float svoris,
                  float kaina, boolean pristatyta, char prioritetas,
                  List<Produktas> produktai) {
        this.id = id;
        this.gavejas = gavejas;
        this.adresas = adresas;
        this.svoris = svoris;
        this.kaina = kaina;
        this.pristatyta = pristatyta;
        this.prioritetas = prioritetas;
        this.produktai = produktai;
    }

    /**
     * Grąžina siuntos identifikatorių.
     *
     * @return siuntos id
     */
    public int getId() {
        return id;
    }

    /**
     * Nustato siuntos identifikatorių.
     *
     * @param id siuntos id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Grąžina gavėjo vardą.
     *
     * @return gavėjas
     */
    public String getGavejas() {
        return gavejas;
    }

    /**
     * Nustato gavėjo vardą.
     *
     * @param gavejas gavėjo vardas
     */
    public void setGavejas(String gavejas) {
        this.gavejas = gavejas;
    }

    /**
     * Grąžina pristatymo adresą.
     *
     * @return adresas
     */
    public String getAdresas() {
        return adresas;
    }

    /**
     * Nustato pristatymo adresą.
     *
     * @param adresas pristatymo adresas
     */
    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    /**
     * Grąžina siuntos svorį.
     *
     * @return svoris kg
     */
    public float getSvoris() {
        return svoris;
    }

    /**
     * Nustato siuntos svorį.
     *
     * @param svoris svoris kg
     */
    public void setSvoris(float svoris) {
        this.svoris = svoris;
    }

    /**
     * Grąžina pristatymo kainą.
     *
     * @return kaina eurais
     */
    public float getKaina() {
        return kaina;
    }

    /**
     * Nustato pristatymo kainą.
     *
     * @param kaina kaina eurais
     */
    public void setKaina(float kaina) {
        this.kaina = kaina;
    }

    /**
     * Grąžina ar siunta pristatyta.
     *
     * @return true jei pristatyta, false jei ne
     */
    public boolean isPristatyta() {
        return pristatyta;
    }

    /**
     * Nustato siuntos pristatymo statusą.
     *
     * @param pristatyta pristatymo statusas
     */
    public void setPristatyta(boolean pristatyta) {
        this.pristatyta = pristatyta;
    }

    /**
     * Grąžina siuntos prioritetą.
     *
     * @return prioritetas
     */
    public char getPrioritetas() {
        return prioritetas;
    }

    /**
     * Nustato siuntos prioritetą.
     *
     * @param prioritetas prioriteto lygis
     */
    public void setPrioritetas(char prioritetas) {
        this.prioritetas = prioritetas;
    }

    /**
     * Grąžina produktų sąrašą.
     *
     * @return produktų sąrašas
     */
    public List<Produktas> getProduktai() {
        return produktai;
    }

    /**
     * Nustato produktų sąrašą.
     *
     * @param produktai produktų sąrašas
     */
    public void setProduktai(List<Produktas> produktai) {
        this.produktai = produktai;
    }

    /**
     * Grąžina siuntos tekstinį atvaizdavimą.
     *
     * @return siuntos informacija kaip tekstas
     */
    @Override
    public String toString() {
        return "Siunta{" +
                "id=" + id +
                ", gavejas='" + gavejas + '\'' +
                ", adresas='" + adresas + '\'' +
                ", svoris=" + svoris +
                ", kaina=" + kaina +
                ", pristatyta=" + pristatyta +
                ", prioritetas=" + prioritetas +
                ", produktai=" + produktai +
                '}';
    }
}
