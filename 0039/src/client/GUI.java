import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * GUI
 */
public class GUI extends VBox {

  TextArea area = null;

  TextArea text = null;

  String message = null;

  Button submit = null;

  DatagramSocket socket = null;

  InetAddress address = null;

  private static int UDP_PORT = 9876;

  public GUI() throws Exception {

    address = InetAddress.getLocalHost();

    area = new TextArea();
    area.setEditable(false);
    area.setScrollTop(Double.MAX_VALUE);

    this.getChildren().add(area);

    text = new TextArea();
    text.setMaxHeight(200);
    text.setMaxWidth(450);

    HBox hbox = new HBox();

    submit = new Button("Send");
    submit.setMaxHeight(200);
    submit.setMaxWidth(300);

    submit.setOnAction(e -> {
      String message = text.getText();
      text.clear();

      try {
        sendMessage(message);
      } catch (Exception f) {
        f.printStackTrace();
      }
    });

    hbox.getChildren().addAll(text, submit);
    this.getChildren().add(hbox);
  }

  public void setSocket(DatagramSocket socket) throws Exception {
    this.socket = socket;
  }

  public void displayMassage(String message) {
    area.appendText(message);
  }

  public void sendMessage(String message) throws Exception {

    if (this.socket != null) {
      byte[] buffer = new String(message).getBytes();

      DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, UDP_PORT);
      this.socket.send(packet);
    }
  }
}