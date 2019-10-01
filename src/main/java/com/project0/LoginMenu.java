package com.project0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.project0.model.Account;
import com.project0.service.AccountService;
import com.project0.util.ConnectionFactory;

public class LoginMenu {
	private int id;
	private String name = "";
	public String username = "";
	public String password = "";
	private String email;
	private String address;

	Connection conn = null;
	Statement stmt = null;
	ResultSet set = null;

	AccountService accounts = new AccountService();
	Account acct = new Account(id, name, username, password, email, address); // Creating an instance of Account class
	MainMenu menu = new MainMenu(); // Creating instance of mainMenu class

	private static Scanner scanner = new Scanner(System.in);
	Scanner creatingAccountScanner = new Scanner(System.in);

	public void login() {
		// Choosing either login or create new user
		System.out.println("------------------------\n" + "Welcome to GitSomeJesus! \n" + "------------------------"
				+ "\n(1) Login" + "\n(2) Create Account" + "\n(0) Exit"
				+ "\nChoose an Option: ");

		try {
			// A switch statement for login or new account menu
			int LoginOption = scanner.nextInt(); // gets input from user

			switch (LoginOption) {

			case 1:
				final String SQL = "select * from account"; // don't add a semicolon
				conn = ConnectionFactory.getConnection();
				System.out.println("\n\n------------------------\n" + "LOGIN MENU\n" + "------------------------");
				System.out.println("Enter your login information below.");

				// Prompting user to enter their user name and password
				System.out.println("Username: ");
				String inpUser = scanner.next(); // Gets input from user
				System.out.println("Password: ");
				String inpPass = scanner.next(); // Gets input from user

				int i = 0;
				try {

					stmt = conn.createStatement();
					set = stmt.executeQuery(SQL); // Returns the ResultSet

					while (set.next()) { // iterating through the database to see if credentials are correct
						String user = set.getString(3);
						String password = set.getString(4);
						if (inpUser.equals(user) && inpPass.equals(password)) {
							i++;
							id = set.getInt(1);
							name = set.getString(2);
							username = set.getString(3);
							password = set.getString(4);
							email = set.getString(5);
							address = set.getString(6);
						}

					}

				} catch (SQLException e) {
					e.printStackTrace();
				} 

				if (i == 1) { //If counter is 1 that means the condition was true and user is re-directed to the main menu
					acct = new Account(id, name, username, password, email, address);
					menu.mainMenu(acct); //Passing "acct" through the main menu class and method

				} 
				else {
					System.out.println("Oops, you entered the wrong credentials." + " Please try again.\n\n");
					login();
				}

				// close the scanner
				// scanner.close();
				// System.out.println("Scanner Closed.");
				break;

			case 2:
				createAccount();
			default:
				break;
			}
		} catch (InputMismatchException e) {
			scanner.nextLine(); // Clear the stream to get rid of bad input
			// Goodbye blessing
			System.out.println("You have exited the application... \n" + "\nThe Lord bless you and keep you; \n"
					+ "The Lord make His face shine upon you, \n" + "And be gracious to you; \n"
					+ "The Lord lift up His countenance upon you, \n" + "And give you peace. \n"
					+ "Numbers 6:24-26 \n");
		}
	}

	public void createAccount() {
		System.out.print("\n------------------------" + "\nCREATE A NEW ACCOUNT\n" + "------------------------\n");
		System.out.print("Name: ");
		name = creatingAccountScanner.nextLine();
		System.out.print("Username: ");
		username = creatingAccountScanner.nextLine();
		System.out.print("Password: ");
		password = creatingAccountScanner.nextLine();
		System.out.print("Email: ");
		email = creatingAccountScanner.nextLine();
		System.out.print("Address: ");
		address = creatingAccountScanner.nextLine();
		System.out.print("You have successfully created a new account!\n ");
		System.out.print("\n");

		AccountService acct = new AccountService();
		Account a = new Account(id, name, username, password, email, address);
		acct.insertAccount(a);
		login();
	}
}
