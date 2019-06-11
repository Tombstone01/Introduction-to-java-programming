import csc2a.hamm.TeamPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import java.io.File;

/** @author Kananelo Khotle
 *  @version 0.0.1
 */
public class Main extends Application {

	@Override
	public void start(Stage stage) {

		// Create an instance of TeamPane class.
		TeamPane pane = new TeamPane(stage);

		// Create an scene with a width of 400 and height of 400.
		Scene scene = new Scene(pane, 400, 400);

		// sets the title of the stage.
		stage.setTitle("JavaFX Application.");

		// Set the stage scene.
		stage.setScene(scene);

		// Show stage on the screen.
		stage.show();
	}

	// main static method.
	public static void main(String[] args) {
		
		// launch application.
		launch(args);
  }
}