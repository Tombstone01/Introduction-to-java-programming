import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** @author Kananelo Maxwell
 */

public class Connection implements Runnable {

	private Socket socket;
	private PrintWriter printWriter;
	private BufferedReader bufferedReader;

  public Connection(Socket socket) {
		this.socket = socket;

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			printWriter = new PrintWriter(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {

		boolean done = false;
		int counter = 0;
		String response = "";

		printWriter.println("What question would you like to ask?");
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
				// send response back to the user.
        printWriter.println(counter + " response here.");
        printWriter.flush();
      }
	
			/** if the number of question exceeds 5 or if the client is 
			 *  done asking question.
			 */
      if (counter == 5 || response.equalsIgnoreCase("done")) {

				// terminate the loop.
        done = true;
	
				// send the connection closed message.
        printWriter.println("05 HAVE A NICE DAY - 5 Questions answered");
        printWriter.flush();
			}
			
			// increment the number of questions asked.
			counter++;
    }
	}
}