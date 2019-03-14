package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NPlayersIniFile {

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
				System.out.println(tmp[0] + " = " + tmp[1]);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		NPlayersIniFile nif = new NPlayersIniFile();
		nif.parse();
	}

}
