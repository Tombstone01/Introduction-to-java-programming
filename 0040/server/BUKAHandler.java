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

    // this stores the names of the client
    this.activeUsers = new LinkedList<>();

    // this stores the ports of the client
    this.user_ports = new LinkedList<>();

    try {
      this.clientSocket = newConnectionToClient;

      // bind streams to sockets.
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

      StringTokenizer tokens = new StringTokenizer(req);

      String command = tokens.nextToken();

      System.out.println("Next command: " + command);

      switch (command) {
      case "AUTH":

        // get username and password
        String username = tokens.nextToken();
        String password = tokens.nextToken();

        // check if user exists.
        boolean isFound = this.matchUser(username, password);

        // if the user is found.
        if (isFound) {

          this.activeUsers.add(username);
          this.user_ports.add(this.clientSocket.getPort());

          // formulate response message and send message
          System.out.println("Login successful.");

          String message = "Login sucess";
          this.sendResponse(message);
        }

        break;
      case "LIST":

        ArrayList<String> users = this.getFileList();

        String message = "";

        for (int x = 0; x < users.size(); x++) {
          message += users.get(x);
        }

        sendResponse(message);

        break;
      case "PDFRT":

        String pdf_id = tokens.nextToken();
        String file = this.idToFile(pdf_id);

        sendResponse(file);

        break;
      case "LOGOUT":

        System.out.println("Client trying to logout.");

        int port = this.clientSocket.getPort();

        if (this.user_ports.indexOf(port) != -1) {

          System.out.println("Removing user ... ");

          int index = this.user_ports.indexOf(port);

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

  /**
   * This function takes username and password Then returns a true of false
   * depending on whether or not, a user exists in text file.
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

        String file = scan.nextLine();

        if (file.equalsIgnoreCase(ID)) {

          result = ID;

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

  private void sendResponse(String message) {
    String response = "200 " + message;

    bw.println(response);
    bw.flush();
  }

  private void sendError(String message) {
    String response = "500 " + message;

    bw.println(response);
  }
}
