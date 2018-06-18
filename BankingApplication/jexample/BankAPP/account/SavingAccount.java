package account;

public class  SavingAccount extends Account {

	public final static Short RateOfInterest = 4 ;
	
	public SavingAccount() {}
	
	public SavingAccount(int acNo, String  fName, String  lName, String  pNumber,double bal) {
		super(acNo, fName, lName, "saving", pNumber, bal);
	}
	
	public boolean withDraw(double bal ) {
	
		if((Account.MIN_BAL <= getBalance()) ) {
	
		System.out.println("Insufficiant Balance");
		return false;
	}
			
		System.out.println("Transaction Proccessing......");
		setBalance(getBalance() - bal);
	
	 return true;
	}
}
