package arcade.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import arcade.parsers.HistoryDatFile;

public class Util {
	private static final Logger LOGGER = Logger.getLogger(Util.class.getName());

	/**
	 * @param sourceFileName
	 * @param destFileName
	 * @throws Exception
	 */
	public static void copyFile(String sourceFileName, String destFileName, boolean overwrite) throws Exception {
		File source = new File(sourceFileName);
		File dest = new File(destFileName);
		if (source.exists()) {
			if (!dest.exists() || overwrite) {
				System.out.println("Copying " + sourceFileName + " to " + destFileName);
				Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		} else {
			System.out.println(sourceFileName + " NOT FOUND!");
		}
	}

	public static void copyFolder(File source, File destination) {
		if (source.isDirectory()) {
			if (!destination.exists()) {
				destination.mkdirs();
			}

			String files[] = source.list();

			for (String file : files) {
				File srcFile = new File(source, file);
				File destFile = new File(destination, file);

				copyFolder(srcFile, destFile);
			}
		} else {
			InputStream in = null;
			OutputStream out = null;

			try {
				in = new FileInputStream(source);
				out = new FileOutputStream(destination);

				byte[] buffer = new byte[1024];

				int length;
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
			} catch (Exception e) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				try {
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * Testa se um numero eh inteiro.
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static void objectToXml(Object obj, OutputStream os) throws JAXBException {
		JAXBContext xmlcontext = JAXBContext.newInstance(obj.getClass());
		Marshaller m = xmlcontext.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(obj, os);
	}

	public static String checkNull(String s) {
		return s == null ? "" : s;
	}

	public static long folderSize(File directory) {
		long length = 0;
		for (File file : directory.listFiles()) {
			if (file.isFile())
				length += file.length();
			else
				length += folderSize(file);
		}
		return length;
	}

	public static ArrayList<String> getContentsAsArray(String fileName) throws IOException {
		ArrayList<String> content = new ArrayList<String>();

		InputStream is = HistoryDatFile.class.getResourceAsStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				content.add(line);
			}
		} finally {
			br.close();
		}

		return content;
	}

	public static ArrayList<String> getContentsAsArray(File aFile) {
		ArrayList<String> content = new ArrayList<String>();

		try {
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					content.add(line);
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return content;
	}

	/**
	 * Fetch the entire contents of a text file, and return it in a String. This
	 * style of implementation does not throw Exceptions to the caller.
	 * 
	 * @param aFile
	 *            is a file which already exists and can be read.
	 */
	public static String getContents(File aFile) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();

		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line MINUS the
				 * newline. it returns null only for the END of the stream. it returns an empty
				 * String if two newlines appear in a row.
				 */
				while ((line = input.readLine()) != null) {
					contents.append(line);
					// contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return contents.toString();
	}

	/**
	 * Reads the stream fully, and returns a byte array of data.
	 * 
	 * @param stream
	 *            Stream to read.
	 * @return Byte array
	 */
	public static String readFully(final InputStream stream) {
		if (stream == null) {
			LOGGER.log(Level.WARNING, "Cannot read null input stream",
					new IOException("Cannot read null input stream"));
			return "";
		}

		final StringBuilder out = new StringBuilder();

		try {
			final char[] buffer = new char[0x10000];
			final Reader reader = new InputStreamReader(stream, "UTF-8");
			int read;
			do {
				read = reader.read(buffer, 0, buffer.length);
				if (read > 0) {
					out.append(buffer, 0, read);
				}
			} while (read >= 0);
		} catch (final UnsupportedEncodingException e) {
			LOGGER.log(Level.WARNING, e.getMessage(), e);
		} catch (final IOException e) {
			LOGGER.log(Level.WARNING, "Could not read stream", e);
		}

		return out.toString();
	}

	public static void main(String[] args) throws Exception {
		String[] folders = new File("c:/temp/overlays").list();
		for (String folder : folders) {
			Util.copyFile("c:/temp/default.lay", "c:/temp/overlays/" + folder + "/default.lay", true);
		}

	}
}
