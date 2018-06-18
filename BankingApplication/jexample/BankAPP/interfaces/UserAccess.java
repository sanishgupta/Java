package interfaces;

public interface UserAccess extends Access{

	public boolean fundTransfer(int acOwnNo,int payeeAcNo, double bal) ;
	public void listOfAccounts(int loginId) ;
}
