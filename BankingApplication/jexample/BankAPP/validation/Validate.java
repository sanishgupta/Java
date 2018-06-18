package validation;

import java.util.regex.*;
import java.io.Console;

public class Validate {

	static Pattern pattern;
		
	public static boolean validateFirstName(String firstName) {
		return Pattern.compile("[a-z,A-Z]+").matcher(firstName).matches();
	}	
	
	public static boolean validateLastName(String lastName) {
			return Pattern.compile("[a-z,A-Z]+").matcher(lastName).matches();
	}	
	
	public static boolean validatePanNumber(String panNo) {
			return Pattern.compile("[a-z,A-Z][a-z,A-Z][a-z,A-Z][a-z,A-Z][a-z,A-Z][0-9][0-9][0-9][0-9][a-z,A-Z]").matcher(panNo).matches();
	}	
	
	
		 
	public boolean validateloginId(String loginId) {
			return Pattern.compile("[a-z,A-Z,0-9][a-z,A-Z,0-9][a-z,A-Z,0-9][a-z,A-Z,0-9]").matcher(loginId).matches();
	}
	
	public boolean validatePassword(String password){
		return Pattern.compile("[a-z,A-Z,0-9,!,$][a-z,A-Z,0-9,!,$][a-z,A-Z,0-9,!,$][a-z,A-Z,0-9,!,$]").matcher(password).matches();
	}
/*		
public static void main(String arg[]) {

		System.out.println( validateFirstName("sanis")+ "  " +validateLastName("gupta") +"  " + validatePanNumber("aaaaaa123a"));


}		
	*/	
		
		
}