import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BUKAHandler implements Runnable {

	private Socket clientSocket = null;

	private BufferedReader br = null;
	private PrintWriter bw = null;

	private String usersFile = "data/users.txt";
  private String pdfFile = "data/PdfList.txt";

  private static LinkedList<String> activeUsers = null;
  private static LinkedList<Integer> user_ports = null;

	public BUKAHandler(Socket newConnectionToClient) {

    this.activeUsers = new LinkedList<>();
    this.user_ports = new LinkedList<>();

    try {
      this.clientSocket = newConnectionToClient;
      this.br = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
      this.bw = new PrintWriter(this.clientSocket.getOutputStream(), true);
	  } catch (Exception e) {
        e.printStackTrace();
	  }
	}

	public void run() {

    for (;;) {
      String req = null;

      // Process commands from client
      try {
        req = br.readLine();	
      } catch (Exception e) {
        System.out.println("There is a problem reading data from client.");
      }

      if (req != null) {
        StringTokenizer tokens = new StringTokenizer(req);
  
        String command = tokens.nextToken();
    
        switch (command) {
        case "AUTH":
    
          // get username
          String username = tokens.nextToken();
  
          // get password
          String password = tokens.nextToken();
    
          // check if user exists.
          boolean isFound = this.matchUser(username, password);
    
          // if the user is found.
          if (isFound) {
    
            this.activeUsers.add(username);
            this.user_ports.add(this.clientSocket.getPort());
    
            String message = "Login sucess";
  
            // send a reponse to client
            this.sendResponse(message);
          }
    
          break;
        case "LIST":
            
          // send list of files.
          sendResponse(this.getFileList().toString());
          break;
        case "PDFRT":
    
          String pdf_id = tokens.nextToken();
          String file = this.idToFile(pdf_id);
    
          sendResponse(file);
    
          break;
        case "LOGOUT":
    
          System.out.println("Client trying to logout.");
    
          // get port of current client
          int port_num = this.clientSocket.getPort();
    
          // try to remove client port from active clients
          if (this.user_ports.indexOf(port_num) != -1) {
  
            int index = this.user_ports.indexOf(port_num);
    
            this.user_ports.remove(user_ports.get(index));
  
            sendResponse("User loggout success.");
  
          } else {
            sendError("You must be logged in to logout.");
          }
          
          break;
        default:
          break;
        }
      }

    }
	}

  /** This function takes username and password
   *  Then returns a true of false depending 
   *  on whether or not, a user exists in text file.
   * 
   * @param username
   * @param password
   * @return
   */
	private boolean matchUser(String username, String password) {

    // indicate whether a client exists or not
		boolean found = false;

    // File contains user credentials
		File userFile = new File(this.usersFile);

		try {
      // Open file
      Scanner scan = new Scanner(userFile);
      
      // while there is a newline in file
			while (scan.hasNextLine() && !found) {

        // reads line from file
        String line = scan.nextLine();
        
        // split the line by space
				String lineSec[] = line.split("\\s");

        // get username from file
        String user = lineSec[0];
        
        // get password from file
				String pass = lineSec[1];

        // if user exists in database
				if (user.equalsIgnoreCase(username) && pass.equalsIgnoreCase(password)) {
				    found = true;
				}
			}
			scan.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return found;
	}

  /**  This function returns a list of 
   *   pdf files
   * 
   * @return
   */
	private ArrayList<String> getFileList() {

		ArrayList<String> result = new ArrayList<String>();
		File lstFile = new File(pdfFile);

		try {
			Scanner scan = new Scanner(lstFile);

			while (scan.hasNext()) {
				result.add(scan.nextLine());
			}

			scan.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return result;
	}

	private String idToFile(String ID) {
    
    String result = "";
		File lstFile = new File(pdfFile);
    
    try {
			Scanner scan = new Scanner(lstFile);

			while (scan.hasNextLine()) {

				String line = scan.nextLine();

				if (line.contains(ID)) {

					result = line;

					// break out of the while loop??
					break;
				}
			}

			// Read filename from file

			scan.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}

  /** This function responseds to a client
   *  with status 200
   *  
   * @param message
   */
	private void sendResponse(String message) {
    
    // compose response
    String response = "200 OK\n\r";
    response += message;

    // send response
    bw.println(response);
    bw.flush();
  }
  
  /** This function sends an error to client
   * 
   * @param message
   */
  private void sendError(String message) {
    
    // create message
    String response = "500 BAD: " + message;
    
    // send message to client
    bw.println(response);
    bw.flush();
  }
}
