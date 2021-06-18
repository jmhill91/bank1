package bank;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Person  extends Customer{
	
	
	ArrayList<Account> accounts = this.getAccounts();

	public Person(String name, String address, long taxId) {
		super(name, address, taxId);
		CustomerType myType = CustomerType.PERSON;
		this.setCustType(myType);
	}

	public void setAllAccountsToZero() {
		 for(Account account : accounts) {
			 account.setBalance(BigDecimal.ZERO);
		 }
	}



}
