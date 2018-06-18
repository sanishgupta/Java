import account.Account;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account acc = new Account("101","dev");
		System.out.println(acc.getName());
	}

}
