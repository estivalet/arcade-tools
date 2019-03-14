//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.28 at 02:34:56 PM BRT 
//

package arcade.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
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
@XmlType(name = "", propOrder = { "description", "year", "manufacturer", "gameManufacturer", "biosset", "rom", "disk",
		"deviceRef", "sample", "chip", "display", "sound", "input", "dipswitch", "configuration", "port", "adjuster",
		"driver", "device", "slot", "softwarelist", "ramoption", "platform", "romCatalog", "id", "shortName", "info",
		"driverInfo", "history", "cheat", "genre", "verAdded", "synopsis", "players" })
@XmlRootElement(name = "machine")
public class Machine {

	@XmlAttribute(name = "name", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String name;
	@XmlAttribute(name = "sourcefile")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String sourcefile;
	@XmlAttribute(name = "isbios")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String isbios;
	@XmlAttribute(name = "isdevice")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String isdevice;
	@XmlAttribute(name = "ismechanical")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String ismechanical;
	@XmlAttribute(name = "runnable")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String runnable;
	@XmlAttribute(name = "cloneof")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String cloneof;
	@XmlAttribute(name = "romof")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String romof;
	@XmlAttribute(name = "sampleof")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String sampleof;
	@XmlElement(required = true)
	protected String description;
	protected String year;
	protected GameManufacturer gameManufacturer;
	protected String manufacturer;
	protected List<BiosSet> biosset = new ArrayList<BiosSet>();
	protected List<Rom> rom = new ArrayList<Rom>();
	protected List<Disk> disk = new ArrayList<Disk>();
	@XmlElement(name = "device_ref")
	protected List<DeviceRef> deviceRef = new ArrayList<DeviceRef>();
	protected List<Sample> sample = new ArrayList<Sample>();
	protected List<Chip> chip = new ArrayList<Chip>();
	protected List<Display> display = new ArrayList<Display>();
	protected Sound sound;
	protected Input input;
	protected List<DipSwitch> dipswitch = new ArrayList<DipSwitch>();
	protected List<Configuration> configuration = new ArrayList<Configuration>();
	protected List<Port> port = new ArrayList<Port>();
	protected List<Adjuster> adjuster = new ArrayList<Adjuster>();
	protected Driver driver;
	protected List<Device> device = new ArrayList<Device>();
	protected List<Slot> slot = new ArrayList<Slot>();
	protected List<Softwarelist> softwarelist = new ArrayList<Softwarelist>();
	protected List<Ramoption> ramoption = new ArrayList<Ramoption>();
	private Platform platform;
	private RomCatalog romCatalog;
	private BigDecimal id = new BigDecimal(-1);
	private String shortName;
	private String info;
	private String driverInfo;
	private String history;
	private String cheat;
	private String genre;
	private String verAdded;
	private String players;
	private String synopsis;

	public void addRom(Rom r) {
		this.rom.add(r);
	}

	public void addChip(Chip c) {
		this.chip.add(c);
	}

	public void addPort(Port p) {
		this.port.add(p);
	}

	public void addDisplay(Display d) {
		this.display.add(d);
	}

	public void addDipSwitch(DipSwitch d) {
		this.dipswitch.add(d);
	}

	public void addDisk(Disk d) {
		this.disk.add(d);
	}

	public void addBiosSet(BiosSet b) {
		this.biosset.add(b);
	}

	public void addSample(Sample s) {
		this.sample.add(s);
	}

	public void setPlatform(Platform p) {
		this.platform = p;
	}

	public Platform getPlatform() {
		return this.platform;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

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
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the sourcefile property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSourcefile() {
		return sourcefile;
	}

	/**
	 * Sets the value of the sourcefile property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSourcefile(String value) {
		this.sourcefile = value;
	}

	/**
	 * Gets the value of the isbios property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIsbios() {
		if (isbios == null) {
			return "no";
		} else {
			return isbios;
		}
	}

	/**
	 * Sets the value of the isbios property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIsbios(String value) {
		this.isbios = value;
	}

	/**
	 * Gets the value of the isdevice property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIsdevice() {
		if (isdevice == null) {
			return "no";
		} else {
			return isdevice;
		}
	}

	/**
	 * Sets the value of the isdevice property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIsdevice(String value) {
		this.isdevice = value;
	}

	/**
	 * Gets the value of the ismechanical property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIsmechanical() {
		if (ismechanical == null) {
			return "no";
		} else {
			return ismechanical;
		}
	}

	/**
	 * Sets the value of the ismechanical property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIsmechanical(String value) {
		this.ismechanical = value;
	}

	/**
	 * Gets the value of the runnable property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRunnable() {
		if (runnable == null) {
			return "yes";
		} else {
			return runnable;
		}
	}

	/**
	 * Sets the value of the runnable property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRunnable(String value) {
		this.runnable = value;
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
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCloneof(String value) {
		this.cloneof = value;
	}

	/**
	 * Gets the value of the romof property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRomof() {
		return romof;
	}

	/**
	 * Sets the value of the romof property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRomof(String value) {
		this.romof = value;
	}

	/**
	 * Gets the value of the sampleof property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSampleof() {
		return sampleof;
	}

	/**
	 * Sets the value of the sampleof property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSampleof(String value) {
		this.sampleof = value;
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
	 * @param value
	 *            allowed object is {@link String }
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
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setYear(String value) {
		this.year = value;
	}

	/**
	 * Gets the value of the manufacturer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public GameManufacturer getGameManufacturer() {
		return gameManufacturer;
	}

	/**
	 * Sets the value of the manufacturer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGameManufacturer(GameManufacturer value) {
		this.gameManufacturer = value;
	}

	/**
	 * Gets the value of the biosset property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the biosset property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBiosset().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link BiosSet }
	 * 
	 * 
	 */
	public List<BiosSet> getBiosset() {
		if (biosset == null) {
			biosset = new ArrayList<BiosSet>();
		}
		return this.biosset;
	}

	/**
	 * Gets the value of the rom property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the rom property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRom().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Rom }
	 * 
	 * 
	 */
	public List<Rom> getRom() {
		if (rom == null) {
			rom = new ArrayList<Rom>();
		}
		return this.rom;
	}

	/**
	 * Gets the value of the disk property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the disk property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDisk().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Disk }
	 * 
	 * 
	 */
	public List<Disk> getDisk() {
		if (disk == null) {
			disk = new ArrayList<Disk>();
		}
		return this.disk;
	}

	/**
	 * Gets the value of the deviceRef property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the deviceRef property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDeviceRef().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DeviceRef }
	 * 
	 * 
	 */
	public List<DeviceRef> getDeviceRef() {
		if (deviceRef == null) {
			deviceRef = new ArrayList<DeviceRef>();
		}
		return this.deviceRef;
	}

	/**
	 * Gets the value of the sample property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the sample property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSample().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Sample }
	 * 
	 * 
	 */
	public List<Sample> getSample() {
		if (sample == null) {
			sample = new ArrayList<Sample>();
		}
		return this.sample;
	}

	/**
	 * Gets the value of the chip property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the chip property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getChip().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Chip }
	 * 
	 * 
	 */
	public List<Chip> getChip() {
		if (chip == null) {
			chip = new ArrayList<Chip>();
		}
		return this.chip;
	}

	/**
	 * Gets the value of the display property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the display property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDisplay().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Display }
	 * 
	 * 
	 */
	public List<Display> getDisplay() {
		if (display == null) {
			display = new ArrayList<Display>();
		}
		return this.display;
	}

	/**
	 * Gets the value of the sound property.
	 * 
	 * @return possible object is {@link Sound }
	 * 
	 */
	public Sound getSound() {
		return sound;
	}

	/**
	 * Sets the value of the sound property.
	 * 
	 * @param value
	 *            allowed object is {@link Sound }
	 * 
	 */
	public void setSound(Sound value) {
		this.sound = value;
	}

	/**
	 * Gets the value of the input property.
	 * 
	 * @return possible object is {@link Input }
	 * 
	 */
	public Input getInput() {
		return input;
	}

	/**
	 * Sets the value of the input property.
	 * 
	 * @param value
	 *            allowed object is {@link Input }
	 * 
	 */
	public void setInput(Input value) {
		this.input = value;
	}

	/**
	 * Gets the value of the dipswitch property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the dipswitch property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDipswitch().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link DipSwitch }
	 * 
	 * 
	 */
	public List<DipSwitch> getDipswitch() {
		if (dipswitch == null) {
			dipswitch = new ArrayList<DipSwitch>();
		}
		return this.dipswitch;
	}

	/**
	 * Gets the value of the configuration property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the configuration property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConfiguration().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Configuration
	 * }
	 * 
	 * 
	 */
	public List<Configuration> getConfiguration() {
		if (configuration == null) {
			configuration = new ArrayList<Configuration>();
		}
		return this.configuration;
	}

	/**
	 * Gets the value of the port property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the port property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPort().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Port }
	 * 
	 * 
	 */
	public List<Port> getPort() {
		if (port == null) {
			port = new ArrayList<Port>();
		}
		return this.port;
	}

	/**
	 * Gets the value of the adjuster property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the adjuster property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAdjuster().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Adjuster }
	 * 
	 * 
	 */
	public List<Adjuster> getAdjuster() {
		if (adjuster == null) {
			adjuster = new ArrayList<Adjuster>();
		}
		return this.adjuster;
	}

	/**
	 * Gets the value of the driver property.
	 * 
	 * @return possible object is {@link Driver }
	 * 
	 */
	public Driver getDriver() {
		return driver;
	}

	/**
	 * Sets the value of the driver property.
	 * 
	 * @param value
	 *            allowed object is {@link Driver }
	 * 
	 */
	public void setDriver(Driver value) {
		this.driver = value;
	}

	/**
	 * Gets the value of the device property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the device property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getDevice().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Device }
	 * 
	 * 
	 */
	public List<Device> getDevice() {
		if (device == null) {
			device = new ArrayList<Device>();
		}
		return this.device;
	}

	/**
	 * Gets the value of the slot property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the slot property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSlot().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Slot }
	 * 
	 * 
	 */
	public List<Slot> getSlot() {
		if (slot == null) {
			slot = new ArrayList<Slot>();
		}
		return this.slot;
	}

	/**
	 * Gets the value of the softwarelist property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the softwarelist property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getSoftwarelist().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Softwarelist
	 * }
	 * 
	 * 
	 */
	public List<Softwarelist> getSoftwarelist() {
		if (softwarelist == null) {
			softwarelist = new ArrayList<Softwarelist>();
		}
		return this.softwarelist;
	}

	/**
	 * Gets the value of the ramoption property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the ramoption property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRamoption().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Ramoption }
	 * 
	 * 
	 */
	public List<Ramoption> getRamoption() {
		if (ramoption == null) {
			ramoption = new ArrayList<Ramoption>();
		}
		return this.ramoption;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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
	 * @return the driverInfo
	 */
	public String getDriverInfo() {
		return driverInfo;
	}

	/**
	 * @param driverInfo
	 *            the driverInfo to set
	 */
	public void setDriverInfo(String driverInfo) {
		this.driverInfo = driverInfo;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getCheat() {
		return cheat;
	}

	public void setCheat(String cheat) {
		this.cheat = cheat;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getVerAdded() {
		return verAdded;
	}

	public void setVerAdded(String verAdded) {
		this.verAdded = verAdded;
	}

	public RomCatalog getRomCatalog() {
		return romCatalog;
	}

	public void setRomCatalog(RomCatalog romCatalog) {
		this.romCatalog = romCatalog;
	}

	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public boolean isDemo() {
		return this.getDescription().toLowerCase().contains("[demo");
	}

	public boolean isHomebrew() {
		return this.getDescription().toLowerCase().contains("homebrew");
	}

}
