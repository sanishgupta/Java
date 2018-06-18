package dev.test.demo.collection;
import java.util.*;


public class ListDemo {
	public static void main(String[] args) {
		//ArrayList<Employee> list=new ArrayList<Employee>();
		Set<Employee> list=new HashSet<Employee>();
		//TreeSet list=new TreeSet() ;
	
		
		TreeMap<String, String> data=new TreeMap<String, String>();
		data.put("India","Delhi");
		data.put("USA","Wasington");
		data.put("China","Beijing");
		
		
		
		
		System.out.println(data);
		
		/*System.out.println(data.keySet());
		System.out.println(data.values());
		System.out.println(data.entrySet());*/
		
		
		/*list.add(new Employee("jacob",90000));
		list.add(new Employee("dazy",20000));	
		list.add(new Employee("khup",20000));
		
		for (Employee emp : list) {			
			
			System.out.println(emp);
		}
		
		
	
	System.out.println(list.contains(new Employee("dazy",20000)));
	
	
	
	
	
	*/
	
	
	
		//System.out.println(list);
		
		
		/*	Iterator<Employee> itr=list.iterator();
		while(itr.hasNext())
		{
			itr.remove();
			System.out.println(itr.next());
		}*/
		
		
		
	}
}
