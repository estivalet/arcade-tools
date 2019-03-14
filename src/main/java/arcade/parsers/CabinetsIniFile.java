package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CabinetsIniFile {

	/**
	 * Parse cabinets.ini file from http://www.progettosnaps.net/renameset/ (zipped
	 * file e.g. pS_category_200.zip)
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
				// Document cab = new Document().append("cabinets", cabinet);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		CabinetsIniFile cif = new CabinetsIniFile();
		cif.parse();
	}

}
