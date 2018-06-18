package com.dev.twist;
public class Java8TesterLambdaExpressions3 {

   final static String salutation = "Hello! ";
   
   public static void main(String args[]){
	   
	   GreetingService greetService1 = message -> 
	      System.out.println(salutation + message);
	      greetService1.sayMessage("Mahesh");
 
	      
	   
      GreetingService greetService = message -> {
     // salutation = "Hey "; //compilation error
      System.out.println(salutation + message);
      System.out.println(salutation + message + " 2");
      };
      greetService.sayMessage("Mahesh");
   }
	
   interface GreetingService {
      void sayMessage(String message);
   }
}