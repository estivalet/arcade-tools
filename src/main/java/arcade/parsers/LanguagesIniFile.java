package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanguagesIniFile {

	/**
	 * Parse language.ini file from http://www.progettosnaps.net/languages/
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Language");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/languages.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		String language = null;

		// Read a line. Skip first 8 lines
		for (int i = 0; i < 7; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		while (br.ready()) {
			line = br.readLine().trim();

			if (line.startsWith("[")) {
				language = line.substring(1, line.indexOf("]"));
			} else if (!line.isEmpty()) {
				System.out.println(line + " = " + language);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		LanguagesIniFile lif = new LanguagesIniFile();
		lif.parse();
	}

}
