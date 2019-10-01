package com.project0;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project0.model.Account;

public class PhysicalNeeds {

			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			
			public String physicalNeeds(String choice, Account account) {
				System.out.print("\n------------------------"
						+ "\nPHYSICAL NEEDS\n"
						+ "------------------------");;
				System.out.print("\n(1) When You Need Healing");
				System.out.print("\n(2) God's All Sufficient Grace");
				System.out.print("\n(3) When You Need A Good Night's Sleep");
				System.out.print("\n(4) Return To The Main-Menu");
				System.out.print("\nWHAT ARE YOU IN NEED OF? ");
				MainMenu returnMainMenu = new MainMenu();

				try {
					// switch statement for the Physical Menu Option
					int physicalMenuOption = scanner.nextInt(); // Gets input from user

					switch (physicalMenuOption) {

					case 1:
						System.out.println("\n\nKey Thought: All healing comes from God. \n"
								+ "\nKey Scripture: Psalm 103:1-3 (NIV)\n "
								+ "\nPraise the Lord, my soul;" 
								+ "\nall my inmost being, praise his holy name." 
								+ "\nPraise the Lord, my soul," 
								+ "\nand forget not all his benefits—" 
								+ "\nwho forgives all your sins\r\n" 
								+ "\nand heals all your diseases, who redeems your life from the pit" 
								+ "\nand crowns you with love and compassion," 
								+ "\nwho satisfies your desires with good things" 
								+ "\nso that your youth is renewed like the eagle’s.");
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
						System.out.println("\n\nKey Thought: God's grace is all-sufficient \n" 
								+ "\nKey Scripture: 2 Corinthians 12:9 (NIV)\n "
								+ "\nBut he said to me, My grace is sufficient "
								+ "\nfor you, for my power is made perfect in weakness."
								+ "\nTherefore I will boast all the more gladly "
								+ "\nabout my weaknesses, so that Christ’s power "
								+ "\nmay rest on me.");
						
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
						System.out.println("\n\nKey Thought: Sleep is a blessing of God \n"
								+ "\nKey Scripture: Proverbs 3:24 (NIV) \n "
								+ "\nWhen you lie down, you will not be afraid;\r\n" 
								+ "when you lie down, your sleep will be sweet.");
						
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
					//Goodbye blessing
					System.out.println("You have exited the application... \n"
							+ "\nThe Lord bless you and keep you; \n" 
							+ "The Lord make His face shine upon you, \n" 
							+ "And be gracious to you; \n"
							+ "The Lord lift up His countenance upon you, \n"
							+ "And give you peace. \n"
							+ "Numbers 6:24-26 \n");
				}
				return choice;
		}
}
