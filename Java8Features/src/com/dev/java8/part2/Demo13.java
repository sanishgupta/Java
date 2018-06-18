package com.dev.java8.part2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo13 {

    public static void main(String... args) {
        
        List<Integer> list = Arrays.asList(-2);
        
        Integer Max = 
        list.stream()
                .reduce(0,Integer::max);
				System.out.println("Max = " + Max);
        
		/*
		Optional<Integer> opt=list.stream()
							.reduce(Integer::max);
							System.out.println("Max = " + opt);
        */
        
    }
}
