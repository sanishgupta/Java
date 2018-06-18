
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class DBconnect  {    //throws ClassNotFoundException
	
	public static Connection getDBConnection()  throws SQLException,ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		//	Driver d = Driver("com.mysql.jdbc.Driver");
		//	DriverManager.registerDriver(d);
	
		return ( DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sanish"));
	
	}

}
