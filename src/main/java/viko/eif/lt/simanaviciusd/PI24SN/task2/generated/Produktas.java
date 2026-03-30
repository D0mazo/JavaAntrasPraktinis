
package viko.eif.lt.simanaviciusd.PI24SN.task2.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for produktas complex type&lt;/p&gt;.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.&lt;/p&gt;
 * 
 * &lt;pre&gt;{&#064;code
 * &lt;complexType name="produktas"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/&gt;
 *         &lt;element name="kaina" type="{http://www.w3.org/2001/XMLSchema}float" form="qualified"/&gt;
 *         &lt;element name="kategorija" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" form="qualified"/&gt;
 *         &lt;element name="kiekis" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/&gt;
 *         &lt;element name="pavadinimas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/&gt;
 *         &lt;element name="trapus" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * }&lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produktas", propOrder = {
    "id",
    "kaina",
    "kategorija",
    "kiekis",
    "pavadinimas",
    "trapus"
})
public class Produktas {

    protected int id;
    protected float kaina;
    @XmlSchemaType(name = "unsignedShort")
    protected int kategorija;
    protected int kiekis;
    protected String pavadinimas;
    protected boolean trapus;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the kaina property.
     * 
     */
    public float getKaina() {
        return kaina;
    }

    /**
     * Sets the value of the kaina property.
     * 
     */
    public void setKaina(float value) {
        this.kaina = value;
    }

    /**
     * Gets the value of the kategorija property.
     * 
     */
    public int getKategorija() {
        return kategorija;
    }

    /**
     * Sets the value of the kategorija property.
     * 
     */
    public void setKategorija(int value) {
        this.kategorija = value;
    }

    /**
     * Gets the value of the kiekis property.
     * 
     */
    public int getKiekis() {
        return kiekis;
    }

    /**
     * Sets the value of the kiekis property.
     * 
     */
    public void setKiekis(int value) {
        this.kiekis = value;
    }

    /**
     * Gets the value of the pavadinimas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPavadinimas() {
        return pavadinimas;
    }

    /**
     * Sets the value of the pavadinimas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPavadinimas(String value) {
        this.pavadinimas = value;
    }

    /**
     * Gets the value of the trapus property.
     * 
     */
    public boolean isTrapus() {
        return trapus;
    }

    /**
     * Sets the value of the trapus property.
     * 
     */
    public void setTrapus(boolean value) {
        this.trapus = value;
    }

}
