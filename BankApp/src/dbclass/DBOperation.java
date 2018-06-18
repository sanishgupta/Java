package dbclass;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import loginpkg.Login;

import account.Account;



public class DBOperation {
	

	
/*	public static Student findStudent(int id) throws SQLException, ClassNotFoundException{
		
		Student std =null;
			PreparedStatement ps = (DBconnect.getDBConnection()).prepareStatement("select * from student where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				std = new Student(rs.getInt(1), rs.getString(2),rs.getString(3));
		return std;
	}
*/
	public static boolean openAccount(Account acc) throws SQLException , ClassNotFoundException{
		
	/*	if(DBOperation.findStudent(.getId())== null )
			return false;
	*/	
		String query =  "insert into account values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (DBConnection.getDBConnection()).prepareStatement(query);
		ps.setInt(1, acc.getAccountNumber());
		ps.setString(2, acc.getFirstName());
		ps.setString(3, acc.getLastName());
		ps.setString(4,acc.getPassword());
		ps.setInt(5, acc.getAge());
		ps.setString(6,acc.getGender());
		ps.setString(7,acc.getMaritualStatus());
		ps.setString(8,acc.getAddress());
		
		ps.setString(9,acc.getCity());
		ps.setString(10,acc.getCountry());
		
		 ps.executeUpdate();	
		return true;
	}

public static boolean validate(Login login) {
	String query =  "select * from  login where username=? and password=? and type=?";
	boolean valid = false;
	try{
	PreparedStatement ps = (DBConnection.getDBConnection()).prepareStatement(query);
	ps.setString(1, login.getUserName());
	ps.setString(2, login.getPassword());
	ps.setString(3, login.getType());
	
	ResultSet rs =  ps.executeQuery();
	System.out.println("Validate successful");
	valid = rs.next() ? true : false;
	
	}catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return valid;
	
}


}
