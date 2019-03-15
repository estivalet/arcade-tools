package arcade.tools;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import arcade.domain.LogiqxGame;
import arcade.domain.Machine;
import arcade.parsers.CatverIniFile;
import arcade.parsers.EmulatorCfgFile;
import arcade.parsers.LogiqxDataFile;
import arcade.parsers.MameXmlFile;

public class FilterArcadeGames {

	/** Keep machines for the final list. */
	private Map<String, Machine> machines = new TreeMap<String, Machine>();

	private CatverIniFile cif;

	private EmulatorCfgFile ecf;

	/** Excluded genres. (Removed "Misc.") */
	private String[] genresToExclude = { "Casino", "Puzzle", "Slot Machine", "Quiz", "Tabletop", "Mahjong", "Mature",
			"Pinball", "Board Game", "Chess Machine", "System", "Device", "Cards", "Utilities", "Update",
			"Game Console", "Computer /", "Rhythm", "MultiGame", "Calculator" };

	private boolean includeClone = false;

	private boolean includeDemo = false;

	private boolean includeHomebrew = false;

	private boolean filterCategory = false;

	private String manufacturer;

	/**
	 * @throws Exception
	 */
	public FilterArcadeGames() throws Exception {
		// Load genre and version added.
		cif = new CatverIniFile();
		cif.parse();

		// Load the retropie emulator configured.
		ecf = new EmulatorCfgFile();
		ecf.parse();

	}

	/**
	 * Check if is a genre allowed.
	 * 
	 * @param genre
	 * @return
	 */
	private boolean genreAllowed(String genre) {
		for (String g : this.genresToExclude) {
			if (genre.contains(g)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param clone
	 * @param bios
	 * @param demo
	 * @param homebrew
	 * @param genre
	 * @return
	 */
	private boolean shouldIncludeGame(Machine m) {
		// for mame sets
		if ("no".equals(m.getRunnable())) {
			return false;
		}

		// for mame sets
		if (m.getSoftwarelist().size() > 0) {
			return false;
		}

		// If bios not include by default
		if (!m.getIsbios().equals("no")) {
			return false;
		}

		// Check clone flag to include game or not.
		if (!this.includeClone && m.getCloneof() != null) {
			return false;
		}

		// Check demo flag to include game or not.
		if (!this.includeDemo && m.isDemo()) {
			return false;
		}

		// Check homebrew flag to include game or not.
		if (!this.includeHomebrew && m.isHomebrew()) {
			return false;
		}

		// Check manufacturer
		if (m.getManufacturer() != null && this.manufacturer != null
				&& !m.getManufacturer().toLowerCase().contains(this.manufacturer.toLowerCase())) {
			return false;
		}

		// Check genre
		if (this.filterCategory) {
			if (m.getCategory() != null) {
				if (!genreAllowed(m.getCategory())) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * @param xmlFile
	 *            XML file with the games meta data.
	 * @param emulator
	 *            emulator to be used by default for each game.
	 * @throws Exception
	 */
	public void finalBurnAlpha(String xmlFile, String emulator) throws Exception {
		LogiqxDataFile ldf = new LogiqxDataFile();
		LogiqxDataFile dataFile = ldf.parse("/arcade-files/" + xmlFile);

		for (LogiqxGame g : dataFile.getGames()) {
			// Need to convert to Machine class.
			Machine m = new Machine();
			m.setName(g.getName());
			m.setDescription(g.getDescription());
			m.setYear(g.getYear());
			m.setCloneof(g.getCloneof());
			m.setCategory(cif.getCategory(g.getName()));
			m.setManufacturer(g.getManufacturer());
			m.setRomof(g.getRomof());
			m.setIsbios(g.getIsbios());
			m.setEmulator(emulator);

			if (shouldIncludeGame(m)) {
				if (!this.machines.containsKey(g.getName())) {
					machines.put(g.getName(), m);
				}
			}
		}
	}

	public void mame(String xmlFile, boolean oldFormat, String emulator) throws Exception {
		MameXmlFile xml = new MameXmlFile();
		List<Machine> games;
		if (oldFormat) {
			games = xml.parseOld(xmlFile).getMachine();
		} else {
			games = xml.parse(xmlFile).getMachine();
		}

		// Loop through all games in the XML file.
		for (Machine m : games) {
			String name = m.getName();
			m.setCategory(cif.getCategory(name));
			m.setEmulator(emulator);

			boolean includeGame = shouldIncludeGame(m);

			// If emulation is not good try to find a working clone and replace the original
			// one
			if (includeGame && m.getDriver() != null && !m.getDriver().getStatus().equals("good")) {
				Machine clone = xml.findWorkingClone(games, name);
				if (clone != null) {
					m = clone;
					m.setGenre(clone.getGenre());
					name = m.getName();
				}
			}

			// Only includes if game is not included yet.
			if (includeGame && !this.machines.containsKey(name)) {
				machines.put(name, m);
			}
		}

	}

	/**
	 * Print AM romlist based on the filters set.
	 */
	public void printAMList() {
		for (Map.Entry<String, Machine> entry : this.machines.entrySet()) {
			Machine m = this.machines.get(entry.getKey());
			String description = m.getDescription();
			// Adjust the name to remove anything after parenthesis.
			if (description.indexOf("(") > 0) {
				description = description.substring(0, description.indexOf("(") - 1);
			}
			String emulator = m.getEmulator();
			if (this.ecf.getEmulator(m.getName()) != null) {
				emulator = this.ecf.getEmulator(m.getName()).replace("\"", "");
			}
			System.out.println(m.getName() + ";" + description + ";" + emulator + ";;" + m.getYear() + ";"
					+ m.getManufacturer() + ";" + m.getCategory() + ";;;;;;;;;;");
		}
	}

	/**
	 * @throws Exception
	 */
	public void generateArcadeClassicsAMList() throws Exception {
		this.finalBurnAlpha("fba.dat", "lr-fbalpha");
		this.mame("mame078.xml", true, "lr-mame2003");
		this.mame("mame139.xml", true, "lr-mame2010");

		this.printAMList();
	}

	public static void main(String[] args) throws Exception {
		FilterArcadeGames fag = new FilterArcadeGames();
		fag.manufacturer = "capcom";
		fag.filterCategory = true;
		fag.generateArcadeClassicsAMList();
	}

}
