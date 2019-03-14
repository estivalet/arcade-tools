package arcade.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "platform")
@XmlAccessorType(XmlAccessType.FIELD)
public class Platform {
	private BigDecimal id;
	private PlatformType platformType;
	@XmlElement(name = "spec")
	private List<PlatformSpec> platformSpecs = new ArrayList<PlatformSpec>();
	@XmlElement(name = "game")
	private List<Machine> games = new ArrayList<Machine>();
	private PlatformManufacturer manufacturer;
	private String name;
	private String description;
	private String origin;
	private String year;
	private String price;
	private String endOfProduction;

	public void addPlatformSpec(PlatformSpec spec) {
		this.platformSpecs.add(spec);
	}

	public void setPlatformSpecs(List<PlatformSpec> platformSpecs) {
		this.platformSpecs = platformSpecs;
	}

	public List<Machine> getGames() {
		return games;
	}

	public void setGames(List<Machine> games) {
		this.games = games;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public PlatformType getPlatformType() {
		return platformType;
	}

	public void setPlatformType(PlatformType platformType) {
		this.platformType = platformType;
	}

	public PlatformManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(PlatformManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getEndOfProduction() {
		return endOfProduction;
	}

	public void setEndOfProduction(String endOfProduction) {
		this.endOfProduction = endOfProduction;
	}

}
