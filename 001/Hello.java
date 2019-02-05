public class Hello {
    public static void main(String[] args) {        
        if (args.length > 0) {
            // Loop through all the elements of the array.
            for (int x = 0; x < args.length; x++) {
                System.out.println(" - " + args[x]);
            }
        } else {
            System.out.println("No arguments passed!");
        }
    } // end static method
} // end class
