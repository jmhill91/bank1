package bank;

import java.math.BigDecimal;
import java.util.Map;

public abstract class Account {
	private long accountId;
	private BigDecimal balance;
	private AccountType accType;
	

	
	public Account(Customer customer) {
		super();
		this.accountId = getLastId();
		this.balance = BigDecimal.ZERO ;
		customer.addAccount(this);
	}
	
	
	private long getLastId() {
		long id = 0;
		AccountController ac = new AccountController();
		Map<Long, Account> accountList = ac.getAccountsByIdNumber();
		
		if (accountList.isEmpty()) {
			id = 1000;
		}else {
			for(Long key : accountList.keySet()) {
				if(id < key) {
					id = key;
				}
			}
			id += 5;
			
		}
		return id;
	}
	
	
	public long getAccountId() {
		return accountId;
	}


	public abstract BigDecimal withdraw(BigDecimal amount);
	public BigDecimal deposit(BigDecimal amount) {
		this.balance.add(amount);
		return this.balance;
	}
	
	
	public void setAccType(AccountType accType) {
		this.accType = accType;
	}
	public void correctBalance(BigDecimal amount) { 
		this.balance = amount;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public AccountType getAccType() {
		return accType;
	}
	
	
}
