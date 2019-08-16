import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) throws Exception {
    launch(args);
  }

  public void start(Stage stage) throws Exception {
    stage.setTitle("Simple Mail Transfer Protocol application.");

    SMTPApplication client = new SMTPApplication();

    stage.setScene(new Scene(client, 800, 400));
    stage.show();
  }
}