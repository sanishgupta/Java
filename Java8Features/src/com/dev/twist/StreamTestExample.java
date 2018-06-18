package com.dev.twist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTestExample {
	
	//Generating Streams
	List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
	List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());

	
	
}
