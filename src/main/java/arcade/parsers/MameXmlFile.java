package arcade.parsers;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import arcade.domain.Machine;
import arcade.domain.Mame;
import arcade.domain.Mame094;

public class MameXmlFile {

	/**
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	private Mame094 parseOld(String fileName) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Mame094.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/" + fileName);
		return (Mame094) jaxbUnmarshaller.unmarshal(is);
	}

	/**
	 * Read NEW MAME XML format.
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public Mame parse(String fileName) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Mame.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/" + fileName);
		return (Mame) jaxbUnmarshaller.unmarshal(is);
	}

	public static void main(String[] args) throws Exception {
		MameXmlFile xml = new MameXmlFile();
		Mame094 s = xml.parseOld("mame078.xml");
		for (Machine m : s.getGames()) {
			System.out.println(m.getName());
		}
	}

}
