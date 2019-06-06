package csc2a.pta.gui;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;

import java.io.File;

import csc2a.pta.file.AnomalyFileHandler;
import csc2a.pta.model.Anomaly;

public class MonitorPane extends StackPane
{

  private MenuBar menuBar = null;
	private AnomalyCanvas canvas = null;
	VBox box = null;

	public MonitorPane()
	{

		canvas = new AnomalyCanvas();

		menuBar = new MenuBar();
		Menu menu = new Menu("File");
		MenuItem open = new MenuItem("Open");

		menu.getItems().add(open);
		menuBar.getMenus().add(menu);
				
		open.setOnAction(e -> {
			final FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File("./data"));

			File file = fileChooser.showOpenDialog(null);

			setItems(AnomalyFileHandler.readAnomalys(file));

		});
    
    box = new VBox();
		
		// Adding menu bar to box.
		box.getChildren().add(menuBar);
		box.getChildren().add(canvas);

		// adding box to stackpane.
		getChildren().add(box);
	}

	/** This method takes an array of anomaly objects
	 * 
	 *  @param items an array of anoma
	 */
	public void setItems(ArrayList<Anomaly> items)
	{		
		// add items to draw to the canvas class.
		canvas.setItems(items);

		// redraw items on the canvas.
		canvas.redrawCanvas();
	}
}
