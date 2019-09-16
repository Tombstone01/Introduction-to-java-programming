import java.util.Arrays;

public class Kata {
  public static int findShort(String s) {

    String[] words = s.split(" ");

    int len = words[0].length();

    for (int x = 1; x < words.length; x++) {
      if (words[x].length() > len) {
        len = words[x].length();
      }
    }

    return len;
  }
}