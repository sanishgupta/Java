package com.dev.java8.part2;

import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.function.Consumer;

public class FirstPredicates {
    
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        
        Predicate<String> p1 = s -> s.length() > 3 ;
        
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");
		Consumer<String>c1=System.out::println;
        
        stream
                .filter(p2.or(p3))
                .forEach(c1);
    }
}
