import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * SMTPClient
 */
public class SMTPApplication extends VBox {

  SMTPClient client;

  private Label senderLabel;
  private TextField senderName;

  private Label recepientLabel;
  private TextField recepientName;

  private Label subject;
  private TextField subjectText;

  private Label body;
  private TextField bodyText;

  private Button send;

  public SMTPApplication() throws Exception {

    // client = new SMTPClient();

    senderLabel = new Label("Sender's name");
    senderName = new TextField();

    recepientLabel = new Label("Recipient's Name");
    recepientName = new TextField();

    subject = new Label("Subject");
    subjectText = new TextField();

    body = new Label("Body");
    bodyText = new TextField();
    bodyText.setMinHeight(200);

    send = new Button("Send");
    send.setMinWidth(800);
    send.setMinHeight(50);

    // handle button press.
    send.setOnAction(event -> {
      String sender = senderName.getText();
      senderName.setText("");

      String recepient = recepientName.getText();
      recepientName.setText("");

      String subject = subjectText.getText();
      subjectText.setText("");

      String body = bodyText.getText();
      bodyText.setText("");

      try {
        client = new SMTPClient(sender, recepient, subject, body);
      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println(sender + " " + recepient);
    });

    this.getChildren().addAll(senderLabel, senderName, recepientLabel, recepientName, subject, subjectText, body,
        bodyText, send);
  }
}