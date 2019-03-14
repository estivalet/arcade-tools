package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GenreIniFile {

	/**
	 * Parse genre.ini from http://www.progettosnaps.net/catver/ (all in one
	 * download file e.g: pS_CatVer_200.7z)
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Genre");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/genre.ini");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;
		String genre = null;

		// Read a line. Skip first 8 lines
		for (int i = 0; i < 7; i++) {
			line = br.readLine().trim();
		}

		// Loop through all lines.
		while (br.ready()) {
			line = br.readLine().trim();

			if (line.startsWith("[")) {
				genre = line.substring(1, line.indexOf("]"));
			}
			if (!line.isEmpty()) {
				System.out.println(line);
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		GenreIniFile gif = new GenreIniFile();
		gif.parse();
	}
}
