import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

import java.sql.Connection;



public class DBConnection {
	
	
	static Statement stmt;
	static ResultSet rst;
	static Scanner sc;
	public static void main(String... arg){
	
	//	int output = 0;
		Connection con;
		
			try {
				con = DBconnect.getDBConnection();
				sc = new Scanner(System.in);
				stmt =  con.createStatement();
				System.out.println("Connected to the database");
				
			/*	
				String query1 = "insert into student values (301,'ankit','DIT')";
				String query2 = "delete from student where id=" + 301;
				String query3 = "update student set college='LNCTS' where id =102" ;
			*/	String query4 = "select * from student";
				
				System.out.println("Enter following.....");
				
				System.out.println("ID : ");
				int id = sc.nextInt();
				System.out.println("Name : ");
				String name = sc.next();
				System.out.println("College Name : ");
				String college = sc.next();
				
				
				
				String query5 = "insert into student values (" + id +",'"+ name +"','" + college +"')";				
				//output = stmt.executeUpdate(query4);
				stmt.executeUpdate(query5);
				
	//-----------------------------------function calling Testing----------------------------------------------------------		
				Student std = DBOperation.findStudent(id);
				System.out.println(std.getId() + "  "+std.getName()+ "  "+ std.getCollege());
    //----------------------------------------------------------------------------------------------------
				
				rst = stmt.executeQuery(query4);
				System.out.println("Data Base Values : ");
				while(rst.next()) {
					System.out.println("output :" + rst.getInt("id")+"  "+ rst.getString("name")+ " " + rst.getString("college"));
				}
			      con.close();
			      System.out.println("Disconnected from database");
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
}
	
	


