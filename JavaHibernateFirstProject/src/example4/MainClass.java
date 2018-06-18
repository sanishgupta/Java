package example4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MainClass {

	/**
	 * @param args
	 */
	 
	 	static SessionFactory sf;
	 
	public static void main(String[] args) {
		/* search for configuration file and take info of 
		 * configuration
		 * and load configuratin from hibernate.cfg.xml
		*/
		 Configuration cfg = new Configuration();
		 cfg.configure();
		 sf = cfg.buildSessionFactory();
		 
	 try{
		 
		 	insertData();
		 }catch (Exception e) {
			e.printStackTrace();
		}
	
		// update();
		// delete();
		// getObject();
	}

	static void insertData() throws ParseException{
		 Session session = sf.getCurrentSession();
		 session.beginTransaction();
		 
		 Employee emp = new Employee();
		 emp.setEmpId(108);
		 emp.setFirstName("Richa");
		 emp.setLastName("Shrivastav");
		 emp.setAge(23);
		 emp.setSalary(500000);
		 
		 List<String> ph = new ArrayList<String>();
		 ph.add("123456");
		 ph.add("456789");
		 emp.setPhone(ph);
		 Map<String,String> email = new HashMap<String, String>();
		 email.put("email1","son.san.son@gmail.com");
		 email.put("email2", "sani4862@rediffmail.com");
		 
		 emp.setEmail(email);
		 
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		 Date date = dateFormat.parse("08-02-1988"); 
		 emp.setDob(date);
		 
		 Address address = new Address();
		 address.setCity("Delhi");
		 address.setHouseNo(143);
		 address.setState("Delhi");
		 address.setStreetNo(1);
		 address.setZipCode("477001");
		 
		 emp.setAddress(address);
		 session.save(emp);
		 
		 //start transaction and must to give bcz not commited it self other wise
		 session.getTransaction().commit();
	}
	
	static void update(){
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
	//	Employee emp = new Employee();
		Employee emp = (Employee)session.get(Employee.class,106);
		 
		 emp.setFirstName("DEv");
		 emp.setLastName("Gupta");
		 emp.setAge(23);
		 emp.setSalary(500000);
		 
		 session.saveOrUpdate(emp);
		 
		 //start transaction and must to give bcz not commited it self other wise
		 session.getTransaction().commit();
		
		
	}
	static void delete(){
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Employee emp = new Employee();
		 emp.setEmpId(106);
		 session.delete(emp);
		 session.getTransaction().commit();
	}
	
	/**	LAZY Result (lazy = true)
	 * 
	 *	Hibernate: select employee0_.employee_id as employee1_0_0_, employee0_.first_name as first2_0_0_, employee0_.last_name as last3_0_0_, employee0_.age as age0_0_, employee0_.salary as salary0_0_ from Employee_Details employee0_ where employee0_.employee_id=?
		Hibernate: select phone0_.employee_id as employee1_0_, phone0_.phone_number as phone2_0_, phone0_.idx as idx0_ from employee_phone phone0_ where phone0_.employee_id=?
		Sanish
		123456
		456789
	if EAGER (lazy = true)	
	Hibernate: select employee0_.employee_id as employee1_0_0_, employee0_.first_name as first2_0_0_, employee0_.last_name as last3_0_0_, employee0_.age as age0_0_, employee0_.salary as salary0_0_ from Employee_Details employee0_ where employee0_.employee_id=?
	Sanish
	Hibernate: select phone0_.employee_id as employee1_0_, phone0_.phone_number as phone2_0_, phone0_.idx as idx0_ from employee_phone phone0_ where phone0_.employee_id=?
	123456
	456789
		
		
	 * 
	 */
	static void getObject(){
		
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		int id = 106;
		Employee emp = (Employee)session.get(Employee.class,id);
		
		if(emp != null){
			
			System.out.println(emp.getFirstName());
			List<String> phone  = emp.getPhone();
			for(int i=0; i< phone.size(); i++){
				System.out.println(phone.get(i));
			}
		}else System.out.println("Employee "+ id +" is Not Exist");
		
		 session.getTransaction().commit();
	}
}
