package arcade.parsers;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import arcade.domain.Software;
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
		Softwarelists s = xml.parse("channelf.xml");
		for (SoftwareList2 sl : s.getSoftwarelist()) {
			System.out.println(sl.getName() + " " + sl.getSoftware().size());

			Map<String, String> map = new HashMap<String, String>();
			for (Software soft : sl.getSoftware()) {
				map.put(soft.getDescription(), soft.getName());
			}

			String[] files = new File("c:\\EmuDreams\\systems\\Fairchild Channel F\\snap").list();
			for (String f : files) {
				if (f.indexOf("(") > 0) {
					String name = f.substring(0, f.indexOf("(") - 1);
					if (map.get(name) == null) {
						System.out.println("NO------>" + name);
					} else {
						System.out.println(map.get(name) + " = " + name);
//						Files.copy(new File("c:\\EmuDreams\\systems\\Fairchild Channel F\\snap\\" + f).toPath(),
//								new File("c:\\temp\\" + map.get(name) + ".png").toPath());
					}
				}
			}
		}
	}

}
