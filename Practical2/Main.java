// Author: Kananelo Maxwell
// Student#: 217080976
// Practical: 01

import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		String name;
		String results;
		String encode;

		/** Creates an instance of class NameConverter.
		 **/
		NameConverter converter = new NameConverter();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Would you like to Scramble a hero name (Y) or Unscramble a hero name (N)?");
		encode = scanner.nextLine();
		System.out.println("Input: " + input);
		
		if (encode.equalsIgnoreCase("Y")) {
			System.out.println("Please enter the Hero's name to scramble:");
			name = scanner.nextLine();

			results = converter.scramble(name);

			System.out.println("Entered hero name: " + name);
			System.out.println("Scrambled hero name" + results);
		} else {
			System.out.println("Please enter secret Hero's name to unscramble:");
			name = scanner.nextLine();

			results = converter.unscramble(name);

			System.out.println("Entered Secret Name: " + name);
			System.out.println("Unscrambled Hero Name: " + results);
		}
	}
}