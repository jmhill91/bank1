package bank;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
	
	private BigDecimal interestRate;
	
	public SavingsAccount(Customer customer) {
		super(customer);
		AccountType myType = AccountType.SAVINGS;
		this.setAccType(myType);
		this.interestRate = BigDecimal.ZERO;
	}
	

	public BigDecimal getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}


	@Override
	public BigDecimal withdraw(BigDecimal amount) {
		BigDecimal acctBal = this.getBalance();
		if(acctBal.compareTo(acctBal)>=0) {
			this.setBalance(acctBal.subtract(acctBal));
			return this.getBalance();
		}else {
		return null;
		}
	}
	

}
