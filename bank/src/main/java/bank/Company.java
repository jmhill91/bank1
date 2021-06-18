package bank;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Company extends Customer {

	ArrayList<Account> accounts = this.getAccounts();
	
	public Company(String name, String address, long taxId) {
		super(name, address, taxId);
		CustomerType myType = CustomerType.COMPANY;
		this.setCustType(myType);
	}

	public void addToAllAccounts(BigDecimal amount) {
		 for(Account account : accounts) {
			 account.setBalance(amount);
		 }
	}

}
