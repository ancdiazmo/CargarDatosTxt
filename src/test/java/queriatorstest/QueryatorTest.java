package queriatorstest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueryatorTest {
	
	@Test
	void queryatorTest () throws SQLException {
		
		//Arrange
		String CONNECTIONSTRING; CONNECTIONSTRING = "jdbc:oracle:thin:@//localhost:1521/xe";
		String USER; USER = "SPRINGUSER";
		String PASSWORD; PASSWORD = "12345";
		String query = "SELECT * FROM QUERYATORTEST";
		
		//Act
		Queryator queryator = new OracleQueryator (CONNECTIONSTRING, USER, PASSWORD);
		ResultSet result = queryator.executeQuery(query);
//		queryator.printResultSet(result);
		
		//Assert
		Assertions.assertTrue(result.next());
	}

}
