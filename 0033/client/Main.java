import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;
import java.net.InetAddress;

public class Main {

	// this is the UPD port that the server runs on.
	private static int UDP_PORT = 9876;

	public static void main(String[] args) throws Exception {

		// this socket is used to communicated with the server.
		DatagramSocket clientSocket = new DatagramSocket();

		System.out.println("Server running");

		// while the user is not done.
		boolean isDone = false;

		while (!isDone) {

			// get InetAddress
			InetAddress address = InetAddress.getByName("localhost");

			Scanner scanner = new Scanner(System.in);

			System.out.print("Sa: ");
			String strMessage = scanner.nextLine();

			// convert the message to bytes.
			byte[] message = new String(strMessage).getBytes();

			// create a packet with destination port and address.
			DatagramPacket sendPacket = new DatagramPacket(message, message.length, address, UDP_PORT);

			// send the newly created packet.
			clientSocket.send(sendPacket);

			if (strMessage.equalsIgnoreCase("BYE")) {
				break;
			} else if (strMessage.startsWith("HELO")) {
				
				// create a buffer for a new incoming packet.
				byte[] newMessage = new byte[1024];

				// Receive packet from the server.
				DatagramPacket receivePacket = new DatagramPacket(newMessage, newMessage.length);

				// receive the payload of the packet.
				clientSocket.receive(receivePacket);

				// turn the bytes into a string.
				String newStr = new String(receivePacket.getData());

				System.out.println("S: " + newStr);
			}
		}
	}
}
