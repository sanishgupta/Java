import interfaces.*;
import account.*;
import validation.Validate;
import java.util.Scanner;


public class UserAccessOp {

		public static void start() {
		
			UserAccess user = (UserAccess)FinalBankOp.getFinalBankInstance();
			int acNo = 0;	
			double bal = 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("\n\t\t Enter Account Number : ");
			acNo = sc.nextInt();
	if ( !user.validateAccount(acNo)) {
		System.out.print("\n\t\t Account not exist");			
		
	}
	else {
		
OUT_LOOP :		
	while (true) 
	{
	

	System.out.println("\n\n\n");
	System.out.println("\n\t\t*******USER******");
	System.out.println("\n\t\t--------------------");
	System.out.println("\n\t\t 1 : Fund Transfer ");
	System.out.println("\n\t\t 2 : Check Balance");
	System.out.println("\n\t\t 3 : List of Account's");
	System.out.println("\n\t\t 4 : Exit");
	System.out.println("\n\t\t--------------------");
	
	System.out.print("\n\t\tEnter Your Choice # ");
	int nChoice = sc.nextInt();
	System.out.println("\n\t\t--------------------");
	
	
	switch( nChoice ) {
	
		case 1:		
					System.out.print("\n\t\t Enter Payee Account Number : ");
					int payeeAcNo = sc.nextInt();
					if ( user.validateAccount(payeeAcNo)) {
					System.out.print("\n\t\t Enter Amount : ");
						bal = sc.nextDouble();	
					if (user.fundTransfer(acNo, payeeAcNo, bal))
						System.out.print("\n\t\t Transaction successful. ");	
					}
					break;
				
		case 2 :	System.out.print("\n\t\t Current Balance : "+ user.checkBalance(acNo));				
					break;
		//	Exit from Account			
		case 3 : 
					break;
		case 4 :	break OUT_LOOP;
		default : System.out.println("\n\t\t Invalid Choice !!!");
	}  
	}
	}
	}
}