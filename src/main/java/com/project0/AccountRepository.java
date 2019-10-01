package com.project0;

import java.util.List;
import com.project0.model.Account;

public interface AccountRepository {
	List<Account> getAllAccounts(); //create user account
	void insertAccount(Account a); //insert account
	void deleteAccount(Account a); //delete account
	void updateAccount(Account a); //update account
}