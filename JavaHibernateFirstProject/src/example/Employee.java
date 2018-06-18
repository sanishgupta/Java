package example;

/**
 * This id called The POJO's CLASS
 * which not extend any class and not 
 * implements any interface
 * 
 * @author Sanish.Gupta
 *
 */

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private int age;
	private double salary;
	
	
	public Employee() {}
	
	public Employee(int empId, String firstName, String lastName, int age,
			double salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	

}
