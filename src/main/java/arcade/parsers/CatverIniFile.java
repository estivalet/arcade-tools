package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.MameInfo;

public class CatverIniFile {

	private Map<String, MameInfo> games = new HashMap<String, MameInfo>();

	/**
	 * @return the games
	 */
	public Map<String, MameInfo> getGames() {
		return games;
	}

	/**
	 * @param game
	 * @return
	 */
	public String getCategory(String game) {
		if (this.games.get(game) == null) {
			return "";
		}
		return this.games.get(game).getCategory();
	}

	/**
	 * @param game
	 * @return
	 */
	public String getVerAdded(String game) {
		if (this.games.get(game) == null) {
			return "";
		}
		return this.games.get(game).getVerAdded();
	}

	/**
	 * Parse catver.ini file from http://www.progettosnaps.net/catver/ (all in one
	 * download file e.g: pS_CatVer_200.7z)
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse CatVer");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/catver.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		boolean verAdded = false;
		boolean category = false;

		// Loop through all lines.
		while (br.ready()) {
			// Read a line.
			line = br.readLine().trim();

			// Check if we are in [VerAdded] or [Category] section.
			if (line.startsWith("[VerAdded]")) {
				category = false;
				verAdded = true;
				line = br.readLine().trim();
			} else if (line.startsWith("[Category]")) {
				category = true;
				verAdded = false;
				line = br.readLine().trim();
			}

			if (!"".equals(line)) {
				// values[0] has game name.
				// values[1] has its category or the version added to mame
				// depending of current section.
				String[] values = line.split("=");

				MameInfo mi = null;
				if (category) {
					// System.out.println(values[0].trim() + " = " + values[1].trim());
					if (games.get(values[0].trim()) == null) {
						mi = new MameInfo();
						mi.setRom(values[0].trim());
					} else {
						mi = games.get(values[0].trim());
					}
					mi.setCategory(values[1].trim());
				} else if (verAdded) {
					if (games.get(values[0].trim()) == null) {
						mi = new MameInfo();
						mi.setRom(values[0].trim());
					} else {
						mi = games.get(values[0].trim());
					}
					mi.setVerAdded(values[1].trim());
				}
				games.put(values[0].trim(), mi);

			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		CatverIniFile cf = new CatverIniFile();
		cf.parse();

		for (Entry<String, MameInfo> entry : cf.getGames().entrySet()) {
			System.out
					.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getCategory()));
		}

	}

}
