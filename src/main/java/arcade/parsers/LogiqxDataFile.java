package arcade.parsers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import arcade.domain.LogiqxGame;
import arcade.domain.LogiqxHeader;

@XmlRootElement(name = "datafile")
@XmlAccessorType(XmlAccessType.FIELD)
public class LogiqxDataFile {

	private LogiqxHeader header;
	private boolean includeClones;

	@XmlElement(name = "game")
	private List<LogiqxGame> games;

	/**
	 * @return the header
	 */
	public LogiqxHeader getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(LogiqxHeader header) {
		this.header = header;
	}

	/**
	 * @return the games
	 */
	public List<LogiqxGame> getGames() {
		return games;
	}

	/**
	 * @param games
	 *            the games to set
	 */
	public void setGames(List<LogiqxGame> games) {
		this.games = games;
	}

	public boolean isIncludeClones() {
		return includeClones;
	}

	public void setIncludeClones(boolean includeClones) {
		this.includeClones = includeClones;
	}

	public List<LogiqxGame> filterByGameManufacturer(String manufacturer) {
		List<LogiqxGame> result = new ArrayList<LogiqxGame>();
		for (LogiqxGame g : games) {
			if (!includeClones && g.getCloneof() != null) {
				continue;
			}
			if (g.getManufacturer().contains(manufacturer)) {
				result.add(g);
			}
		}
		return result;
	}

	public LogiqxDataFile parse(String fileName) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(LogiqxDataFile.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/" + fileName);
		return (LogiqxDataFile) jaxbUnmarshaller.unmarshal(is);
	}

	public static void main(String[] args) throws Exception {
		LogiqxDataFile ldf = new LogiqxDataFile();
		LogiqxDataFile dat = ldf.parse("FB Alpha (ClrMame Pro XML, Arcade only).dat");
		for (LogiqxGame game : dat.games) {
			System.out.println(game.getName());

		}
	}

}
