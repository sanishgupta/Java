
public class MainClass {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		Account ac1 = new Account(4000);
		Account ac2 = new Account(4000);
		
		Thread1 th1 = new Thread1(ac1);
		Thread2 th2 = new Thread2(ac2);
		th1.start();
		th2.start();
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		fundTransfer(1000,ac1,ac2);
		System.out.println("balance of ac 1 " + ac1.getBalance());
		System.out.println("balance of ac 2 " + ac2.getBalance());
	}
	
	 public static boolean fundTransfer (int  amt,Account th1,Account th2) {
		th1.withdraw(amt);
		th2.deposit(amt);
		
		return true;

	}

}
