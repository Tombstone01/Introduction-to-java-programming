import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ServerFile
 */
public class ServerFile {

  private Socket socket = null;

  InputStream is = null;
  OutputStream os = null;

  PrintWriter pw = null;
  BufferedReader br = null;

  private final String host = "34.68.18.224";
  private final int port = 5000;

  public ServerFile() {

    System.out.println("Something");

    try {
      this.socket = new Socket(host, port);

      System.out.println("Coonected to server");

      this.is = socket.getInputStream();
      this.os = socket.getOutputStream();

      this.pw = new PrintWriter(os);
      this.br = new BufferedReader(new InputStreamReader(is));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void connect() {
    System.out.println("Thread running");
  }
}