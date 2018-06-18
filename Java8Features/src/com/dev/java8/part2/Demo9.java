package com.dev.java8.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Demo9 {
    
    public static void main(String[] args) {
		
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
		List<Person> lsPeople=new ArrayList();
		lsPeople.add(new Person("Gopi",10));
		lsPeople.add(new Person("Ankit",30));
		lsPeople.add(new Person("Sachin",35));
		lsPeople.add(new Person("Rahul",40));
		lsPeople.add(new Person("Sumit",30));
		Map<Integer, String> map = 
        lsPeople.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge, 
                                Collectors.mapping(
                                        Person::getName, 
                                        Collectors.joining(", ")
                                )
                        )
                );
		System.out.println(map);
		
    }
}
