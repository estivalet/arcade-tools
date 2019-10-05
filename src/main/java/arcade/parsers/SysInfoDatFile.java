package arcade.parsers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import arcade.domain.MameInfo;

public class SysInfoDatFile {

	private List<MameInfo> games;

	/**
	 * @return the games
	 */
	public List<MameInfo> getGames() {
		return games;
	}

	/**
	 * 
	 * Parse sysinfo.dat file
	 * 
	 * @throws Exception
	 */
	public void parse() throws Exception {
		System.out.println("Parse Info");
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/sysinfo.dat");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		String info = "";
		String rom = null;
		String systemName = "";

		this.games = new ArrayList<MameInfo>();

		// Read file line per line.
		while (br.ready()) {
			line = br.readLine().trim();
			if (line.startsWith("$info")) {
				rom = line.split("=")[1].replace(",", "");
				info = "";
//				// skip $bio
//				line = br.readLine().trim();
//				systemName = br.readLine().replaceAll("=", "").trim();
			} else if (line.startsWith("$end")) {
				// Update info of games.
				MameInfo mi = new MameInfo();
				mi.setRom(rom);
				mi.setInfo(info);
				mi.setSystemName(systemName);
				games.add(mi);
			} else if (line.startsWith("======")) {
				systemName = line.replaceAll("=", "").trim();
			}
			if (!line.startsWith("$bio") && !line.startsWith("$info")) {
				info += line + "<br>";
			}
		}
		br.close();
	}

	public static void main(String[] args) throws Exception {
		SysInfoDatFile mif = new SysInfoDatFile();
		mif.parse();

		for (MameInfo entry : mif.getGames()) {
			System.out.println(entry.getRom() + " (" + entry.getSystemName() + ") = " + entry.getInfo());
		}

	}

}
