package arcade.parsers;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import arcade.domain.Machine;
import arcade.domain.Mame;
import arcade.domain.Mame094;

/**
 * Generate mame.xml: mame -listxml > mame.xml Remove dtd part of the xml and put in a mame.dtd file.
 * 
 * Remove "<!DOCTYPE softwarelists [" from dtd file first line and the "]>" last line of the same file.
 * 
 * Command to generate classes from mame.dtd: xjc -dtd -d . -p glog.domain mame.dtd
 * 
 * @author luisoft
 *
 */
public class MameXmlFile {

	/**
	 * Find a working clone for a parent.
	 * 
	 * @param parent
	 * @return
	 * @throws Exception
	 */
	public Machine findWorkingClone(List<Machine> machines, String parent) throws Exception {
		for (Machine m : machines) {
			if (m.getCloneof() != null && m.getCloneof().equals(parent) && m.getDriver().getStatus().equals("good")) {
				return m;
			}
		}
		return null;
	}

	/**
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public Mame094 parseOld(String fileName) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Mame094.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = MameXmlFile.class.getResourceAsStream("/arcade-files/" + fileName);
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
		InputStream is = MameXmlFile.class.getResourceAsStream("/arcade-files/" + fileName);
		return (Mame) jaxbUnmarshaller.unmarshal(is);
	}

	public static void main(String[] args) throws Exception {
		MameXmlFile xml = new MameXmlFile();
		Mame s = xml.parse("mame.xml");
		System.out.println("START!");
		for (Machine m : s.getMachine()) {
			System.out.println(m.getName() + "=" + m.getDescription() + ";" + m.getYear() + ";" + m.getManufacturer());
		}
	}

}
