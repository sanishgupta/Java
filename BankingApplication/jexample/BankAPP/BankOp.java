import interfaces.*;
import account.*;
import validation.*;


import java.util.Scanner;

public class BankOp implements UserAccess , ManagerAccess , ClerkAccess {
	
	final int ACC_SIZE = 100;
	static int COUNT = 0;
	static BankOp bankOp;
	
	Account ACC[] = new Account[ ACC_SIZE];
	Scanner sc = new Scanner(System.in);
	
	static { bankOp = new BankOp(); }
	
	public static BankOp getInstance() {
		return bankOp;
	}
	
	//OPEN ACCOUNT
	
	public int openAccount(String fName, String lName, int aType, String panNum) {
	
	int i=0, accNo = 0;
	FOR_BREAK:
		for(; i < ACC_SIZE ; i++) {
			if (ACC[i] == null) {
					accNo = (i +1)* 1000 + 123;
				if(aType == 1) 	
					ACC[i] = new SavingAccount(accNo, fName, lName, panNum, Account.MIN_BAL);
					
				else if (aType == 2) 	
					ACC[i] = new CurAccount(accNo, fName, lName, panNum, Account.MIN_BAL);
				break FOR_BREAK;
			}		
		}
		if (i != ACC_SIZE)
			return accNo;
		else return 0;	
	}	
	
	
	// SEARCH ACCOUNT NUMBER
	public int findAccount(int acNo){
		int i=0;
		boolean validate = true;
		
		For_MARK :	
			for(; i< ACC_SIZE && validate; i++) {
				if (ACC[i]!= null) {
				if( acNo == ACC[i].getAccNumber()  )
					validate = false;
					break For_MARK;
				}
			}	
		return i;	
	}

	
	//Validate Account Existence
	public boolean validateAccount(int acNo){
		boolean validate = false;
		
		For_MARK :	
			for(int i=0; i< ACC_SIZE && !validate ; i++) {
				if (ACC[i]!= null) {
					if( acNo == ACC[i].getAccNumber() ){
						validate = true;
					//	System.out.println("\naccount found\n");
						break For_MARK;
					}	
				}
			}	
			return validate;
	}
	
	//  CLOSE ACCCOUNT 
	public boolean close(int acNo){	
		ACC[ findAccount(acNo)] = null;
		return true;
	}	
	
	// WITH DRAW AMOUNT 
	public boolean withDraw(int acNo, double bal ) {
	 	if(bal < Account.MIN_BAL ) {
			System.out.println("not enough balance");
		  return false;
		}   
		return	ACC[ findAccount(acNo)].withDraw(bal);
	}
		
	// DEPOSIT ACCOUNT
	public boolean deposit(int acNo, double bal) {
		if(bal < 100 ) 
		  return false;
	return	(ACC[ findAccount(acNo)].deposit( bal ));
	}
	
		
	// CHECK BALANCE
	public double checkBalance(int acNo) {
			return (ACC[ findAccount(acNo)].getBalance()) ;
	}	


	// Fund Treansfer
	public boolean fundTransfer(int ownAcNo,int payeeAcNo,double bal) {
		if (withDraw(ownAcNo, bal)) {
			   return deposit( payeeAcNo, bal);
		}else  return false; 
	}
	
	public void listOfAccounts() {
		//if(COUNT > 0) {
			System.out.println("\n-----------------------------------------------------------------\n");
			System.out.println("\n\n A/C Number \t A/C Type \t A/C Holder Name \t Balance" );	
		for(int i = 0; (i < ACC_SIZE); i++){
			if( ACC[i] != null ){
				System.out.println("\n-----------------------------------------------------------------\n");
				System.out.println(" " +ACC[i].getAccNumber()+"\t"+ACC[i].getAccType()+"\t"+ACC[i].getFirstName()+" "+ACC[i].getLastName()+"\t"+ACC[i].getBalance()+"\n");	
				
			}		
			/*	if( accType == 1 && ACC[i].getAccType().equalsIgnoreCase("saving"))
					continue ;
				else if( !(accType == 2 && ACC[i].getAccType().equalsIgnoreCase("current")))
					continue;			*/
		}
	//}
	}
	
	public void listOfAccounts(int loginId){
	
	}
	public void updateSavingAccount(int acNo){
		if(COUNT > 0){
			for(int i = 0; (i < ACC_SIZE) && (i < COUNT); i++) {
				if (ACC[i].getAccType().equalsIgnoreCase("saving"))
					ACC[i].setBalance(ACC[i].getBalance() + (ACC[i].getBalance() * SavingAccount.RateOfInterest)/100);
			}
		}	
}
}