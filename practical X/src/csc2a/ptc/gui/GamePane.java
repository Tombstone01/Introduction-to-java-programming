package csc2a.ptc.gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GamePane extends StackPane {

	GameCanvas canvas = null;

  public GamePane() {
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File");
    MenuItem open_saved = new MenuItem("Open saved game");
    MenuItem save_game = new MenuItem("Save Game");
    MenuItem quit = new MenuItem("Quit");
    
		file.getItems().addAll(open_saved, save_game, quit);
		menuBar.getMenus().add(file);

    canvas = new GameCanvas(800, 550);
    VBox box = new VBox();
    
		box.getChildren().addAll(menuBar, canvas);
		getChildren().add(box);
  }
}