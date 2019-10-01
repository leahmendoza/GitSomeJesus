package com.gitSomeJesus.Login;

import java.security.Timestamp;
import java.util.Scanner;

public class Login {

	public Login() {
		Scanner scanner = new Scanner(System.in);

		// Hard-coded credentials.. for now
		String user = "leahuser";
		String pass = "password";

		System.out.print("Username: ");
		String inpUser = scanner.nextLine(); // gets input from user
		System.out.print("Password: ");
		String inpPass = scanner.nextLine(); // gets input from user

		if(inpUser.equals(user)&&inpPass.equals(pass))
		{
			System.out.println("You successfully logined in as: " + user);
			
		}else
		{
			System.out.println("Oops, you entered the wrong credentials." + " Please try again.");
		}

		// close the scanner
		scanner.close();System.out.println("Scanner Closed.");
	}
}
