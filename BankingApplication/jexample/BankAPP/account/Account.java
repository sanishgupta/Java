package account;

public 	abstract class Account {
	
	public static final short MIN_BAL = 1000;
	private int 	accNumber;
	private String  firstName,
					lastName,
					accType,
					panNumber;
	private	double  balance;
			
	
	public Account() {
	
	accNumber =0;
	firstName ="";
	lastName  ="";
	accType   ="";
	panNumber ="";
	balance   =0;
	
	}
	
	public Account(int acNo, String  fName, String  lName, String  aType, String  pNumber,double bal) {
	
	accNumber =acNo;
	firstName =fName;
	lastName  =lName;
	accType   =aType;
	panNumber =pNumber;
	balance   =bal;
	
	}
	
	public int  getAccNumber() {  return accNumber; }
	
	public void setFirstName(String fname) {  firstName = fname; }
	public String getFirstName() {return firstName;}
	
	public void setLastName(String lname) {  lastName = lname; }
	public String getLastName() {return lastName; }
	
	public void setAccType(String atype) { accType = atype;}
	public String getAccType(){return accType;}
	
	public void setPanNumber(String pan) { panNumber = pan;}
	public String getPanNumber() {return panNumber;}
	
	public void setBalance(double bal ) { balance = bal;}
	public double getBalance() {return balance; }
	
	//ABSTRACT method
	
	 public abstract boolean withDraw(double bal); 
	/*
	boolean withDraw(double bal){
	
	if(MIN_BAL <= getBalance()) {
	
		System.out.println("Insufficiant Balance");
	} else {
			
		System.out.println("Transaction Proccessing......");
		setBalance( bal - getBalance() );
	}
	 return true;
	}
	
	*/
	public boolean deposit(double bal) {
		setBalance( bal + getBalance() );
		return true;
	}
	
	
}
	