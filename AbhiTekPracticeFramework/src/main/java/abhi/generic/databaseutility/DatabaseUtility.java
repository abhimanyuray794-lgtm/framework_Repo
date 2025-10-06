package abhi.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;

	public void getDatabaseConnection() throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/projects", "root@%", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQueryMethod(String query) throws Throwable {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void closeDatabaseConnection() throws SQLException {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
