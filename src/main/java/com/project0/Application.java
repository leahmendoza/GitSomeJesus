package com.project0;

/*
 * This is the main class of gitSomeJesus, which is a login application that allows
 * you to view, add, update, and delete accounts as well as view a variety of scriptures.
 */

public class Application {
	public static void main(String[] args) {
		//Calling the login menu to start the application
		LoginMenu login = new LoginMenu();
		login.login();
	}
}
