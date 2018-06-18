package example2;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeMain {

	
	public static void main(String[] args) {
		
		/* search for configuration file and take info of 
		 * configuration
		 * and load configuratin from hibernate.cfg.xml
		*/
		 Configuration cfg = new Configuration();
		 cfg.configure();

		 /* create session factory based on hibernate.cfg.xml build Factory class*/
		 SessionFactory sf = cfg.buildSessionFactory();
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
		 
		 session = sf.getCurrentSession();
		 session.beginTransaction();
		 Query query = session.createQuery("from Employee");
		 List<Employee> empList = (List<Employee>) query.list();
		 Iterator<Employee> it = empList.iterator();
		
		 while(it.hasNext()){
			 
			 Employee e = it.next();
			 
			 System.out.println(e.getFirstName());
			 
			 
		 }
		 
		 session.getTransaction().commit();
	}

}
