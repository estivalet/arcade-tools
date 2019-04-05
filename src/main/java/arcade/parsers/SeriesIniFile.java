package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import arcade.domain.MameInfo;

public class SeriesIniFile {

	private Map<String, MameInfo> games = new HashMap<String, MameInfo>();

	/**
	 * @return the games
	 */
	public Map<String, MameInfo> getGames() {
		return games;
	}

	/**
	 * Parse series.ini file from http://www.progettosnaps.net/series/
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Series");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/series.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		String series = null;

		// Read a line. Skip first 8 lines
		for (int i = 0; i < 7; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		while (br.ready()) {
			line = br.readLine().trim();

			if (line.startsWith("[")) {
				series = line.substring(1, line.indexOf("]"));
			} else if (!line.isEmpty()) {
				System.out.println(line + " = " + series);
				MameInfo mi = new MameInfo();
				mi.setSeries(series);
				games.put(line, mi);

			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		SeriesIniFile sif = new SeriesIniFile();
		sif.parse();

		for (Entry<String, MameInfo> entry : sif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getSeries()));
		}

	}

}
