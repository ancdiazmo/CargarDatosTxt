package queriatorstest;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Queryator {
	public ResultSet executeQuery (String query);
	public void CloseConection ();
	public void printResultSet (ResultSet result) throws SQLException;
}
