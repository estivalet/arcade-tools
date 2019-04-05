package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.Machine;

public class NPlayersIniFile {

	private Map<String, Machine> games = new HashMap<String, Machine>();

	/**
	 * @return the games
	 */
	public Map<String, Machine> getGames() {
		return games;
	}

	/**
	 * Parse nplayers.ini from https://nplayers.arcadebelgium.be/
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Import Players");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/nplayers.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;

		// Read a line. Skip first 4 lines
		for (int i = 0; i < 4; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		while (br.ready()) {
			line = br.readLine().trim();

			if (!line.isEmpty()) {
				String[] tmp = line.split("=");
				Machine mi = new Machine();
				mi.setName(tmp[0]);
				mi.setPlayers(tmp[1]);
				games.put(line, mi);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		NPlayersIniFile nif = new NPlayersIniFile();
		nif.parse();

		for (Entry<String, Machine> entry : nif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue().getPlayers());
		}

	}

}
