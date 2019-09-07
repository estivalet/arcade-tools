package arcade.parsers;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import arcade.domain.SoftwareList2;
import arcade.domain.Softwarelists;

/**
 * Generate mame.xml: mame -listsoftware > softwarelist.xml Remove dtd part of the xml and put in a mame.dtd file.
 * 
 * Remove "<!DOCTYPE softwarelists [" from dtd file first line and the "]>" last line of the same file.
 * 
 * Command to generate classes from mame.dtd: xjc -dtd -d . -p glog.domain mame.dtd
 * 
 * It uses SoftwareList2 because the Softwarelist from listsoftware command is different from the listxml so I created a SoftwareList2
 * 
 * @author luisoft
 *
 */
public class MameSoftwareListXmlFile {

	/**
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public Softwarelists parse(String fileName) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(Softwarelists.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = MameSoftwareListXmlFile.class.getResourceAsStream("/arcade-files/" + fileName);
		return (Softwarelists) jaxbUnmarshaller.unmarshal(is);
	}

	public static void main(String[] args) throws Exception {
		MameSoftwareListXmlFile xml = new MameSoftwareListXmlFile();
		Softwarelists s = xml.parse("softwarelist.xml");
		for (SoftwareList2 sl : s.getSoftwarelist()) {
			System.out.println(sl.getName() + " " + sl.getSoftware().size());
		}
	}

}
