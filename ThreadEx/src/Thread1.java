
public class Thread1 extends Thread{
	Account acc;
	public Thread1( Account acc) {
		
		this.acc = acc;
	}

	
	
	public void run(){
		
		
	acc.deposit(2000);
	System.out.println("TH1 run depodit 2000 noe balance in ac 1 :"+acc.getBalance()+"\n" );
	}
	
}
