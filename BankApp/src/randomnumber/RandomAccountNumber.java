package randomnumber;

import java.util.Random;

public class RandomAccountNumber {
			
	public static int accountNumber(){
		Random randomGenerator = new Random();
		return (randomGenerator.nextInt(10000));
	}
	
}
