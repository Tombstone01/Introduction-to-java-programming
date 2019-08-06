import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

/**
 * @author Kananelo Maxwell
 */

public class Connection implements Runnable {

  private PrintWriter printWriter;
  private BufferedReader bufferedReader;

  public Connection(Socket socket) {

    try {
      bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      printWriter = new PrintWriter(socket.getOutputStream(), true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {

    boolean done = false;
    int counter = 1;
    String response = "";

    printWriter.println("01 WELCOME - You may ask 5 questions");
    printWriter.println("02 ASK your question or DONE");
    printWriter.flush();

    while (!done) {
      try {
        // read response from the client.
        response = bufferedReader.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      // if response starts with "ASK"
      if (response.startsWith("ASK")) {

        // split the response into words.
        String[] question = response.split(" ");

        // if the question starts with why?
        if (question[1].equalsIgnoreCase("why")) {
          printWriter.println(counter + " Because that is how it is.");
        } else if (question[1].equalsIgnoreCase("Are")) {
          String[] clientResponse = { "Yes", "No", "Maybe" };

          // randomly select a number between 0 and 3;
          double index = Math.floor((Math.random() * 3));

          // pick a random response to the client.
          printWriter.println(counter + " " + clientResponse[(int) index]);
        } else {

          String[] clientResponse = { "It depends", "Please ask again later", "Meh" };

          // randomly select a number between 0 and 3;
          double index = Math.floor((Math.random() * 3));

          // pick a random response to the client.
          printWriter.println(counter + " " + clientResponse[(int) index]);
        }
      }

      /**
       * if the number of question exceeds 5 or if the client is done asking question.
       */
      if (counter == 5 || response.equalsIgnoreCase("done")) {

        // terminate the loop.
        done = true;

        // send the connection closed message.
        printWriter.println("05 HAVE A NICE DAY - " + counter + " Questions answered");
        printWriter.flush();
      }

      // increment the number of questions asked.
      counter++;
    }

    
  }
}