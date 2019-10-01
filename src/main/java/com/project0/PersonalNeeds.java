package com.project0;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project0.model.Account;

public class PersonalNeeds {
	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);

	public String personalNeeds(String choice, Account account) {
		System.out.print("\n------------------------" + "\nPERSONAL NEEDS\n" + "------------------------");
		;
		System.out.print("\n(1) When You Are Discouraged");
		System.out.print("\n(2) When You Need Guidance");
		System.out.print("\n(3) When You Need Peace");
		System.out.print("\n(4) Return to the Main-Menu");
		System.out.print("\nWHAT ARE YOU IN NEED OF? ");
		MainMenu returnMainMenu = new MainMenu();

		try {
			// switch statement for the Personal Menu Option
			int personalMenuOption = scanner.nextInt(); // Gets input from user

			switch (personalMenuOption) {

			case 1:
				System.out.println("\nKey Thought: When you walk in the midst of trouble"
						+ "\nand discouragement, know that God will revive you. \n"
						+ "\nKey Scripture: Isaiah 41:10 (NIV)\n " + "\nSo do not fear, for I am with you;"
						+ "\ndo not be dismayed, for I am your God." + "\nI will strengthen you and help you;"
						+ "\nI will uphold you with my righteous right hand.");
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");

				int MenuOption = scanner2.nextInt(); // Gets input from user
				if (MenuOption == 1) {
					returnMainMenu.mainMenu(account);
					break;
				}
				choice = "";
				break;

			case 2:
				System.out.println("\nKey Thought: God has given us the Holy Spirit "
						+ "\nto guide us into all truth. \n" + "\nKey Scripture: Psalm 32:8 (NIV)\n "
						+ "\nI will instruct you and teach you in the way you should go;"
						+ "\nI will counsel you with my loving eye on you.");
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");

				int MenuOption2 = scanner2.nextInt(); // Gets input from user
				if (MenuOption2 == 1) {
					returnMainMenu.mainMenu(account);
					break;
				}
				choice = "";
				break;

			case 3:
				System.out.println("\nKey Thought: The believer has peace that the world "
						+ "\ncan't give, and the world can't take away. \n" + "\nKey Scripture: John 14:27 (NIV) \n "
						+ "\nPeace I leave with you; my peace I give you. "
						+ "\nI do not give to you as the world gives. " + "\nDo not let your hearts be troubled"
						+ "\nand do not be afraid.");

				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");

				int MenuOption3 = scanner2.nextInt(); // Gets input from user
				if (MenuOption3 == 1) {
					returnMainMenu.mainMenu(account);
					break;
				}
				choice = "";
				break;

			case 4:
				returnMainMenu.mainMenu(account);
				break;

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
		return choice;
	}
}
