import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Kananelo Maxwell
 */

public class Main {

  private static int PORT_NUM = 8888;
  private static ServerSocket server = null;
  private static Socket clientSocket = null;

  public static void main(String[] args) {

    try {

      // create a server on port 8080
      server = new ServerSocket(PORT_NUM);

      System.out.println("Waiting for connections.");

      // accept incoming server connection.
      clientSocket = server.accept();

      // create a new thread for client connection.
      new Thread(new Connection(clientSocket)).start();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        // close the server here.
        server.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}