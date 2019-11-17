//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.06 at 10:13:38 PM BRT 
//

package arcade.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "description", "year", "publisher", "info" }) // , "sharedfeat", "part" })
@XmlRootElement(name = "software")
public class Software {

	@XmlAttribute(name = "name", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String name;
	@XmlAttribute(name = "cloneof")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String cloneof;
	@XmlAttribute(name = "supported")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String supported;
	@XmlElement(required = true)
	protected String description;
	@XmlElement(required = true)
	protected String year;
	@XmlElement(required = true)
	protected String publisher;
	protected List<Info> info;
	@XmlTransient
	protected List<Sharedfeat> sharedfeat;
	@XmlTransient
	protected List<Part> part;

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the cloneof property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCloneof() {
		return cloneof;
	}

	/**
	 * Sets the value of the cloneof property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setCloneof(String value) {
		this.cloneof = value;
	}

	/**
	 * Gets the value of the supported property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSupported() {
		if (supported == null) {
			return "yes";
		} else {
			return supported;
		}
	}

	/**
	 * Sets the value of the supported property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSupported(String value) {
		this.supported = value;
	}

	/**
	 * Gets the value of the description property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the value of the description property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescription(String value) {
		this.description = value;
	}

	/**
	 * Gets the value of the year property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the value of the year property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setYear(String value) {
		this.year = value;
	}

	/**
	 * Gets the value of the publisher property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the value of the publisher property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPublisher(String value) {
		this.publisher = value;
	}

	/**
	 * Gets the value of the info property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the info property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getInfo().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Info }
	 * 
	 * 
	 */
	public List<Info> getInfo() {
		if (info == null) {
			info = new ArrayList<Info>();
		}
		return this.info;
	}

	/**
	 * Gets the value of the sharedfeat property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the sharedfeat property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSharedfeat().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Sharedfeat }
	 * 
	 * 
	 */
	public List<Sharedfeat> getSharedfeat() {
		if (sharedfeat == null) {
			sharedfeat = new ArrayList<Sharedfeat>();
		}
		return this.sharedfeat;
	}

	/**
	 * Gets the value of the part property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the part property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPart().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Part }
	 * 
	 * 
	 */
	public List<Part> getPart() {
		if (part == null) {
			part = new ArrayList<Part>();
		}
		return this.part;
	}

}