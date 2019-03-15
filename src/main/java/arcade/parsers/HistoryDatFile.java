package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import arcade.domain.MameInfo;

/**
 * 
 * 
 * @author lestivalet
 *
 */
public class HistoryDatFile {

	private List<MameInfo> games;

	/**
	 * @return the games
	 */
	public List<MameInfo> getGames() {
		return games;
	}

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

		this.games = new ArrayList<MameInfo>();

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
					MameInfo mi = new MameInfo();
					mi.setRom(r);
					mi.setHistory(history);
					games.add(mi);
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

		for (MameInfo entry : hf.getGames()) {
			System.out.println(entry.getRom() + " = " + entry.getHistory());
		}
	}

}
