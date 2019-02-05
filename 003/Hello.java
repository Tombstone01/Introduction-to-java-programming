import java.util.Random;

public class Hello {
  public static void main(String[] args) {        
		
		// Create a random object.
		Random random = new Random();

		// Generate a random number.
		int epochs = random.nextInt(100);

		// Loop through all the numbers
		for (int x = 0; x < epochs; x++)  {

			// Print the actual number.
			System.out.println(x);
		}
  } // end static method
} // end class
