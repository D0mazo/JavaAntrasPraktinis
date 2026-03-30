
package viko.eif.lt.simanaviciusd.PI24SN.task2.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for pridetiSiunta complex type&lt;/p&gt;.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.&lt;/p&gt;
 * 
 * &lt;pre&gt;{&#064;code
 * &lt;complexType name="pridetiSiunta"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="siunta" type="{http://service.task2.PI24SN.simanaviciusd.lt.eif.viko/}siunta" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * }&lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pridetiSiunta", propOrder = {
    "siunta"
})
public class PridetiSiunta {

    @XmlElement(namespace = "")
    protected Siunta siunta;

    /**
     * Gets the value of the siunta property.
     * 
     * @return
     *     possible object is
     *     {@link Siunta }
     *     
     */
    public Siunta getSiunta() {
        return siunta;
    }

    /**
     * Sets the value of the siunta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Siunta }
     *     
     */
    public void setSiunta(Siunta value) {
        this.siunta = value;
    }

}
