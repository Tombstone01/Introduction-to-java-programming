public class Hello {
public static void main(String[] args) {        
        if (args.length == 0) {
            System.out.println("Here is a list of arguments.");
            for (int x = 0; x < args.length; x++) {
                System.out.println(args[x]);
            }
        } else {
            System.out.println("There are not arguments passed!");
        }
  } // end static method
} // end class
