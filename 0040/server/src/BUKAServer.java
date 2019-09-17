import java.net.ServerSocket;
import java.net.Socket;

public class BUKAServer {

	private static int PORT = 3000;

	public static void main(String[] argv) {

    // Setup server socket and pass on handling of request
    ServerSocket server = null;

    try {
      server = new ServerSocket(PORT);

      System.out.println("Server running on port " + PORT + ", thank you!!");
    } catch (Exception e) {
      System.out.println("S");
    }


    for (;;) {
		  try {
			  new Thread(new BUKAHandler(server.accept())).start();;
		  } catch (Exception e) {
			  // System.out.println("Problem creating a new thead."); 
		  }
    }
	}
}
