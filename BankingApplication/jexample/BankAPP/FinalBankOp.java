import interfaces.*;
import account.*;
import validation.*;

public final class FinalBankOp {
	/** Factory class & mathod */
	public static final BankOp getFinalBankInstance() {
			BankOp bank = BankOp.getInstance();
		return bank;
	}	
}