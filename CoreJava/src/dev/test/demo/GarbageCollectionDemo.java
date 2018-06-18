package dev.test.demo;
class Employee
{
	String str = "00";
	public Employee()
	{
		System.out.println("Simple Non Constructor");
	}
	
	public Employee(String str)
	{
		this.str = str;
		System.out.println(str);
	}
	public void finalize()
	{
		System.out.println("release the external resources : " + str);
	}
}
public class GarbageCollectionDemo {

	public static void main(String[] args) {
		Employee emp=new Employee();
		emp=null;
		System.gc();
		System.out.println("application ends");
		
		Employee e1 = new Employee("1 - Employee");
		Employee e2 = new Employee("2 - Employee");
		Employee e3 = new Employee("3 - Employee");
		Employee e4 = new Employee("4 - Employee");
		Employee e5 = new Employee("5 - Employee");
		
		e1 = e2 = e3 = e4 = e5 = null;
		System.gc();
		
	}

}
