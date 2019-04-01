// Author: Kananelo Maxwell
// Student#: 217080976
// Practical: 01

import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		String name;
		String results;
		String encode;

		// Creates an instance of class NameConverter.
		NameConverter converter = new NameConverter();

		// Creates an instance of scanner class.
		Scanner scanner = new Scanner(System.in);

		// Print information to the console.
		System.out.println("Would you like to Scramble a hero name (Y) or Unscramble a hero name (N)?");

		// Retrive input from the user.
		encode = scanner.nextLine();
		
		if (encode.equalsIgnoreCase("Y")) {
			
			// Print information to the console.
			System.out.println("Please enter the Hero's name to scramble:");

			// Retrieve information from the user.
			name = scanner.nextLine();

			// Scramble user input.
			results = converter.scramble(name);

			// Print information to the console.
			System.out.println("Entered hero name: \n" + name);
			System.out.println("Scrambled hero name: \n" + results);
		} else {
			
			// Print information to the console.
			System.out.println("Please enter secret Hero's name to unscramble:");
			
			// Take input from the user.
			name = scanner.nextLine();

			// Unscramble user input.
			results = converter.unscramble(name);

			// print information to the console.
			System.out.println("Entered Secret Name: \n" + name);
			System.out.println("Unscrambled Hero Name: \n" + results);
		}
	}
}