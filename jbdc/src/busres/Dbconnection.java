package busres;
import java.sql.*;


public class Dbconnection {

	private static final String url = "jdbc:mysql://localhost:3306/busrev";
	private static final String userName = "root";
	private static final String passWord = "Mahe@123";
	
	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(url,userName,passWord);
	}
}
