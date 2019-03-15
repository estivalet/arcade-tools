package arcade.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "game")
@XmlAccessorType(XmlAccessType.FIELD)
public class MameInfo {
	@XmlAttribute
	private String rom;
	private String info;
	private String category;
	private String genre;
	private String verAdded;
	private String history;

	/**
	 * @return the rom
	 */
	public String getRom() {
		return rom;
	}

	/**
	 * @param rom
	 *            the rom to set
	 */
	public void setRom(String rom) {
		this.rom = rom;
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
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the verAdded
	 */
	public String getVerAdded() {
		return verAdded;
	}

	/**
	 * @param verAdded
	 *            the verAdded to set
	 */
	public void setVerAdded(String verAdded) {
		this.verAdded = verAdded;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * @param history
	 *            the history to set
	 */
	public void setHistory(String history) {
		this.history = history;
	}

}
