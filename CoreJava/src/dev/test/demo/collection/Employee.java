package dev.test.demo.collection;

public class Employee   {
	String name;
	int salary;
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}


	@Override
	public boolean equals(Object obj) {
	System.out.println("Employee.equals()");
		Employee other = (Employee) obj;
		if (name.equals(other.name))
			return true;
		return false;
	}
	
	public int hashCode(){
		System.out.println("Employee.hashCode()");
		int myhashcode=name.hashCode()+salary+100;
		return myhashcode;
	}
	
	
	
	
}