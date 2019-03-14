package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BestgamesIniFile {

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
				}
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		BestgamesIniFile bif = new BestgamesIniFile();
		bif.parse();
	}

}
