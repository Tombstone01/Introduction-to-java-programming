import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.util.LinkedList;

public class Main {

  private static DatagramSocket serverSocket;

  // server runs on this port.
  private static int UDP_POR = 9876;

  // holds the users currently logged in.
  private static LinkedList<String> users = new LinkedList<>();

  // hold list of users addresses currently logged into the server.
  private static LinkedList<InetAddress> users_addresses = new LinkedList<>();

  // hold users corresponding ports.
  private static LinkedList<Integer> users_ports = new LinkedList<>();

  /**
   * This method sends response to a client.
   * 
   * @param response
   * @param user
   * @param packet
   * @throws Exception
   */
  private static void respondToClient(String response, String user, DatagramPacket packet) throws Exception {

    // Create and send packet.
    DatagramPacket response_packet = new DatagramPacket(new String(response).getBytes(), response.length(),
        packet.getAddress(), packet.getPort());
    serverSocket.send(response_packet);
  }

  /**
   * This function prints out active users along with their computer details.
   * 
   * @param packet
   */
  public static void sendActiveUsers(DatagramPacket packet) throws Exception {

    // send each clients information as a packet.
    for (int x = 0; x < users.size(); x++) {

      // formulate a response to client.
      String response = users.get(x) + " " + users_addresses.get(x) + " " + users_ports.get(x);

      // create a packet and send it to a client.
      DatagramPacket responsePacket = new DatagramPacket(new String(response).getBytes(), response.length(),
          packet.getAddress(), packet.getPort());
      serverSocket.send(responsePacket);
    }
  }

  public static void handleInitialConnection(String message, DatagramPacket packet) throws Exception {

    // get the name of the client
    String name = message.split(" ")[1];

    // if there is active users, please display them.
    if (users.size() > 0) {
      sendActiveUsers(packet);
    }

    // add user to active users.
    addUser(name, packet);

    System.out.println("C" + users.size() + " starts up");

    // formulate a response.
    String response = "AWE " + name + ", " + users.size();

    System.out.println(response);

    respondToClient(response, name, packet);
  }

  /**
   * This function add a user to a list of active users.
   * 
   * @param name
   * @param packet
   */
  public static void addUser(String name, DatagramPacket packet) {
    users.add(name);
    users_addresses.add(packet.getAddress());
    users_ports.add(packet.getPort());
  }

  /**
   * This function removes a users from a list of active users.
   * 
   * @param packet
   */
  public static void removeUser(DatagramPacket packet) {

    // get port address of client to remove.
    int port = packet.getPort();

    // get the location of the client.
    int index = users_ports.indexOf(port);

    // delete client information.
    users.remove(index);
    users_ports.remove(index);
    users_addresses.remove(index);
  }

  /**
   * This function broadcasts a message to all active clients.
   * 
   * @param message
   */
  public static void broadcastToAllClients(String message) throws Exception {

    String[] responseArr = message.split(" ");
    String response = "";

    // extract message from a client command.
    for (int x = 1; x < responseArr.length; x++) {
      response += responseArr[x] + ' ';
    }

    response = response.trim();

    // send response to all active clients.
    for (int x = 0; x < users.size(); x++) {

      // create datagram packet and send it to client.
      DatagramPacket responsePacket = new DatagramPacket(new String(response).getBytes(), response.length(),
          users_addresses.get(x), (int) users_ports.get(x));
      serverSocket.send(responsePacket);
    }
  }

  /**
   * This function responds with an error client.
   * 
   * @param packet
   */
  public static void sendError(DatagramPacket packet) throws Exception {

    String response = new String("OUCH");

    // formulate a response packet to the client for the error they made.
    DatagramPacket datagramPacket = new DatagramPacket(response.getBytes(), response.length(), packet.getAddress(),
        packet.getPort());
    serverSocket.send(datagramPacket);
  }

  /**
   * This is the main method.
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    // Creste a server socket.
    serverSocket = new DatagramSocket(UDP_POR);

    System.out.println("S - indicates server.");
    System.out.println("Ca - indicates client A.");
    System.out.println("Cb - indicates client B.");

    System.out.println();
    System.out.println("Server is running");

    // loop forever and wait for incoming connection.
    for (;;) {

      // create a bufferer to hold incoming messages.
      byte[] message = new byte[1024];

      // Receive the packet.
      DatagramPacket receivePacket = new DatagramPacket(message, message.length);
      serverSocket.receive(receivePacket);

      String receiveStr = new String(receivePacket.getData());

      if (receiveStr.startsWith("HELO")) {

        System.out.println("Incoming requests.");

        handleInitialConnection(receiveStr, receivePacket);
      } else if (receiveStr.startsWith("BROADCAST")) {

        sendActiveUsers(receivePacket);

        System.out.println("Server is message to all clients.");
      } else if (receiveStr.startsWith("BUDDIES")) {
        // display all active users.
        sendActiveUsers(receivePacket);

        System.out.println("Displaying all active users.");
      } else if (receiveStr.startsWith("YOBUDDY")) {
        System.out.println("Client is talking to another client.");
      } else if (receiveStr.startsWith("BYE")) {
        // remove client from active client.
        removeUser(receivePacket);

        System.out.println("Removing client from active clients.");
      } else {
        sendError(receivePacket);

        System.out.println("Some error happened.");
      }
    }
  }
}
