package com.dev.java8.part1;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.function.Function;

public class FirstLambda {

	public interface ADD {
		public int add(int a, int b);
	}

	public static void main(String[] args) {

		// FileFilter filter = new FileFilter() {
		//
		// @Override
		// public boolean accept(File pathname) {
		//
		// return pathname.getName().endsWith(".java");
		// }
		// };

		FileFilter filterLambda = (File pathname) -> pathname.getName().endsWith(".pdf");

		File dir = new File("C:/receipts");

		File[] files = dir.listFiles(filterLambda);

		for (File f : files) {
			System.out.println(f);
		}

		ADD sum = (int a, int b) -> (a + b);

		System.out.println(sum.add(1, 2));

		Comparator<Integer> compare1 = (Integer a, Integer b) -> Integer.compare(a, b);
		
		//OR
		
		Comparator<Integer> compare2 = (a, b) -> Integer.compare(a, b);

		System.out.println(compare1.compare(5, 6));

		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Lambada Expression test #" + i);
			}
		};

		r.run();

	}
	
	
	//Lambda expression : method references
	Function<String, String> f = s -> s.toLowerCase();
	
	//OR
	
	Function<String, String> f2 = String::toLowerCase;

	Comparator<Integer> compare3 = Integer::compare;
	
	
}
