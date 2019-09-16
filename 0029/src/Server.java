import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class Server implements Runnable {

  private BufferedReader in;

  private PrintWriter printWriter;

  // Writing binary data, like images and video.
  private BufferedOutputStream out;

  public Server(Socket socket) throws IOException {

    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    printWriter = new PrintWriter(socket.getOutputStream());
    out = new BufferedOutputStream(socket.getOutputStream());
  }

  public void run() {
    try {

      // this is the request from client.
      String request = in.readLine().split(" ")[1];

      System.out.println(request);

      if (request.equalsIgnoreCase("/") || request.contains("index")) {

        File[] files = new File[2];
        files[0] = new File("../public/index.html");
        files[1] = new File("../public/small.mp4");

        BufferedInputStream bin = null;

        for (int x = 0; x < files.length; x++) {

          // send header.
          printWriter.println("HTTP/1.1 200 OK\r\n");

          System.out.println(files[x].toString().split("."));

          if (x == 0) {
            printWriter.println("Content-Type: text/html\r\n");
          } else {
            printWriter.println("Content-Type: video/mp4\r\n");
          }
          printWriter.println("Content-Length: " + files[x] + "\r\n");
          printWriter.println("Connection: close\r\n");
          printWriter.println("\r\n");

          // open stream.
          bin = new BufferedInputStream(new FileInputStream(files[x]));
          byte[] buffer = new byte[4096];

          int n = 0;

          // while there is still content.
          while ((n = bin.read(buffer)) > 0) {
            out.write(buffer, 0, n);
          }
        }

        bin.close();

      } else {
        // send header.
        printWriter.println("HTTP/1.1 404 OK\r\n");
        printWriter.println("Content-Type: text/plain\r\n");
        printWriter.println("Connection: close\r\n");
        printWriter.println("\r\n");

        // out.("404 Not Found");

      }
    } catch (IOException e) {
      e.printStackTrace();

      printWriter.println("HTTP/1.1 500 OK\r\n");
      printWriter.println("Connection: close\r\n");
      printWriter.println("\r\n");
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}