package com.gitSomeJesus.user;

import com.gitSomeJesus.Account;

public class User extends Account {
	public User(long id, String accountType) {
		super(id, accountType);
		// TODO Auto-generated constructor stub
	}

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;

	// getter for first name
	public String getFirstName() {
		return firstname;
	}

	// setter
	public void setFirstName(String newFirstName) {
		this.firstname = newFirstName;
	}

	// getter for last name
	public String getLastName() {
		return lastname;
	}

	// setter
	public void setLastName(String newLastName) {
		this.lastname = newLastName;
	}

	// getter for username
	public String getUsername() {
		return username;
	}

	// setter
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	// getter for password
	public String getPassword() {
		return password;
	}

	// setter
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}

	// getter for email
	public String getEmail() {
		return email;
	}

	// setter
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

}