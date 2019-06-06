import csc2a.ham.TeamPane;
import csc2a.ham.TeamFileHandler;

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


	final int windowWidth = 800;
	final int windowHeight = 800;

	@Override
	public void start(Stage stage) {

		// sets the title of the stage.
		stage.setTitle("JavaFX Application.");

		// sets minimum size of canvas.
		stage.setMinHeight(windowWidth);
		stage.setMinWidth(windowHeight);
		
		// sets maximum size of canvas.
		stage.setMaxHeight(windowHeight);
		stage.setMaxWidth(windowWidth);

		// Create an instance of TeamPane class.
		TeamPane pane = new TeamPane(stage);

		// Create an scene with a width of 400 and height of 400.
		Scene scene = new Scene(pane, windowWidth, windowHeight);

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