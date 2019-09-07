import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedList;

public class Main {

  // server runs on this port.
  private static int UDP_POR = 9876;

  // holds the users currently logged in.
  private static LinkedList<String> users = new LinkedList<>();

  // hold list of users addresses currently logged into the server.
  private static LinkedList<InetAddress> users_addresses = new LinkedList<>();

  // hold users corresponding ports.
  private static LinkedList<Integer> users_ports = new LinkedList<>();

  /**
   * This method takes a socket, users, users_addresses and users_ports.
   * 
   * It then creates a packet and sends it to all the users currently online.
   * 
   */
  private static void handleRequests(DatagramSocket socket, LinkedList<String> users, LinkedList<InetAddress> addresses,
      LinkedList<Integer> ports, String message) throws Exception {

    String[] req = message.split(" ");

    String command = req[0];

    if (command.equalsIgnoreCase("HELO")) {

      String user = req[1];

      String response = "HELO " + user + " " + users.indexOf(user);

      System.out.println(response);

      byte[] newMessage = new String(response).getBytes();

      for (int x = 0; x < users.size(); x++) {
        DatagramPacket sendPacket = new DatagramPacket(newMessage, newMessage.length, addresses.get(x), ports.get(x));

        socket.send(sendPacket);
      }
    }
  }

  public static void main(String[] args) throws Exception {

    // Creste a server socket.
    DatagramSocket serverSocket = new DatagramSocket(UDP_POR);

    System.out.println("Server running on port " + UDP_POR);

    // loop forever.
    for (;;) {

      // create a bufferer to hold incoming messages.
      byte[] message = new byte[1024];

      // Receive the packet.
      DatagramPacket receivePacket = new DatagramPacket(message, message.length);
      serverSocket.receive(receivePacket);

      System.out.println("Packet information: ");

      System.out.println("Address: " + receivePacket.getAddress());

      // add address of user to addresses.
      users_addresses.add(receivePacket.getAddress());

      System.out.println("Port: " + receivePacket.getPort());

      // add port no of user to user_ports
      users_ports.add(receivePacket.getPort());

      System.out.println('\n');

      String receiveStr = new String(receivePacket.getData());

      String[] incoming = receiveStr.split(" ");

      if (incoming[0].equalsIgnoreCase("HELO")) {

        String user = incoming[0];

        users.add(user);

        handleRequests(serverSocket, users, users_addresses, users_ports, receiveStr);

      } else if (incoming[0].equalsIgnoreCase("BROADCAST")) {
        System.out.println("Server is message to all clients.");
      } else if (incoming[0].equalsIgnoreCase("BUDDIES")) {
        System.out.println("Server is displaying all users currently logged in.");
      } else if (incoming[0].equalsIgnoreCase("YOBUDDY")) {
        System.out.println("Client is talking to another client.");
      } else if (incoming[0].equalsIgnoreCase("BYE")) {
        System.out.println("Client is logging out.");
      }

      System.out.println("\n");
    }
  }
}