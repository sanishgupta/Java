import validation.Validate;
import java.util.Scanner;
import interfaces.*;
import account.*;

public class ManagerAccessOp {
	//ManagerAccess m = BankFactory.getInstance();
	public static void start() {
		ManagerAccess manager = (ManagerAccess)FinalBankOp.getFinalBankInstance();
		int acNo = 0;	
		Scanner sc = new Scanner(System.in);
		
OUT_LOOP :		
	while (true) 
	{

	System.out.println("\n\n\n");
	System.out.println("\n\t\t*******MANAGER******");
	System.out.println("\n\t\t--------------------");
	System.out.println("\n\t\t 1 : Open Account ");
	System.out.println("\n\t\t 2 : Close ");
	System.out.println("\n\t\t 3 : Check Balance");
	System.out.println("\n\t\t 4 : List of Account's");
	System.out.println("\n\t\t 5 : Exit");
	System.out.println("\n\t\t--------------------");
	
	System.out.print("\n\t\tEnter Your Choice # ");
	int nChoice = sc.nextInt();
	System.out.println("\n\t\t--------------------");
	
	switch( nChoice ) {
	
		// Open Account
		case 1 :	
					System.out.print("\n\t\t Enter Following Details \n\n");
					System.out.print("\n\t\t First Name      : ");
					String fName = sc.next();
					System.out.print("\n\t\t Last  Name      : ");
					String lName = sc.next();
					if ( !(Validate.validateFirstName(fName) && Validate.validateLastName(lName)))
						System.out.println("\n\t\t Name is not correct ");
					
					System.out.print("\n\t\t Saving (1) ,Current (2) ");
					System.out.print("\n\t\t Account Type    : ");
					int  aType = sc.nextInt();
					System.out.print("\n\t\t PAN Card Number : ");
					String panNum = sc.next();
					if ( Validate.validatePanNumber(panNum) == false)
						System.out.println("\n\t\t PAN Number is not correct");
		
					System.out.println("\n\t\t Your Account Number is : "+ manager.openAccount(fName, lName, aType, panNum));
					break;
		
		//  Close Account
		case 2 : 	System.out.print("\n\t\t Enter Account Number : ");
					acNo = sc.nextInt();
					if ( manager.validateAccount(acNo) ) {
					if (manager.close(acNo))
						System.out.print("\n\t\t Account deleted Successfully ");
					}else
						System.out.print("\n\t\tAccount not Exist");
					break;
		// CHECK BALANCE
		case 3 :	System.out.print("\n\t\t Enter Account Number : ");
					acNo = sc.nextInt();
					if (manager.validateAccount(acNo))
						System.out.print("\n\t\t Current Balance : "+ manager.checkBalance(acNo));				
					else	
						System.out.print("\n\t\t Account not exist");
					break;
		// LIST OF ACCOUNT
		case 4 :	manager.listOfAccounts();
					break;
		//	Exit from Account					
		case 5 :
					break OUT_LOOP;
		default : System.out.println("\n\t\t Invalid Choice !!!");
	
	}
	}
	}
}