import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Client
 */
public class Client implements Runnable {

  private DatagramSocket socket = null;
  private GUI gui = null;

  DatagramPacket datagramPacket = null;

  public void run() {

    System.out.println("Listening for incoming packets.");

    for (;;) {
      try {
        this.socket.receive(datagramPacket);
      } catch (Exception e) {
        e.printStackTrace();
      }

      String message = new String(datagramPacket.getData());

      this.gui.displayMassage(message);
    }
  }

  public Client(DatagramSocket socket, GUI gui) throws Exception {

    this.socket = socket;
    this.gui = gui;

    try {
      this.gui.setSocket(socket);
    } catch (Exception e) {
      e.printStackTrace();
    }

    byte[] newMessage = new byte[1024];

    datagramPacket = new DatagramPacket(newMessage, newMessage.length);
  }
}