package com.gitSomeJesus;

import com.gitSomeJesus.Login.Login;

/*
 * This is the main class of gitSomeJesus, which is a login application that allows
 * you to view, add, update, and delete scriptures in your 
 * account
 */
public class Application {

	public static void main(String[] args) throws Exception {

		System.out.println("Welcome to gitSomeJesus," + " please login to continue: ");

		Login login = new Login();

	}
}
