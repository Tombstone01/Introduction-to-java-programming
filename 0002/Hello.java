import java.util.Scanner;

public class Hello {
  public static void main(String[] args) {        
  	// Initialize the scanner class.
    Scanner scanner = new Scanner(System.in);
				
		
    System.out.print("Please enter your name: ");  
    String name = scanner.nextLine();

    System.out.print("Please enter your age: ");
		int age = scanner.nextInt();

		System.out.println("Hi, " + name + "!");

    } // end static method
} // end class
