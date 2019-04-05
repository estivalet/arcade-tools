package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.MameInfo;

public class MatureIniFile {

	private Map<String, MameInfo> games = new HashMap<String, MameInfo>();

	/**
	 * @return the games
	 */
	public Map<String, MameInfo> getGames() {
		return games;
	}

	/**
	 * Parse mature.ini files from http://www.progettosnaps.net/catver/ (all in one download file e.g: pS_CatVer_200.7z)
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Mature");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/mature.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;

		// Read a line. Skip first 7 lines
		for (int i = 0; i < 7; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		while (br.ready()) {
			line = br.readLine().trim();

			if (!line.isEmpty()) {
				MameInfo mi = new MameInfo();
				mi.setMature(true);
				games.put(line, mi);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		MatureIniFile mif = new MatureIniFile();
		mif.parse();

		for (Entry<String, MameInfo> entry : mif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().isMature()));
		}
	}
}
