import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBOperation {
	
	public static Student findStudent(int id) throws SQLException, ClassNotFoundException{
		
		Student std =null;
			PreparedStatement ps = (DBconnect.getDBConnection()).prepareStatement("select * from student where id=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				std = new Student(rs.getInt(1), rs.getString(2),rs.getString(3));
		return std;
	}

	public static boolean insertStudent(Student student) throws SQLException , ClassNotFoundException{
		
		if(DBOperation.findStudent(student.getId())== null )
			return false;
		String query =  "insert into student values (?,?,?)";
		PreparedStatement ps = (DBconnect.getDBConnection()).prepareStatement(query);
		ps.setInt(1,student.getId());
		ps.setString(2,student.getName());
		ps.setString(3,student.getCollege());
		ps.executeUpdate();	
		return true;
	}
}
