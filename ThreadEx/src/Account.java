
public class Account {

	public Account() {}
	
	int balance=0;
	public static boolean flag = false;
	public Account(int bal ){
		
		balance = bal;
	}
		
		
	synchronized public void withdraw (int amt) {
			
			int bal = balance;
			
			if (flag == true) {
				try {
					wait(2000);
					System.out.println("\n wait in withdraw\n");
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
			
			bal = bal - amt;
			balance = bal;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			flag = true;
			notify();
		}
	
		synchronized public void deposit(int amt) {
			
			int bal = balance;
			
			if (flag == false) {
				try {
				wait(2000);
				System.out.println("\n wait in deposit\n");
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}	
			bal = bal + amt;
			balance = bal;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = false;
			notify();

		}


		


		/**
		 * @return Returns the balance.
		 */
		public int getBalance() {
			return balance;
		}


		/**
		 * @param balance The balance to set.
		 */
		public void setBalance(int balance) {
			this.balance = balance;
		}


}