package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.MameInfo;

public class BestgamesIniFile {
	private Map<String, MameInfo> games = new HashMap<String, MameInfo>();

	/**
	 * @return the games
	 */
	public Map<String, MameInfo> getGames() {
		return games;
	}

	/**
	 * Parse bestgames.ini from http://www.progettosnaps.net/bestgames/
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Best Games");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/bestgames.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;

		// Read a line. Skip first 7 lines
		for (int i = 0; i < 7; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		String ranking = "";
		while (br.ready()) {
			line = br.readLine().trim();
			if (!line.isEmpty()) {
				if (line.startsWith("[")) {
					ranking = line.substring(1, line.length() - 1);
					System.out.println(ranking);
				} else {
					System.out.println(line);
					MameInfo mi = new MameInfo();
					mi.setRanking(ranking);
					games.put(line, mi);

				}
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		BestgamesIniFile bif = new BestgamesIniFile();
		bif.parse();

		for (Entry<String, MameInfo> entry : bif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getRanking()));
		}

	}

}
