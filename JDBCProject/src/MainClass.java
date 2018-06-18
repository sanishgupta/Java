import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;


public class MainClass {

	static Statement stmt;
	static ResultSet rst;
	static Scanner sc;
	
	public static void main(String[] args) {

		Connection con;
		Student student ;
		
		try {
			con = DBconnect.getDBConnection();
			sc = new Scanner(System.in);
			stmt =  con.createStatement();
			System.out.println("Connected to the database");
			
/*	//-----------------------Search Student -------------------------------------------		
			System.out.println("Enter Student ID to search : ");
			int id = sc.nextInt();
			
			
			Student std = DBOperation.findStudent(id);
			System.out.println(std.getId() + "  "+std.getName()+ "  "+ std.getCollege());
	//---------------------------------------------------------------------------------		
*/
			
			
	//-------------------------insert Student ------------------------------------------
			System.out.println("ID : ");
			int id = sc.nextInt();
			System.out.println("Name : ");
			String name = sc.next();
			System.out.println("College Name : ");
			String college = sc.next();
			
			student = new Student(id,name,college);
			if(DBOperation.insertStudent(student))
				System.out.println("inserted Successfully !!!");
			else{
				System.out.println("This Record Already Exist");
			}
			
			con.close();
		     System.out.println("Disconnected from database");
		}catch (MySQLIntegrityConstraintViolationException e) {
			//e.printStackTrace();
			System.out.println("Integrity Constraint Rule Violation");
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
	
