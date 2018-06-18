package dev.test.demo.exception;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

class InvalidAgeException extends RuntimeException{
	public InvalidAgeException(String msg) {
		super(msg);
	}
	
}

public class ExDemo {
	public static void main(String[] args) {
		int age=10;
		if(age<18){
			
			throw  new InvalidAgeException("try next year");
			
		}
		else {
			System.out.println("ticket is dispatched");
		}
		
		
	
		System.out.println("Rest of app is running");
	}

}
