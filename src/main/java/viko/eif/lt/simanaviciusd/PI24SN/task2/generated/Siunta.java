
package viko.eif.lt.simanaviciusd.PI24SN.task2.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for siunta complex type&lt;/p&gt;.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.&lt;/p&gt;
 * 
 * &lt;pre&gt;{&#064;code
 * &lt;complexType name="siunta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="adresas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/&gt;
 *         &lt;element name="gavejas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/&gt;
 *         &lt;element name="kaina" type="{http://www.w3.org/2001/XMLSchema}float" form="qualified"/&gt;
 *         &lt;element name="prioritetas" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" form="qualified"/&gt;
 *         &lt;element name="pristatyta" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/&gt;
 *         &lt;element name="produktai" type="{http://service.task2.PI24SN.simanaviciusd.lt.eif.viko/}produktas" maxOccurs="unbounded" minOccurs="0" form="qualified"/&gt;
 *         &lt;element name="svoris" type="{http://www.w3.org/2001/XMLSchema}float" form="qualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * }&lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "siunta", propOrder = {
    "adresas",
    "gavejas",
    "id",
    "kaina",
    "prioritetas",
    "pristatyta",
    "produktai",
    "svoris"
})
public class Siunta {

    protected String adresas;
    protected String gavejas;
    protected int id;
    protected float kaina;
    @XmlSchemaType(name = "unsignedShort")
    protected int prioritetas;
    protected boolean pristatyta;
    @XmlElement(nillable = true)
    protected List<Produktas> produktai;
    protected float svoris;

    /**
     * Gets the value of the adresas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresas() {
        return adresas;
    }

    /**
     * Sets the value of the adresas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresas(String value) {
        this.adresas = value;
    }

    /**
     * Gets the value of the gavejas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGavejas() {
        return gavejas;
    }

    /**
     * Sets the value of the gavejas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGavejas(String value) {
        this.gavejas = value;
    }

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
     * Gets the value of the prioritetas property.
     * 
     */
    public int getPrioritetas() {
        return prioritetas;
    }

    /**
     * Sets the value of the prioritetas property.
     * 
     */
    public void setPrioritetas(int value) {
        this.prioritetas = value;
    }

    /**
     * Gets the value of the pristatyta property.
     * 
     */
    public boolean isPristatyta() {
        return pristatyta;
    }

    /**
     * Sets the value of the pristatyta property.
     * 
     */
    public void setPristatyta(boolean value) {
        this.pristatyta = value;
    }

    /**
     * Gets the value of the produktai property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the produktai property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getProduktai().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Produktas }
     * </p>
     * 
     * 
     * @return
     *     The value of the produktai property.
     */
    public List<Produktas> getProduktai() {
        if (produktai == null) {
            produktai = new ArrayList<>();
        }
        return this.produktai;
    }

    /**
     * Gets the value of the svoris property.
     * 
     */
    public float getSvoris() {
        return svoris;
    }

    /**
     * Sets the value of the svoris property.
     * 
     */
    public void setSvoris(float value) {
        this.svoris = value;
    }

}
