import java.io.Console;
import validation.Validate;
import java.util.Scanner;
import interfaces.*;
import account.*;

public class BankAccess {

	public static void main (String[] arg ) {
	
	//BankOp bank = BankOp.getInstance();
	Scanner sc =new Scanner(System.in);
	Console console = System.console();
	String[] loginIdArr = { "manager" ,"user","clerk"," "} ;
	while (true){
	System.out.println("\n\n\n");
	System.out.println("\n\t\t********MENU******");
	System.out.println("\n\t\t------------------");
	System.out.println("\n\t\t 1 : Manager");
	System.out.println("\n\t\t 2 : User   ");
	System.out.println("\n\t\t 3 : Clerk  ");
	System.out.println("\n\t\t 4 : Logout   ");
	
	System.out.println("\n\t\t------------------");
	System.out.print("\n\t\tEnter Your Choice # ");
	int nChoice = sc.nextInt();
	System.out.println("\n\t\t------------------\n\n\n\n\n\n\n");
	
	String 	password = "", 
	    	loginId = "";
	if (nChoice !=4) {
		System.out.println("\n\t\t------------------");
		loginId = console.readLine("\n\t\t Login ID : ");
		char[] password1 = console.readPassword("\n\t\t Password : ");
		System.out.println("\n\t\t------------------\n\n\n\n\n\n\n");
		password = new String(password1);
		
	//System.out.println("You entered  " + loginIdArr[nChoice-1]);
	if (!(loginId.equalsIgnoreCase(loginIdArr[nChoice-1]) && password.equalsIgnoreCase(loginIdArr[nChoice-1]))) {
			System.out.println("\n\n\n\t\tIncorrect Login ID & Password !!!");
			//System.exit(0);
	}else{
		//System.out.println("You entered" + loginIdArr[nChoice-1]);
	
	switch( nChoice ) {
		case 1: ManagerAccessOp.start();
				break;
		case 2: UserAccessOp.start();
				break;
		case 3: ClerkAccessOp.start();
				break;	
		default : System.out.println("\n\t\t Invalid Choice !!!");
	}	
	}
	} else System.exit(0);
}
}
}