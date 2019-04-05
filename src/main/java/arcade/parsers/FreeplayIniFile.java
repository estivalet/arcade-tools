package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.MameInfo;

public class FreeplayIniFile {
	private Map<String, MameInfo> games = new HashMap<String, MameInfo>();

	/**
	 * @return the games
	 */
	public Map<String, MameInfo> getGames() {
		return games;
	}

	/**
	 * Parse freeplay.ini file from http://www.progettosnaps.net/renameset/ (zipped file e.g. pS_category_200.zip)
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Import Freeplay");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/freeplay.ini");
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
				System.out.println(line);
				MameInfo mi = new MameInfo();
				mi.setFreePlay(true);
				games.put(line, mi);

			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		FreeplayIniFile fif = new FreeplayIniFile();
		fif.parse();

		for (Entry<String, MameInfo> entry : fif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().isFreePlay()));
		}
	}

}
