package arcade.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class LogiqxGame {
	@XmlAttribute
	private String name;

	@XmlAttribute
	private String sourcefile;

	@XmlAttribute
	private String cloneof;

	@XmlAttribute
	private String romof;

	@XmlAttribute
	private String isbios;

	private String category;

	private String description;

	private String year;

	private String manufacturer;

	private String system;

	@XmlElement
	private LogiqxRom rom;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the rom //
	 */
	public LogiqxRom getRom() {
		return rom;
	}

	/**
	 * @param rom
	 *            the rom to set
	 */
	public void setRom(LogiqxRom rom) {
		this.rom = rom;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSourcefile() {
		return sourcefile;
	}

	public void setSourcefile(String sourcefile) {
		this.sourcefile = sourcefile;
	}

	public String getCloneof() {
		return cloneof;
	}

	public void setCloneof(String cloneof) {
		this.cloneof = cloneof;
	}

	public String getRomof() {
		return romof;
	}

	public void setRomof(String romof) {
		this.romof = romof;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getIsbios() {
		return isbios;
	}

	public void setIsbios(String isbios) {
		this.isbios = isbios;
	}

}
