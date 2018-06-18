package com.dev.java8.part1;

import java.util.Arrays;

public class DefaultMethodEx1 {

	public static void main(String []args)
	{
		Predicates<String> p1 =  s-> s.length() < 20;
		Predicates<String> p2 =  s-> s.length() > 10;
		
		//Predicates<String> p3  = p1.and(p2);
		System.out.println(p2 );
		
		
		
		
		String[] testString = {"abc","bcfccccccdx","cdeyyy","edef"};
		
		Arrays.sort(testString, (s1,s2) -> s1.length() - s2.length());

		for (String string : testString) {
			System.out.println(string);
		}
		
		//OR
		
		Arrays.sort(testString,(String s1, String s2) -> { return(s2.length() - s1.length()); });
		
		for (String string : testString) {
			System.out.println(string);
		}
	}

}
