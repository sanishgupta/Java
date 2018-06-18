package com.dev.twist;
import java.util.List;
import java.util.ArrayList;

public class Java8TesterMethodReferences1 {
   public static void main(String args[]){
      List names = new ArrayList();
		
      names.add("Mahesh");
      names.add("Suresh");
      names.add("Ramesh");
      names.add("Naresh");
      names.add("Kalpesh");
		
      names.forEach(System.out::println);
      
      System.out.println("For Each Normal"); 
      for( Object str : names)
      {
    	  System.out.println(str);
      }
   }
}