package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountController {

	private Map<Long, Customer> customersByIdNumber = new HashMap<Long, Customer>();
	private Map<Long, Account> accountsByIdNumber = new HashMap<Long, Account>();
	
	public Customer createCustomer(String name, String address, long taxId, CustomerType type) {
		
		Customer newCustomer = null;
		if(type == CustomerType.PERSON) {
			Customer newPerson = new Person(name, address, taxId);
			newCustomer = newPerson;	
		}else if(type == CustomerType.COMPANY) {
			Customer newCompany = new Company(name,address, taxId);
			newCustomer = newCompany;
		}
		
		customersByIdNumber.put(newCustomer.getIdNumber(), newCustomer);
		return newCustomer;
	}
	
	public Account createAccount(Customer customer, AccountType type) {
		
		
		Account newAccount = null;
		if(type == AccountType.CHECKING) {
			Account checkAccount = new CheckingAccount(customer);
			newAccount = checkAccount;
		}else if(type == AccountType.SAVINGS) {
			Account saveAccount = new SavingsAccount(customer);
			newAccount = saveAccount;
		}
		
		accountsByIdNumber.put(newAccount.getAccountId(), newAccount);
		return newAccount;
	}
	
	
	public Map<Long, Customer> getCustomersByIdNumber() {
		return customersByIdNumber;
	}

	public Map<Long, Account> getAccountsByIdNumber() {
		return accountsByIdNumber;
	}

	public void removeAccount(Account account) {
		long accId = account.getAccountId();
		accountsByIdNumber.remove(accId);
	}
	
	public void removeCustomer(Customer customer) {
		long custId = customer.getIdNumber();
		ArrayList<Account> accounts = customer.getAccounts();
		for(Account account : accounts) {
			removeAccount(account);
		}
		customersByIdNumber.remove(custId);
	}
	
}
