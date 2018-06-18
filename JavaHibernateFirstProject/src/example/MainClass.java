package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	/**
	 * @param args
	 */
	 	static Configuration cfg;
	 	static SessionFactory sf;
	 	static Session session;
	public static void main(String[] args) {
		/* search for configuration file and take info of 
		 * configuration
		 * and load configuratin from hibernate.cfg.xml
		*/
		 Configuration cfg = new Configuration();
		 cfg.configure();

		 /* create session factory based on hibernate.cfg.xml build Factory class*/
		  sf = cfg.buildSessionFactory();

	}

	static void insertData(Employee employee){
		 Session session = sf.getCurrentSession();
		 session.beginTransaction();
		 
		 Employee emp = new Employee();
		 emp.setEmpId(103);
		 emp.setFirstName("Dev");
		 emp.setLastName("Gupta");
		 emp.setAge(23);
		 emp.setSalary(500000);
		 
		 session.save(emp);
		 
		 //start transaction and must to give bcz not commited it self other wise
		 session.getTransaction().commit();
	}
	
	static void update(){
		
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee emp = new Employee();
		 emp.setEmpId(103);
		 emp.setFirstName("Sanish");
		 emp.setLastName("Gupta");
		 emp.setAge(23);
		 emp.setSalary(500000);
		 
		 session.save(emp);
		 
		 //start transaction and must to give bcz not commited it self other wise
		 session.getTransaction().commit();
		
		
	}
	static void delete(){
		
	}
	
}
