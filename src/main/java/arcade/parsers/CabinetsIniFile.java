package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.MameInfo;

public class CabinetsIniFile {

	private Map<String, MameInfo> games = new HashMap<String, MameInfo>();

	/**
	 * @return the games
	 */
	public Map<String, MameInfo> getGames() {
		return games;
	}

	/**
	 * Parse cabinets.ini file from http://www.progettosnaps.net/renameset/ (zipped file e.g. pS_category_200.zip)
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Cabinets");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/cabinets.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		String cabinet = null;

		// Read a line. Skip first 8 lines
		for (int i = 0; i < 7; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		while (br.ready()) {
			line = br.readLine().trim();

			if (line.startsWith("[")) {
				cabinet = line.substring(1, line.indexOf("]"));
			} else if (!line.isEmpty()) {
				System.out.println(line + " = " + cabinet);
				MameInfo mi = new MameInfo();
				mi.setCabinet(cabinet);
				games.put(line, mi);
				// Document cab = new Document().append("cabinets", cabinet);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		CabinetsIniFile cif = new CabinetsIniFile();
		cif.parse();

		for (Entry<String, MameInfo> entry : cif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getCabinet()));
		}

	}

}
