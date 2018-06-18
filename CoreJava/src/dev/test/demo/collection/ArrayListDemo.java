
package dev.test.demo.collection;

import java.util.ArrayList;


class Customer
{
}

public class ArrayListDemo
{
	public static void main(String[] args)
	{

		String[] arr = { "noida", "delhi", "gurgaon" };

		// TreeSet col=new TreeSet();
		// LinkedHashSet<String> col=new LinkedHashSet<String>();

		ArrayList<String> col = new ArrayList<String>();

		// HashSet<String> col=new HashSet<String>();

		col.add("noida");
		col.add("delhi");
		col.add("gurgaon");

		System.out.println(col.size());
		System.out.println(col);
		/*
		 * System.out.println(col.remove(1)); System.out.println(col);
		 */

		System.out.println(col.contains("delhi"));

		/*
		 * col.add(0,"mubai"); System.out.println(col);
		 */
		/*
		 * col.add("gurgaon");
		 * 
		 * System.out.println(col);
		 */

	}

}
