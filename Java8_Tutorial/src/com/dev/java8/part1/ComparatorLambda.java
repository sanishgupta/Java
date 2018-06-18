
package com.dev.java8.part1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ComparatorLambda.
 */
public class ComparatorLambda {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String... args) {

		// Comparator<String> comp = new Comparator<String>() {
		//
		// @Override
		// public int compare(String s1, String s2) {
		//
		// return Integer.compare(s1.length(), s2.length());
		// }
		// };

		Comparator<String> compLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

		List<String> list = Arrays.asList("***", "**", "****", "*");
		Collections.sort(list, compLambda);

		for (String s : list) {
			System.out.println(s);
		}
		
		// OR
		list.forEach(String -> System.out.println(String));
		// OR
		list.forEach(System.out::println);
		
	}
}
