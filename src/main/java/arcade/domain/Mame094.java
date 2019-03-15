//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:34:56 PM BRT 
//

package arcade.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "games" })
@XmlRootElement(name = "mame")
public class Mame094 {

	@XmlAttribute(name = "build")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String build;
	@XmlAttribute(name = "debug")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String debug;
	@XmlAttribute(name = "mameconfig", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String mameconfig;
	@XmlElement(name = "game", required = true)
	protected List<Machine> games;

	/**
	 * Gets the value of the build property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBuild() {
		return build;
	}

	/**
	 * Sets the value of the build property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBuild(String value) {
		this.build = value;
	}

	/**
	 * Gets the value of the debug property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDebug() {
		if (debug == null) {
			return "no";
		} else {
			return debug;
		}
	}

	/**
	 * Sets the value of the debug property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDebug(String value) {
		this.debug = value;
	}

	/**
	 * Gets the value of the mameconfig property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMameconfig() {
		return mameconfig;
	}

	/**
	 * Sets the value of the mameconfig property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMameconfig(String value) {
		this.mameconfig = value;
	}

	public List<Machine> getGames() {
		return games;
	}

	public List<Machine> getMachine() {
		return games;
	}

	public void setGames(List<Machine> games) {
		this.games = games;
	}

}