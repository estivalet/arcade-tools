package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author lestivalet
 *
 */
public class HistoryDatFile {

	/**
	 * Parse history.dat file from
	 * https://www.arcade-history.com/index.php?page=download
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Mame History");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/history.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		String history = "";
		String rom = "";
		boolean info = false;

		while (br.ready()) {
			line = br.readLine().trim();
			if (line.startsWith("$info")) {
				rom = line.split("=")[1];
				history = "";
				line = br.readLine().trim();
				info = true;
			}
			if (info && line.startsWith("$end")) {
				info = false;
				String[] roms = rom.split(",");
				for (String r : roms) {
					System.out.println(r);
					System.out.println(history);
				}
			}
			if (!line.startsWith("$bio")) {
				history += line + "<br>";
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		HistoryDatFile hf = new HistoryDatFile();
		hf.parse();
	}

}
