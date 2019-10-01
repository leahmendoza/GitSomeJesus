package com.project0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.project0.model.Account;
//import com.project0.service.AccountService;
import com.project0.util.ConnectionFactory;

public class MainMenu {
	private String name = "";
	public String username = "";
	public String password = "";
	private String email;
	private String address;
	
	Scanner scanner = new Scanner(System.in);
	Scanner dscanner = new Scanner(System.in);
	Connection conn = null;
	Statement stmt = null;
	ResultSet set = null;

	public void mainMenu(Account account) {
		System.out.print("\n");
		//System.out.printf("\nWelcome, %s!", account.name);
		System.out.print("\n------------------------" + "\nMAIN MENU\n" + "------------------------");
		System.out.print("\n(1) Spirtual Needs");
		System.out.print("\n(2) Family Needs");
		System.out.print("\n(3) Personal Needs");
		System.out.print("\n(4) Physical Needs");
		System.out.print("\n(5) View Account Info");
		System.out.print("\n(0) Exit");
		System.out.print("\nENTER NUMBER: \n");

		try {
			String choice = "";
			// A switch statement for the Main Menu
			int mainMenuOption = scanner.nextInt(); // Gets input from user

			switch (mainMenuOption) {

			case 1:
				SpiritualNeeds spr = new SpiritualNeeds(); 
				choice = spr.spiritualNeeds(choice, account); 
				System.out.println(choice);
				break;

			case 2:
				FamilyNeeds fam = new FamilyNeeds();
				choice = fam.familyNeeds(choice, account);
				System.out.println(choice);
				mainMenu(account); //Go back to main menu
				break;

			case 3:
				PersonalNeeds per = new PersonalNeeds();
				choice = per.personalNeeds(choice, account);
				System.out.println(choice);
				mainMenu(account); //Go back to main menu
				break;

			case 4:
				PhysicalNeeds phys = new PhysicalNeeds();
				choice = phys.physicalNeeds(choice, account);
				System.out.println(choice);
				mainMenu(account); //Go back to main menu
				break;

			case 5:
				Scanner updatingAccountScanner = new Scanner(System.in);
				final String SQL = "select * from account"; // don't add a semicolon
				conn = ConnectionFactory.getConnection();
				try {
					stmt = conn.createStatement();
					set = stmt.executeQuery(SQL); // Returns the Result Set
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.out.print("\n------------------------" + "\nACCOUNT INFO:\n" + "------------------------\n");

				AccountRepositoryImpl acct = new AccountRepositoryImpl();
				Account updated_account = new Account(); // creating updated_account object to initialized in this scope 
														 // so I can assign it in the enhanced for loop
				for (Account a : acct.getAllAccounts()) { //iterating through accounts to retrieve info
					if (account.user_id == a.user_id) {
						updated_account = a; // Assigning a to updated_account 
						System.out.println("Name: " + a.getName() + "\n" + "Username: " + a.getUsername() + "\n"
								+ "Password: " + a.getPassword() + "\n" + "Email: " + a.getEmail() + "\n" + "Address: " + a.getAddress());
					}
				}

				System.out.print("\nCHOOSE AN OPTION: ");
				System.out.print("\n(1) Update Your Account");
				System.out.print("\n(2) Delete Your Account");
				System.out.print("\n(3) Go back to the Main Menu");
				System.out.print("\n(0) Exit");
				System.out.print("\nENTER NUMBER: \n");

				int accountMenuOption = scanner.nextInt(); // Gets input from user
				
				switch (accountMenuOption) {
				// A switch statement for the account menu options
				case 1:
					System.out.print("\n------------------------" + "\nUPDATE ACCOUNT:\n" + "------------------------\n");
					System.out.print("Name: ");
					name = updatingAccountScanner.nextLine();
					System.out.print("Username: ");
					username = updatingAccountScanner.nextLine();
					System.out.print("Password: ");
					password = updatingAccountScanner.nextLine();
					System.out.print("Email: ");
					email = updatingAccountScanner.nextLine();
					System.out.print("Address: ");
					address = updatingAccountScanner.nextLine();
					Account nunu = new Account(updated_account.getUser_id(), name, username, password, email, address);
					acct.updateAccount(nunu); //nunu is the new account object, its new data is being submitted to the DB
					
					mainMenu(account);
					break;

				case 2:
					System.out.print("\n------------------------" + "\nDELETE ACCOUNT:\n" + "------------------------\n");
					System.out.print("Are you sure you would like to delete your account?");
					System.out.print("\n(1) YES");
					System.out.print("\n(2) NO");
					System.out.print("\nENTER NUMBER: ");
					int deleteMenuOption = dscanner.nextInt(); // Gets input from user in the delete menu

					if(deleteMenuOption == 1) { //Deleting the account
						AccountRepositoryImpl deleteacct = new AccountRepositoryImpl();
						deleteacct.deleteAccount(account);
						System.out.println("You successfully deleted your account. "
											+ "\nGod Bless!");
						break;
					}
					else {
						mainMenu(account); //Go back to main menu
					}
					break;
					
				case 3:
					mainMenu(account); //Go back to main menu
					break;
				default:
					break;
				}

			default:
				break;
			}
			System.exit(0);
		} catch (InputMismatchException e) {
			scanner.nextLine(); // Clear the stream to get rid of bad input
			// Goodbye blessing
			System.out.println("You have exited the application... \n" + "\nThe Lord bless you and keep you; \n"
					+ "The Lord make His face shine upon you, \n" + "And be gracious to you; \n"
					+ "The Lord lift up His countenance upon you, \n" + "And give you peace. \n"
					+ "Numbers 6:24-26 \n");
		}
	}
}