/* TODO: Imports */

import csc2a.pta.gui.MonitorPane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/** @author Kananelo Khotle (217080976)
 */
public class Main extends Application
{
	private int windowHeight = 500;
	private int windowWidth = 800;
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		stage.setTitle("Javafx application");
		MonitorPane pane = new MonitorPane();
		Scene scene = new Scene(pane, windowWidth, windowHeight);
		stage.setScene(scene);
		stage.show();
	}
}
