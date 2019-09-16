import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.IOException;

public class Main {

  private static ServerSocket serverSocket = null;
  private static Socket clientSocket = null;

  public static void main(String[] args) throws IOException {

    serverSocket = new ServerSocket(1338);

    for (;;) {

      System.out.println("Server running on " + serverSocket.getLocalPort());

      clientSocket = serverSocket.accept();
      try {
        new Thread(new Server(clientSocket)).start();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}