package dev.test.demo.collection;

//sorting of employees  on the basis of name using comaparable	
/*import java.util.*;
class CompareDemo
{
public static void main(String g[])
{
	
//Sorting user defined objects	
TreeSet<Employee> col=new TreeSet<Employee>();
Employee s3=new Employee("sumo",22);
Employee s1=new Employee("Aman",20);
Employee s2=new Employee("Dazy",21);

col.add(s1);
col.add(s2);
col.add(s3);
System.out.println(col);

}
}
class Employee implements Comparable
{
String name;
int age;
Employee(String name,int age)
{
this.name=name;
this.age=age;
}

// override
public int compareTo(Object o)
{
Employee s=(Employee)o;
if(this.name.equals(s.name))
return 0;
else if(this.name.compareTo(s.name)>0)
return 1;
else 
return -1;
}
public String toString()
{
return name+" "+age;
}

//override
public boolean equals(Object o)
{
Employee s=(Employee)o;
if(this==s)
return true;
else if(this.name.hashCode()==s.name.hashCode()&&this.age==s.age)
return true;
else
return false;
}

//override
public int hashCode()
{
return this.name.hashCode()+this.age;
}
}
*/