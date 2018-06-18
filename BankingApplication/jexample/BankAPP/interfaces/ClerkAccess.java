package interfaces;


public interface ClerkAccess extends Access{

		public boolean deposit(int acNo, double bal);
		public boolean withDraw(int acNo, double bal );
		public void updateSavingAccount(int acNo);
		
		
	}