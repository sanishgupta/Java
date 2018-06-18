package com.dev.java8.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Demo10 {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		List<Person> lsPeople = new ArrayList();
		List<Person> lsPeopleTemp = new ArrayList();
		lsPeople.add(new Person("Ankit", 10));
		lsPeople.add(new Person("Ankit", 30));
		lsPeople.add(new Person("Sachin", 35));
		lsPeople.add(new Person("Rahul", 40));
		
		Consumer<Person> c1 = System.out::println;
		Consumer<Person> c2 = lsPeopleTemp::add;
		
		stream.forEach(System.out::println);
		
		Stream<Person> stream1 = lsPeople.stream();
		
		stream1.forEach(c1.andThen(c2));
	}
}
