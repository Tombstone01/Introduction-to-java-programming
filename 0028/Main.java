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

  public static void main(String[] args) {

    ServerSocket server = null;
    Socket clientSocket = null;

    try {

      // create a server on port 8080
      server = new ServerSocket(PORT_NUM);

      // accept incoming server connection.
      clientSocket = server.accept();

      // create a thread.
      Thread thread = new Thread(new Connection(clientSocket));

      // start the thread.
      thread.start();

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