package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CatverIniFile {

	/**
	 * Parse catver.ini file from http://www.progettosnaps.net/catver/ (all in one
	 * download file e.g: pS_CatVer_200.7z)
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse CatVer");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/catver.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		boolean verAdded = false;
		boolean category = false;

		// Loop through all lines.
		while (br.ready()) {
			// Read a line.
			line = br.readLine().trim();

			// Check if we are in [VerAdded] or [Category] section.
			if (line.startsWith("[VerAdded]")) {
				category = false;
				verAdded = true;
				line = br.readLine().trim();
			} else if (line.startsWith("[Category]")) {
				category = true;
				verAdded = false;
				line = br.readLine().trim();
			}

			if (!"".equals(line)) {
				// values[0] has game name.
				// values[1] has its category or the version added to mame
				// depending of current section.
				String[] values = line.split("=");

				if (category) {
					// System.out.println(values[0].trim());
					// System.out.println(values[1].trim());
				} else if (verAdded) {
					// System.out.println(values[0].trim());
					// System.out.println(values[1].trim());
				}

			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		CatverIniFile cf = new CatverIniFile();
		cf.parse();
	}

}
