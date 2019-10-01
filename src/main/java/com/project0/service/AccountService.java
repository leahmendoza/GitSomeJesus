package com.project0.service;

import java.util.List;

import com.project0.AccountRepositoryImpl;
import com.project0.model.Account;

public class AccountService {
	public List<Account> getAllAccounts(){
		return new AccountRepositoryImpl().getAllAccounts(); //Calling the method that retrieves
	}
		
	public void insertAccount(Account a){
		new AccountRepositoryImpl().insertAccount(a); //Calling the method that inserts
	}
	
	public void deletetAccount(Account a){
		new AccountRepositoryImpl().deleteAccount(a); //Calling the method that deletes
	}

	public void updateAccount(Account a) {
		new AccountRepositoryImpl().updateAccount(a); //Calling the method that updates
		
	}

}
