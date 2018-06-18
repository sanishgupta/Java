package com.journaldev;

@FunctionalInterface
public interface Interface1 {

	void method1(String str);

	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}

	static void print(String str) {
		System.out.println("Printing " + str);
	}

	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"

	//compile time msg :: This static method cannot hide the instance method from Object
	 /*static String toString(){
	 return "i1";
	 }*/

	//compile time msg :: A default method cannot override a method from 
	 /*default String toString(){
	 return "i1";
	 }*/
}