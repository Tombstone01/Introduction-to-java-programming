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

      if (request.split(" ")[1].equalsIgnoreCase("/") || request.split(" ")[1].contains("index")) {

        // create a link to file.
        File[] files = new File[2];
        files[0] = new File("index.html");

        long size = files[0].length();

        // send header.
        out.writeBytes("HTTP/1.1 200 OK\r\n");
        out.writeBytes("Content-Type: text/html\r\n");
        out.writeBytes("Content-Length: " + size);
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");

        for (int x = 0; x < files.length; x++) {
          // open stream.
          BufferedInputStream bin = new BufferedInputStream(new FileInputStream(files[x]));
          byte[] buffer = new byte[4096];

          int n = 0;

          // while there is still content.
          while ((n = bin.read(buffer)) > 0) {
            out.write(buffer, 0, n);
          }

          bin.close();
        }

      } else if (request.split(" ")[1].startsWith("/video")) {

        // create a link to file.
        File file = new File("video.html");

        // send header.
        out.writeBytes("HTTP/1.1 200 OK");
        out.writeBytes("Content-Type: text/html");
        out.writeBytes("Content-Length: " + file.length());
        out.writeBytes("Connection: close");

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

        // create a link to file.
        File file = new File("small.mp4");

        // send header.
        out.writeBytes("HTTP/1.1 200 OK");
        out.writeBytes("Content-Type: video/mp4");
        out.writeBytes("Content-Length: " + file.length());
        out.writeBytes("Connection: close");

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