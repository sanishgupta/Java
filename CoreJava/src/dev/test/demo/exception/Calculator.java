package dev.test.demo.exception;

public class Calculator {
	int result;
	
		
	public static void main(String[] args) {
		try{
		int firstNo=Integer.parseInt(args[0]);
		int secondNo=Integer.parseInt(args[1]);
		int result=0;
	
			 result=firstNo/secondNo;
			 System.out.println("result is "+result);
			}
			/*catch(ArrayIndexOutOfBoundsException exception){
				System.err.println("Insufficient arguments");
			}
			catch(NumberFormatException exception){
				System.err.println("Arguments must be numeric values");
			}
			catch(ArithmeticException exception){
				System.err.println("Second argument must be non-zero");
			}	*/	
		
		catch(NullPointerException exception){
			System.err.println("input is not correct");
		}
		finally{
			System.out.println("to close the db connection or file closing");
		}
		
		
		
		
		
		System.out.println("rest of app is running");
	}

}
