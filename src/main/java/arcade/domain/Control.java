//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:34:56 PM BRT 
//


package arcade.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "control")
public class Control {

    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "minimum")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String minimum;
    @XmlAttribute(name = "maximum")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maximum;
    @XmlAttribute(name = "sensitivity")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String sensitivity;
    @XmlAttribute(name = "keydelta")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String keydelta;
    @XmlAttribute(name = "reverse")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String reverse;
    @XmlAttribute(name = "ways")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ways;
    @XmlAttribute(name = "ways2")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ways2;
    @XmlAttribute(name = "ways3")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String ways3;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the minimum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinimum() {
        return minimum;
    }

    /**
     * Sets the value of the minimum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimum(String value) {
        this.minimum = value;
    }

    /**
     * Gets the value of the maximum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximum() {
        return maximum;
    }

    /**
     * Sets the value of the maximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximum(String value) {
        this.maximum = value;
    }

    /**
     * Gets the value of the sensitivity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSensitivity() {
        return sensitivity;
    }

    /**
     * Sets the value of the sensitivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSensitivity(String value) {
        this.sensitivity = value;
    }

    /**
     * Gets the value of the keydelta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeydelta() {
        return keydelta;
    }

    /**
     * Sets the value of the keydelta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeydelta(String value) {
        this.keydelta = value;
    }

    /**
     * Gets the value of the reverse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReverse() {
        if (reverse == null) {
            return "no";
        } else {
            return reverse;
        }
    }

    /**
     * Sets the value of the reverse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReverse(String value) {
        this.reverse = value;
    }

    /**
     * Gets the value of the ways property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWays() {
        return ways;
    }

    /**
     * Sets the value of the ways property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWays(String value) {
        this.ways = value;
    }

    /**
     * Gets the value of the ways2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWays2() {
        return ways2;
    }

    /**
     * Sets the value of the ways2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWays2(String value) {
        this.ways2 = value;
    }

    /**
     * Gets the value of the ways3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWays3() {
        return ways3;
    }

    /**
     * Sets the value of the ways3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWays3(String value) {
        this.ways3 = value;
    }

}