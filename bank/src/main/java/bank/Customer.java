package bank;

import java.util.ArrayList;
import java.util.Map;

public abstract class Customer {
	
	private long idNumber;
	private String name;
	private String address;
	private long taxId;
	private static ArrayList<Account> accounts;
	private CustomerType custType;
	AccountController ac = new AccountController();
	
	

	public Customer(String name, String address, long taxId) {
		super();
		this.idNumber = getLastId();
		this.name = name;
		this.address = address;
		this.taxId = taxId;
	}
	
	private long getLastId() {
		long id = 0;
		AccountController ac = new AccountController();
		Map<Long, Customer> cusList = ac.getCustomersByIdNumber();
		
		if (cusList.isEmpty()) {
			id = 2_000_000;
		}else {
			for(Long key : cusList.keySet()) {
				if(id < key) {
					id = key;
				}
			}
			id += 7;
			
		}
		return id;
	}
	

	public void setCustType(CustomerType custType) {
		this.custType = custType;
	}

	public long getIdNumber() {
		return idNumber;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public long getTaxId() {
		return taxId;
	}



	public void setTaxId(long taxId) {
		this.taxId = taxId;
	}



	public ArrayList<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}



	public void addAccount(Account account) {
		ac.createAccount(this, account.getAccType());
		accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		for(Account myAccount : accounts) {
			if(myAccount == account) {
				int accIn = accounts.indexOf(account);
				accounts.remove(accIn);
			}
		}
		ac.removeAccount(account);
	}

}
