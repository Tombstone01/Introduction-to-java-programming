import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * SMTPClient
 */
public class SMTPClient {

  private String mailServer = "localhost";
  private InputStream in;
  private OutputStream out;
  private InputStreamReader inReader;

  // constructor.
  public SMTPClient(String sender, String recepient, String subject, String payload) throws Exception {

    // server name and corresponding port number.
    Socket socket = new Socket(mailServer, 25);

    in = socket.getInputStream();
    out = socket.getOutputStream();

    inReader = new InputStreamReader(in);
    BufferedReader BufferedReader = new BufferedReader(inReader);

    String response = BufferedReader.readLine();
    System.out.println(response);

    String command = "HELO csc2b.uj.ac.za\r\n";

    // message to the server.
    out.write(command.getBytes("US-ASCII"));

    // response from the server.
    response = BufferedReader.readLine();
    System.out.println(response);

    command = "MAIL FROM: <" + sender + "@csc2b.uj.ac.za>";

    out.write(command.getBytes());

    response = BufferedReader.readLine();
    System.out.println(response);

    command = "DATA";

    out.write(command.getBytes());

    response = BufferedReader.readLine();
    System.out.println(response);

    out.write(payload.getBytes());

    response = BufferedReader.readLine();
    System.out.println(response);

    // close the connection.
    command = "QUIT";
    out.write(command.getBytes());

    socket.close();
  }
}