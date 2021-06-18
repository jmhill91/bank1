package bank;

import java.math.BigDecimal;

public class CheckingAccount extends Account{
	
	private int nextCheck;
	
	public CheckingAccount(Customer customer) {
		super(customer);
		AccountType myType = AccountType.CHECKING;
		this.setAccType(myType);
		this.nextCheck = 1;
	}
	


	@Override
	public BigDecimal withdraw(BigDecimal amount) {
		BigDecimal intBal= this.getBalance();
		this.setBalance(intBal.subtract(amount));
		return this.getBalance();
	}
	
	public int getNextCheckNumber() {
		int nxt = this.nextCheck;
		nxt = this.nextCheck +1;
		return nxt;
	}

}
