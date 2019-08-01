import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {

    ServerSocket server = null;
    Socket clientSocket = null;
    PrintWriter printWriter = null;
    BufferedReader bufferedReader = null;

    int PORT_NUM = 8888;

    try {

      // create a server on port 8080
      server = new ServerSocket(8080);

      // accept incoming server connection.
      clientSocket = server.accept();

      Thread t1 = new Thread(new Connection(clientSocket));
      t1.start();

      // // Tell the client that the can go ahead and ask some questions.
      // printWriter.println("01 WELCOME - You may ask 5 questions");
      // printWriter.flush();

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        server.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}