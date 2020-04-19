package arcade.tools;

import static com.mongodb.client.model.Filters.eq;

import java.io.InputStream;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

import arcade.domain.GameList;
import arcade.domain.GameListGame;
import arcade.domain.Machine;
import arcade.domain.Mame;
import arcade.domain.MameBuild;
import arcade.domain.MameInfo;
import arcade.domain.SoftwareList2;
import arcade.domain.Softwarelists;
import arcade.parsers.BestgamesIniFile;
import arcade.parsers.CabinetsIniFile;
import arcade.parsers.CatverIniFile;
import arcade.parsers.FreeplayIniFile;
import arcade.parsers.GenreIniFile;
import arcade.parsers.HistoryDatFile;
import arcade.parsers.LanguagesIniFile;
import arcade.parsers.MameInfoDatFile;
import arcade.parsers.MameSoftwareListXmlFile;
import arcade.parsers.MameXmlFile;
import arcade.parsers.MatureIniFile;
import arcade.parsers.NPlayersIniFile;
import arcade.parsers.SeriesIniFile;

/**
 * Grab all info from MAME and insert into a MongoDB database.
 * 
 * A. Download data files:
 * 
 * 1. Download and install latest MAME from http://mamedev.org/release.php
 * 
 * 2. Generate mame.xml using mame64 -listxml > mame.xml
 * 
 * 3. Download history.dat file from https://www.arcade-history.com/index.php?page=download
 * 
 * 4. Download catver.ini, genre.ini and mature.ini files from http://www.progettosnaps.net/catver/ (all in one download file e.g: pS_CatVer_200.7z)
 * 
 * 5. Download mameinfo.dat file from http://mameinfo.mameworld.info/
 * 
 * 6. Download language.ini file from http://www.progettosnaps.net/languages/
 * 
 * 7. Download series.ini file from http://www.progettosnaps.net/series/
 * 
 * 8. Download cabinets.ini and freeplay.ini file from http://www.progettosnaps.net/renameset/ (zipped file e.g. pS_category_200.zip)
 * 
 * 9. Download bestgames.ini from http://www.progettosnaps.net/bestgames/
 * 
 * 10. Download nplayers.ini from https://nplayers.arcadebelgium.be/
 * 
 * 11. Import description field from EmulationStation gamelist.xml to a synopsis field
 * 
 * B. Update the database:
 * 
 * 1. Start MongoDB: mongod.exe --dbpath data
 * 
 * 2. Start mongo.exe client
 * 
 * 3. Connect to mamedb collection: "use mamedb"
 * 
 * 4. Drop database: "db.machines.drop()" and check with "db.machines.count()"
 * 
 * 5. Execute this class to import all data files.
 * 
 * C. Optional steps:
 * 
 * 1. Download and install latest MAMEUI from http://www.mameui.info/
 * 
 * @author luisoft
 *
 */
public class ImportMAME2MongoDB {

	public static void importListXML() throws Exception {
		System.out.println("Import XML");
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");

		MongoCollection<Document> build = database.getCollection("build");
		MongoCollection<Document> collection = database.getCollection("machines");
		MameXmlFile xml = new MameXmlFile();
		Mame mame = xml.parse("mame.xml");
		MameBuild mb = new MameBuild();
		mb.setVersion(mame.getBuild());
		Gson gson = new Gson();
		build.insertOne(new Document(BasicDBObject.parse(gson.toJson(mb))));
		for (Machine m : mame.getMachine()) {
			collection.insertOne(new Document(BasicDBObject.parse(gson.toJson(m))));
		}

		mongoClient.close();
	}

	public static void importSoftwareListXML() throws Exception {
		System.out.println("Import SoftwareList XML");
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("softwarelists");

		MameSoftwareListXmlFile xml = new MameSoftwareListXmlFile();
		Softwarelists softwarelist = xml.parse("softwarelist.xml");
		Gson gson = new Gson();
		// not storing Sharedfeat and part to avoid 16MB bson size (see Software xmltransient attributes)
		for (SoftwareList2 sl : softwarelist.getSoftwarelist()) {
			System.out.println(sl.getName() + " " + sl.getSoftware().size());
			collection.insertOne(new Document(BasicDBObject.parse(gson.toJson(sl))));
		}
		mongoClient.close();
	}

	public static void importHistory() throws Exception {
		System.out.println("Import History");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		HistoryDatFile hf = new HistoryDatFile();
		hf.parse();
		for (MameInfo entry : hf.getGames()) {
			collection.updateOne(eq("name", entry.getRom()), new Document("$set", new Document("history", entry.getHistory())));
		}
		mongoClient.close();
	}

	public static void importCatVer() throws Exception {
		System.out.println("Import CatVer");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		CatverIniFile cf = new CatverIniFile();
		cf.parse();

		for (Entry<String, MameInfo> entry : cf.getGames().entrySet()) {
			// System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getCategory()));
			if (entry.getValue() != null) {
				collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("category", entry.getValue().getCategory())));
				collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("veradded", entry.getValue().getVerAdded())));
			}
		}

		mongoClient.close();
	}

	public static void importMAMEInfo() throws Exception {
		System.out.println("Import Info");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		MameInfoDatFile mif = new MameInfoDatFile();
		mif.parse();

		for (MameInfo entry : mif.getGames()) {
			// System.out.println(entry.getRom() + " = " + entry.getInfo());
			collection.updateOne(eq("name", entry.getRom()), new Document("$set", new Document("info", entry.getInfo())));
		}

		mongoClient.close();
	}

	public static void importGenre() throws Exception {
		System.out.println("Import Genre");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		GenreIniFile gif = new GenreIniFile();
		gif.parse();

		for (Entry<String, MameInfo> entry : gif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getGenre()));
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("genre", entry.getValue().getGenre())));
		}

		mongoClient.close();
	}

	public static void importPlayers() throws Exception {
		System.out.println("Import Players");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		NPlayersIniFile nif = new NPlayersIniFile();
		nif.parse();

		for (Entry<String, Machine> entry : nif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue().getPlayers());
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("players", entry.getValue().getPlayers())));
		}
		mongoClient.close();
	}

	public static void importMature() throws Exception {
		System.out.println("Import Mature");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		MatureIniFile mif = new MatureIniFile();
		mif.parse();

		for (Entry<String, MameInfo> entry : mif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().isMature()));
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("mature", "yes")));
		}

		mongoClient.close();
	}

	public static void importLanguage() throws Exception {
		System.out.println("Import Language");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");
		LanguagesIniFile lif = new LanguagesIniFile();
		lif.parse();

		for (Entry<String, MameInfo> entry : lif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getLanguage()));
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("language", entry.getValue().getLanguage())));
		}
		mongoClient.close();
	}

	public static void importSeries() throws Exception {
		System.out.println("Import Series");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		SeriesIniFile sif = new SeriesIniFile();
		sif.parse();

		for (Entry<String, MameInfo> entry : sif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getSeries()));
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("series", entry.getValue().getSeries())));
		}

		mongoClient.close();
	}

	public static void importCabinets() throws Exception {
		System.out.println("Import Cabinets");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		CabinetsIniFile cif = new CabinetsIniFile();
		cif.parse();

		for (Entry<String, MameInfo> entry : cif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getCabinet()));
			collection.updateOne(eq("name", entry.getKey()), Updates.addToSet("cabinets", entry.getValue().getCabinet()));
		}

		mongoClient.close();
	}

	public static void importFreeplay() throws Exception {
		System.out.println("Import Freeplay");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		FreeplayIniFile fif = new FreeplayIniFile();
		fif.parse();

		for (Entry<String, MameInfo> entry : fif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().isFreePlay()));
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("freeplay", "yes")));
		}

		mongoClient.close();
	}

	public static void importBestGames() throws Exception {
		System.out.println("Import Best Games");

		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		BestgamesIniFile bif = new BestgamesIniFile();
		bif.parse();
		for (Entry<String, MameInfo> entry : bif.getGames().entrySet()) {
			System.out.println(entry.getKey() + " = " + (entry.getValue() == null ? "" : entry.getValue().getRanking()));
			collection.updateOne(eq("name", entry.getKey()), new Document("$set", new Document("ranking", entry.getValue().getRanking())));
		}

		mongoClient.close();
	}

	public static void importDescriptionFromESGamelist() throws Exception {
		System.out.println("Import Description from EmulationStation frontend gamelist.xml");
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("mamedb");
		MongoCollection<Document> collection = database.getCollection("machines");

		JAXBContext jaxbContext = JAXBContext.newInstance(GameList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		InputStream is = HistoryDatFile.class.getResourceAsStream("/arcade-files/gamelist.xml");
		GameList gameList = (GameList) jaxbUnmarshaller.unmarshal(is);
		for (GameListGame game : gameList.getGames()) {
			String name = game.getPath().substring(2, game.getPath().lastIndexOf("."));
			String description = game.getDesc();
			System.out.println(name);
			collection.updateOne(eq("name", name), new Document("$set", new Document("synopsis", description)));
		}

		mongoClient.close();
	}

	public static void main(String[] args) throws Exception {
//		ImportMAME2MongoDB.importListXML();
//		ImportMAME2MongoDB.importHistory();
//		ImportMAME2MongoDB.importCatVer();
//		ImportMAME2MongoDB.importMAMEInfo();
//		ImportMAME2MongoDB.importGenre();
//		ImportMAME2MongoDB.importMature();
//		ImportMAME2MongoDB.importLanguage();
//		ImportMAME2MongoDB.importSeries();
//		ImportMAME2MongoDB.importCabinets();
//		ImportMAME2MongoDB.importFreeplay();
//		ImportMAME2MongoDB.importBestGames();
//		ImportMAME2MongoDB.importPlayers();
//		ImportMAME2MongoDB.importDescriptionFromESGamelist();
//		ImportMAME2MongoDB.importSoftwareListXML();
		System.exit(0);

		// List games from retropie and find metadata from database
		// MongoClient mongoClient = new MongoClient();
		// MongoDatabase database = mongoClient.getDatabase("mamedb");
		// MongoCollection<Document> collection = database.getCollection("machines");
		// String[] files = new File("Z:/arcade").list();
		// for (String file : files) {
		// System.out.println(file);
		// Document doc = collection.find(eq("name", file.replace(".zip", ""))).first();
		// String json = doc.toJson();
		// Gson gson = new Gson();
		// Machine m = gson.fromJson(json, Machine.class);
		// System.out.println(m.getDescription());
		// System.exit(0);
		// }
		// mongoClient.close();

	}

}
