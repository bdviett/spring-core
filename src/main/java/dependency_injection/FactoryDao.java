package dependency_injection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FactoryDao {
	public static AbstactDAO getDAO() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config/config.properties");
			// load a properties file
			prop.load(input);
			System.out.println(input);
			// get the database value
			String database = prop.getProperty("database");
			
			if (database.equals("1")) {
				return new MYSQLDAO();
			}
			if (database.equals("2")) {
				return new PostgreDAO();
			}
			if (database.equals("3")) {
				return new MSSQLDAO();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
