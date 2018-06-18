package com.dev.java8.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.*;
public class Demo12 {
    public static void main(String[] args) {
		
        List<Person> lsPeople=new ArrayList();
		lsPeople.add(new Person("Ankit",10));
		lsPeople.add(new Person("Ankit",30));
		lsPeople.add(new Person("Sachin",35));
		lsPeople.add(new Person("Rahul",40));
		Predicate<Person>p1=p->p.getAge()>20;
		Predicate<Person>p2=p->p.getName().equals("Ankit");
		Predicate<Person>p3=p1.and(p2);
		Stream<Person> stream1=lsPeople.stream();
					stream1
						.filter(p3)
						.forEach(System.out::println);	
    }
}
