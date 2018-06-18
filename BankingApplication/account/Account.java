package account;

public class Account {
	
	private String account;
	private String name;
	public Account(String account, String name) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.name = name;
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return Returns the accpunt.
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * @param accpunt The accpunt to set.
	 */
	public void setAccpunt(String accpunt) {
		this.account = accpunt;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
