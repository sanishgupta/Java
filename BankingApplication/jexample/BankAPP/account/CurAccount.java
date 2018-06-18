package account;

public class CurAccount extends Account {

		final Short RateOfInt = 4 ;
		static int OverDLimit = 100000 ;
	public CurAccount() {}

	public CurAccount(int acNo, String  fName, String  lName, String  pNumber,double bal) {
		super(acNo, fName, lName, "current", pNumber, bal);
	}
		
		
	public boolean withDraw(double bal) {
		
		
		if((Account.MIN_BAL <= getBalance()) && (bal <= (getBalance() + OverDLimit)) ){
	
		System.out.println("Insufficiant Balance");
	} else {
			
		System.out.println("Transaction Proccessing......");
		setBalance( getBalance() - bal );
	}
	 return true;
		}

}


