package com.dev.java8.part1;

/**
 * FunctionalInterface is a interface with a only one abstract method.
 * 
 * But Object class methods never count in this one method.
 * 
 * 
 * What is the type of a lambda expression? 
 * Answer: a functional interface
 * 
 * Can a lambda be put in a variable?
 * Yes, Lambada can be taken as method parameter an can be return as by a method. 
 * 
 * 
 * @author sys-admin
 *
 */
@FunctionalInterface
public interface FunctionalInterfaceEx {
	
	public void test1(String str);
	
	@Override
	String toString();
	
	@Override
	boolean equals(Object obj);
	
}
