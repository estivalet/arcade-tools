package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MatureIniFile {

	/**
	 * Parse mature.ini files from http://www.progettosnaps.net/catver/ (all in one
	 * download file e.g: pS_CatVer_200.7z)
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
				System.out.println(line);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		MatureIniFile mif = new MatureIniFile();
		mif.parse();
	}
}
