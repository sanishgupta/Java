package com.dev.twist;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Comparator;

public class Java8TesterLambdaExpressions1 {

	public static void main(String args[]){
   
      List<String> names1 = new ArrayList<String>();
      names1.add("Mahesh ");
      names1.add("Suresh ");
      names1.add("Ramesh ");
      names1.add("Naresh ");
      names1.add("Kalpesh ");
		
      List<String> names2 = new ArrayList<String>();
      names2.add("Mahesh ");
      names2.add("Suresh ");
      names2.add("Ramesh ");
      names2.add("Naresh ");
      names2.add("Kalpesh ");
		
      Java8TesterLambdaExpressions1 tester = new Java8TesterLambdaExpressions1();
      System.out.println("Sort using Java 7 syntax: ");
		
      tester.sortUsingJava7(names1);
      System.out.println(names1);
      System.out.println("Sort using Java 8 syntax: ");
		
      tester.sortUsingJava8(names2);
      System.out.println(names2);
   }
   
   //sort using java 7
   private void sortUsingJava7(List<String> names){   
      Collections.sort(names, new Comparator<String>() {
         @Override
         public int compare(String s1, String s2) {
            return s1.compareTo(s2);
         }
      });
   }
   
   //sort using java 8 [using Lambda Expression]
   private void sortUsingJava8(List<String> names){
      Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
   }
   
   
 //Traditional approach
   private static boolean isPrime(int number) {		
   	if(number < 2) return false;
   	for(int i=2; i<number; i++){
   		if(number % i == 0) return false;
   	}
   	return true;
   }
   
	/*
	 * The problem with above code is that it's sequential in nature, if the
	 * number is very huge then it will take significant amount of time. Another
	 * problem with code is that there are so many exit points and it's not
	 * readable. Let's see how we can write the same method using lambda
	 * expressions and stream API.
	 */
 //Declarative approach
   private static boolean isPrimewithLambada(int number) {		
   	return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
   }   
   
 
   private static boolean isPrimewithLambada2(int number) {
		IntPredicate isDivisible = index -> number % index == 0;
		
		return number > 1
				&& IntStream.range(2, number).noneMatch(
						isDivisible);
	}
   
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate)
	{
		return numbers.parallelStream().filter(predicate).mapToInt(i -> i).sum();
	}
	
	public static int findSquareOfMaxOdd(List<Integer> numbers) {/*
		return numbers.stream()
				.filter(NumberTest::isOdd) 		//Predicate is functional interface and
				.filter(NumberTest::isGreaterThan3)	// we are using lambdas to initialize it
				.filter(NumberTest::isLessThan11)	// rather than anonymous inner classes
				.max(Comparator.naturalOrder())
				.map(i -> i * i)
				.get();
	*/
		return -1;
		}

	public static boolean isOdd(int i) {
		return i % 2 != 0;
	}
	
	public static boolean isGreaterThan3(int i){
		return i > 3;
	}
	
	public static boolean isLessThan11(int i){
		return i < 11;
	}
}