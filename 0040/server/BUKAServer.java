import java.net.ServerSocket;

public class BUKAServer {

	private static int PORT = 3000;

	public static void main(String[] argv) {

		// Setup server socket and pass on handling of request
		BUKAServer bukaServer = new BUKAServer(new ServerSocket(PORT).accept());
	}
}
