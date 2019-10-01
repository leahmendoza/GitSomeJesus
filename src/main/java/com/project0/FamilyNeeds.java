package com.project0;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project0.model.Account;

public class FamilyNeeds {
	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);

	public String familyNeeds(String choice, Account account) {
		System.out.print("\n------------------------" + "\nFAMILY NEEDS\n" + "------------------------");
		;
		System.out.print("\n(1) Protection for Your Home");
		System.out.print("\n(2) God's Blessing on Your Home");
		System.out.print("\n(3) The Needs of Your Children");
		System.out.print("\n(4) Return to the Main-Menu");
		System.out.print("\nWHAT ARE YOU IN NEED OF? ");
		MainMenu returnMainMenu = new MainMenu();

		try {
			// switch statement for the Family Menu Option
			int familyMenuOption = scanner.nextInt(); // Gets input from user

			switch (familyMenuOption) {

			case 1:
				System.out.println(
						"\n\nKey Thought: The eternal God is your refuge \n" + "\nKey Scripture: Psalm 91:1-2 (NIV)\n "
								+ "\nWhoever dwells in the shelter of the Most High"
								+ "\nwill rest in the shadow of the Almighty."
								+ "\nI will say of the LORD, 'He is my refuge and"
								+ "\nmy fortress, my God, in whom I trust.'");
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");

				int MenuOption1 = scanner2.nextInt(); // Gets input from user
				if (MenuOption1 == 1) {
					returnMainMenu.mainMenu(account);
				}
				choice = "";
				break;

			case 2:
				System.out.println("\n\nKey Thought: Through wisdom, a home is build \n"
						+ "\nKey Scripture: Proverbs 2:6-7 (NIV)\n " + "\nFor the Lord gives wisdom;"
						+ "\nfrom his mouth come knowledge and understanding."
						+ "\nHe holds success in store for the upright,"
						+ "\nhe is a shield to those whose walk is blameless");
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");

				int MenuOption2 = scanner2.nextInt(); // Gets input from user
				if (MenuOption2 == 1) {
					returnMainMenu.mainMenu(account); //Go back to main menu
				}
				choice = "";
				break;

			case 3:
				System.out.println("\n\nKey Thought: Children need models rather than critics \n"
						+ "\nKey Scripture: Proverbs 22:6 (NIV) \n "
						+ "\nStart children off on the way they should go,"
						+ "\nand even when they are old they will not turn from it.");
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");

				int MenuOption3 = scanner2.nextInt(); // Gets input from user
				if (MenuOption3 == 1) {
					returnMainMenu.mainMenu(account); //Go back to main menu
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
