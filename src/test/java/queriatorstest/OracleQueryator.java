package queriatorstest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

//Oracle
//jdbc:oracle:thin:@//HOSTNAME:PORT/SERVICENAME

public class OracleQueryator implements Queryator {
	
	private Connection oracleConnection;
	
	public OracleQueryator (String connectionString, String user, String password) {
		createConnection(connectionString, user, password);
	}
	
	private void createConnection(String connectionString, String user, String password) {
		try {
			DriverManager.registerDriver(new OracleDriver());
			oracleConnection = DriverManager.getConnection(connectionString, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet executeQuery (String query) {
			try {
				PreparedStatement statement = oracleConnection.prepareStatement(query);
				ResultSet result = statement.executeQuery();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	@Override
	public void printResultSet (ResultSet result) throws SQLException {
		while(result.next()) {
			System.out.print(String.valueOf(result.getInt(1)));
			System.out.println();
		}
	}

	@Override
	public void CloseConection() {
		try {
			oracleConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

