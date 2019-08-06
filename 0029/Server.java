import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.File;

public class Server implements Runnable {

  private String filename;
  private Socket socket;
  private BufferedReader in;

  // Writing binary data, like images and video.
  private DataOutputStream out;

  public Server(Socket socket) {
    this.socket = socket;
    this.filename = "index.html";
  }

  public void run() {
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new DataOutputStream(socket.getOutputStream());

      // this is the request from client.
      String request = in.readLine();

      System.out.println(request);

      if (request.split(" ")[1].equalsIgnoreCase("/")) {

        out.writeBytes("HTTPS");
        out.writeBytes("Content type");
        out.writeBytes("File length");
        out.writeBytes("Connection close");

        File file = new File("index.html");

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024];

        int n = 0;

        while ((n = bin.read(buffer)) > 0) {
          out.write(buffer, 0, n);
        }
      } else if (request.split(" ")[1].equalsIgnoreCase("/video")) {
        out.writeBytes("HTTPS");
        out.writeBytes("Content type");
        out.writeBytes("File length");
        out.writeBytes("Connection close");

        File file = new File("small.mp4");

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024];

        int n = 0;

        while ((n = bin.read(buffer)) > 0) {
          out.write(buffer, 0, n);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}