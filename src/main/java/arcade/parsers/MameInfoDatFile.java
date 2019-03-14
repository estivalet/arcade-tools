package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MameInfoDatFile {

	/**
	 * 
	 * Parse mameinfo.dat file from http://mameinfo.mameworld.info/
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Info");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/mameinfo.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		String info = "";
		String rom = null;
		boolean driver = false;
		boolean mame = false;

		// Read file line per line.
		while (br.ready()) {
			line = br.readLine().trim();
			if (line.startsWith("$info")) {
				rom = line.split("=")[1];
				info = "";
				line = br.readLine().trim();
				if (line.startsWith("$mame")) {
					mame = true;
					driver = false;
				} else if (line.startsWith("$drv")) {
					driver = true;
					mame = false;
				}
				line = br.readLine().trim();
			} else if (line.startsWith("$end")) {
				// Update info of games.
				if (mame) {
					System.out.println(rom);
				} else if (driver) {
				}
			}
			info += line + "<br>";
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		MameInfoDatFile mif = new MameInfoDatFile();
		mif.parse();
	}

}
