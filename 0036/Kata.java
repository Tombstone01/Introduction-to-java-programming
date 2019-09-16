public class Kata {
  public static String expandedForm(int num) {

    // convert an integer into a string.
    String strNum = String.valueOf(num);

    // this holds the results.
    String retStr = "";

    // loop through the characters of the string.
    for (int x = 0; x < strNum.length(); x++) {

      // if the current character is not zero.
      if (strNum.charAt(x) != '0') {

        // if we are not yet at the end of
        // the string.
        if (x != strNum.length() - 1) {
          retStr += strNum.charAt(x) + giveZeros(strNum.length() - (x + 1)) + " + ";
        } else {
          retStr += strNum.charAt(x) + giveZeros(strNum.length() - (x + 1));
        }
      }
    }

    return retStr;
  }

  // this function returns the number of zeros
  // as a string representation.
  public static String giveZeros(int numZeros) {

    String ret = "";

    for (int x = 0; x < numZeros; x++) {
      ret += "0";
    }

    return ret;
  }

  public static void main(String[] args) {

    System.out.println(expandedForm(42));
  }
}