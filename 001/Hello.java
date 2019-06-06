public class Hello {
  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      if (Math.random() * 100 < 10) {
        break;
      } else {
        System.out.println(i);
      }
    }
  } // end static method
} // end class
