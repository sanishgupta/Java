import java.util.Scanner;
import interfaces.*;
import account.*;
import validation.*;

import validation.Validate;


public class ClerkAccessOp {

	public static void start() {
		
		ClerkAccess clerk = (ClerkAccess)FinalBankOp.getFinalBankInstance();
		int acNo = 0;	
		double bal = 0;
		Scanner sc = new Scanner(System.in);
		
OUT_LOOP :		
	while (true) 
	{
	bal = 0;
	System.out.println("\n\n\n");
	System.out.println("\n\t\t*******CLERK*******");
	System.out.println("\n\t\t--------------------");
	System.out.println("\n\t\t 1 : With Draw ");
	System.out.println("\n\t\t 2 : Deposit ");
	System.out.println("\n\t\t 3 : Check Balance");
	System.out.println("\n\t\t 4 : UpDate Saving Account");
	System.out.println("\n\t\t 5 : Exit");
	System.out.println("\n\t\t--------------------");
	
	System.out.print("\n\t\tEnter Your Choice # ");
	int nChoice = sc.nextInt();
	System.out.println("\n\t\t--------------------");

	switch( nChoice ) {
	
		// WITH DRAW
		case 1:		System.out.print("\n\t\t Enter Account Number : ");
					acNo = sc.nextInt();
					if ( clerk.validateAccount(acNo) ) {
					System.out.print("\n\t\t Enter Amount : ");
					bal = sc.nextInt();
					if (clerk.withDraw(acNo, bal) )
						System.out.print("\n\t\t Transaction successful........ ");
					else
						System.out.print("\n\t\t Not Sufficiant Balance");
					}else	
						System.out.print("\n\t\tAccount not Exist");
					break;
		// DEPOSIT		
		case 2: 	System.out.print("\n\t\t Enter Account Number : ");
					acNo = sc.nextInt();
					if ( clerk.validateAccount(acNo) ) {
						System.out.print("\n\t\t Enter Amount : ");
						bal = sc.nextInt();
						if (clerk.deposit(acNo, bal) )
							System.out.print("\n\t\t Transaction successful ");
					}else	
						System.out.print("\n\t\tAccount not Exist");
					break;
		// CHECK BALANCE			
		case 3 :	System.out.print("\n\t\t Enter Account Number : ");
					acNo = sc.nextInt();
					if (clerk.validateAccount(acNo))
						System.out.print("\n\t\t Current Balance : "+ clerk.checkBalance(acNo));				
					else	
						System.out.print("\n\t\t Account not exist");
					break;
		//UPDATE SAVING ACCOUNT			
		case 4 : 
		
				break;
		//	Exit from Account			
		case 5 :    break OUT_LOOP;
		default :   System.out.println("\n\t\t Invalid Choice !!!");
	
	}
	
	}
	}
}