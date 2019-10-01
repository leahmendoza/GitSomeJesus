package com.gitSomeJesus;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private long id;
	private String accountType;
	
	//Types of accounts will be:
	// - Administrator
	// - User
	
	public Account(long id, String accountType) {
		super();
		this.id = id;
		this.accountType = accountType;
	}


	public static List<Account> createAccounts(int numAccounts){
		List<Account> accounts = new ArrayList<>();
		
		while (numAccounts > 0){
			Account a = new Account(1000 + numAccounts, "User Account");
			accounts.add(a);
			numAccounts--;
		}
		
		return accounts;
	}
	
	@Override
	public String toString() {
		return "Account [id: " + this.id + "]";
	}
}

