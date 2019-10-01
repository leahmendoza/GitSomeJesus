package com.project0;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project0.model.Account;

public class SpiritualNeeds {

	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);

	public String spiritualNeeds(String choice, Account account) {
		System.out.print("\n------------------------" + "\nSPIRITUAL NEEDS\n" + "------------------------");
		;
		System.out.print("\n(1) Spiritual Freedom");
		System.out.print("\n(2) Love of God");
		System.out.print("\n(3) Renew your Mind");
		System.out.print("\n(4) Return to the Main-Menu");
		System.out.print("\nWHAT ARE YOU IN NEED OF? ");
		MainMenu returnMainMenu = new MainMenu();
		
		try {
			// switch statement for the Spiritual Menu Option
			int spiritualMenuOption = scanner.nextInt(); // Gets input from user

			switch (spiritualMenuOption) {
			
			case 1:
				System.out.println("\n\nKey Thought: The people of God know perfect freedom. \n"
						+ "\nKey Scripture: John 8:32 (NIV)\n "
						+ "\nThen you will know the truth, and the truth will set you free.\n\n");

				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");
				
				int MenuOption = scanner2.nextInt(); // Gets input from user
				if (MenuOption == 1) {
					returnMainMenu.mainMenu(account);
				}
				choice = "";
				break;

			case 2:
				System.out.println("\nKey Thought: God loves you! \n" + "\nKey Scripture: 1 John 3:1 (NIV)\n "
						+ "\nSee what great love the Father has lavished on us, "
						+ "\nthat we should be called children of God! And that "
						+ "\nis what we are! The reason the world does not know "
						+ "\nus is that it did not know him..");
				
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");
				
				int MenuOption2 = scanner2.nextInt(); // Gets input from user
				if (MenuOption2 == 1) {
					returnMainMenu.mainMenu(account);
				}
				choice = "";
				break;

			case 3:
				System.out.println("\nKey Thought: God will renew your mind through His Word. \n"
						+ "\nKey Scripture: Romans 12:2 (NIV) \n "
						+ "\nDo not conform to the pattern of this world, but be "
						+ "\ntransformed by the renewing of your mind. Then you "
						+ "\nwill be able to test and approve what God’s will is"
						+ "\n—his good, pleasing, and perfect will.");
				
				System.out.print("\n------------------------" + "\nSCRIPTURE MENU:\n" + "------------------------\n");
				System.out.print("Would you like to continue viewing other scriptures?");
				System.out.print("\n(1) YES");
				System.out.print("\n(0) NO");
				System.out.print("\nENTER NUMBER: ");
				
				int MenuOption3 = scanner2.nextInt(); // Gets input from user
				if (MenuOption3 == 1) {
					returnMainMenu.mainMenu(account);
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
