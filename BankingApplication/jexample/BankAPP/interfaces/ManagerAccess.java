package interfaces;
public interface ManagerAccess extends Access{

	public int openAccount(String fName, String lName, int aType, String panNum);
	public void listOfAccounts();
	public boolean close(int acNo);
}