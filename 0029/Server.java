import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.File;

public class Server implements Runnable {

  private BufferedReader in;

  // Writing binary data, like images and video.
  private DataOutputStream out;

  public Server(Socket socket) throws IOException {

    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new DataOutputStream(socket.getOutputStream());
  }

  public void run() {
    try {

      // this is the request from client.
      String request = in.readLine();

      System.out.println(request);

      if (request.split(" ")[1].equalsIgnoreCase("/") || request.split(" ")[1].startsWith("/index")) {

        // send header.
        out.writeBytes("HTTPS");
        out.writeBytes("Content type");
        out.writeBytes("File length");
        out.writeBytes("Connection close");

        // create a link to file.
        File file = new File("index.html");

        // open stream.
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[4096];

        int n = 0;

        // while there is still content.
        while ((n = bin.read(buffer)) > 0) {
          out.write(buffer, 0, n);
        }

        bin.close();

      } else if (request.split(" ")[1].startsWith("/video")) {

        // send header.
        out.writeBytes("HTTPS");
        out.writeBytes("Content type");
        out.writeBytes("File length");
        out.writeBytes("Connection close");

        // create a link to file.
        File file = new File("video.html");

        // open stream.
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024];

        int n = 0;

        // while there is content.
        while ((n = bin.read(buffer)) > 0) {
          out.write(buffer, 0, n);
        }

        // close the stream.
        bin.close();
      } else if (request.split(" ")[1].startsWith("/small")) {

        // send header.
        out.writeBytes("HTTPS");
        out.writeBytes("Content type");
        out.writeBytes("File length");
        out.writeBytes("Connection close");

        // create a link to file.
        File file = new File("small.mp4");

        // open stream.
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[1024];

        int n = 0;

        // while there is content.
        while ((n = bin.read(buffer)) > 0) {
          out.write(buffer, 0, n);
        }

        // close the stream.
        bin.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}