
public class Thread2 extends Thread{
	Account acc;
	public Thread2( Account acc) {
		
		this.acc = acc;
	}

	
	
	public void run(){
		
		
		acc.withdraw(1000);
		System.out.println("TH2 run withdraw 1000 now balance of ac2 :"+acc.getBalance()+"\n");
	}

}
