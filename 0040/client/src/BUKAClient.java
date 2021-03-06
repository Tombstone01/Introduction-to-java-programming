import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BUKAClient extends Application
{
    public static void main(String[] args)
    {
    	//launch the JavaFX Application
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//creates clientPane, sets up the scene and stage
		BUKAClientPane pane = new BUKAClientPane();
		Scene scene = new Scene(pane, 500, 500);

		primaryStage.setTitle("BUKA client.");
		primaryStage.setScene(scene);

		primaryStage.show();
	}
}
