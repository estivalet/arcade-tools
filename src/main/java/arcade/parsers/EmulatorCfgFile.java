package arcade.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import arcade.util.Util;

public class EmulatorCfgFile {

	/** Hold emulator for each game. */
	Map<String, String> games = new HashMap<String, String>();

	public String getEmulator(String game) {
		return this.games.get(game);
	}

	/**
	 * Parse Retropie's emulator.cfg file that holds the correct emulator for each
	 * game.
	 * 
	 * @throws IOException
	 */
	public void parse() throws IOException {
		ArrayList<String> f1 = Util.getContentsAsArray("/arcade-files/emulators.cfg.lfe.ok");
		for (String s : f1) {
			games.put(s.substring(s.indexOf("_") + 1, s.indexOf("=") - 1), s.substring(s.indexOf("=") + 2));
		}
	}

	public static void main(String[] args) throws IOException {
		EmulatorCfgFile ecf = new EmulatorCfgFile();
		ecf.parse();

		for (Map.Entry<String, String> entry : ecf.games.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
