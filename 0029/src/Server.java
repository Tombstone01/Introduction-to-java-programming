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
      String request = in.readLine().split(" ")[1];

      System.out.println(request);

      if (request.equalsIgnoreCase("/") || request.contains("index")) {

        File file = new File("../public/index.html");

        // send header.
        out.writeBytes("HTTP/1.1 200 OK\r\n");
        out.writeBytes("Content-Type: text/html\r\n");
        out.writeBytes("Content-Length: " + file.length());
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");

        // open stream.
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
        byte[] buffer = new byte[4096];

        int n = 0;

        // while there is still content.
        while ((n = bin.read(buffer)) > 0) {
          out.write(buffer, 0, n);
        }

        bin.close();

      } else {
        // send header.
        out.writeBytes("HTTP/1.1 404 OK\r\n");
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");

      }
    } catch (

    Exception e) {
      e.printStackTrace();

      try {
        // send header.
        out.writeBytes("HTTP/1.1 500 OK\r\n");
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");
      } catch (IOException y) {
        y.printStackTrace();
      }

    }
  }
}