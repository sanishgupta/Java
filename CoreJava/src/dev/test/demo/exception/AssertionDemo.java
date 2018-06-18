package dev.test.demo.exception;
import java.util.Scanner;

public class AssertionDemo
  {
 public static void main( String args[] )
  {
  Scanner scanner = new Scanner( System.in );
 
  System.out.print( "Enter working hours of a week between 0 and 40: " );
  int value = scanner.nextInt();
  assert( value >= 0 && value <= 40 ) :  "Invalid duration: " + value;
  System.out.println( "You have entered"+ value );
 } 
  
}
