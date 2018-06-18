package dev.test.demo.collection;
/*//sorting of employees  on the basis of age using comaparator	
import java.util.*;

class ComparatorDemo {
	public static void main(String g[]) {

		// Sorting user defined objects
		MyComparator myComparator = new MyComparator();
		TreeSet<Employee> col = new TreeSet<Employee>(myComparator);
		Employee s3 = new Employee("sumo", 22);
		Employee s1 = new Employee("Aman", 20);
		Employee s2 = new Employee("Dazy", 21);

		col.add(s1);
		col.add(s2);
		col.add(s3);
		for (Employee employee : col) {
			System.out.println(employee);
		}

	}
}

class Employee {
	String name;
	int age;

	Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// override
	public boolean equals(Object o) {
		Employee s = (Employee) o;
		if (this == s)
			return true;
		else if (this.name.hashCode() == s.name.hashCode() && this.age == s.age)
			return true;
		else
			return false;
	}

	// override
	public int hashCode() {
		return this.name.hashCode() + this.age;
	}

	@Override
	public String toString() {
		return "name=" + name + "  age=" + age + "\n";
	}
}

// sorting logic on the basis of age
class MyComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Employee s = (Employee) o1;
		Employee s1 = (Employee) o2;
		if (s.age == s1.age)
			return 0;
		else if (s.age > s1.age)
			return 1;
		else
			return -1;
	}
}
*/