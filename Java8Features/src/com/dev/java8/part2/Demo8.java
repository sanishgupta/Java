package com.dev.java8.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.*;
public class Demo8 {
    
    public static void main(String[] args) {
		
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		List<Person> lsPeople=new ArrayList();
		lsPeople.add(new Person("Ankit",10));
		lsPeople.add(new Person("Ankit",30));
		lsPeople.add(new Person("Sachin",35));
		lsPeople.add(new Person("Rahul",40));
        
        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");
        /*
        List<String> list = new ArrayList<>();
        
        stream
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);
		
        
        System.out.println("Done!");
        System.out.println("size = " + list.size());
		
		*/
		
		long count = stream
                  .filter(name -> name.startsWith("t"))
                  .count();
		System.out.println(count);
		
		Stream<Person> stream1=lsPeople.stream();
		Optional<Person> opt = stream1.filter(p -> p.getAge() >= 100)
		.min(Comparator.comparing(Person::getAge));
		System.out.println(opt);
		//System.out.println(opt.orElse(new Person("mamta",17)));
    }
}
