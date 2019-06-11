package csc2a.ham;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;

import java.util.Random;
import java.util.LinkedList;

import csc2a.ham.ui.MissionCanvas;
import csc2a.ham.models.TeamMissionEntity;
import csc2a.ham.Team;

/** This class is responsible for drawing nodes
 *  on the stackpane.
 * 
 * @author Kananelo
 * @version 0.0.1
 * 
 */
public class TeamPane extends StackPane {

  Team team;
  TeamFileHandler handler;
  TitledPane pane;
  VBox box;
  File file;
  Random random;
  LinkedList<TeamMissionEntity> missionEntities;

  /**
   * @param stage this is where everything is drawn.
   */
  public TeamPane(Stage stage) {

    /**
     * This instance is responsible for the creation of team object and also for
     * opening and reading persistent files.
     */
    handler = new TeamFileHandler();
    random = new Random();
    MissionCanvas mCanvas = new MissionCanvas((int)stage.getMinWidth(), (int)stage.getMinHeight());

    // START: Nodes starts here.
    box = new VBox();
    MenuBar menuBar = new MenuBar();

    Menu file_menu = new Menu("File");
    Menu binary_menu = new Menu("Binary");

    MenuItem file_open = new MenuItem("Open");
    MenuItem file_save = new MenuItem("Save");

    MenuItem binary_open = new MenuItem("Open");

    
    // Add menu items to menu.
    file_menu.getItems().add(file_open);
    file_menu.getItems().add(file_save);

    binary_menu.getItems().add(binary_open);

    // add menu to menu bar.
    menuBar.getMenus().addAll(file_menu, binary_menu);

    /** This lambda function is executed when BINARY->OPEN button is 
     *  pressed.
     */
    binary_open.setOnAction(e -> {

      DataInputStream dataIn = null;

      final FileChooser fileChooser = new FileChooser();

      fileChooser.setTitle("Choose the required file: ");
      fileChooser.setInitialDirectory(new File("data"));
      File file = fileChooser.showOpenDialog(stage);

      if (file.exists()) {

        // reads missionEntities.
        missionEntities = handler.readMission(file);

        System.out.println("Number of entities: " + missionEntities.size());

        // passes misssionEntities to canvas.
        mCanvas.setEntities(missionEntities);

        // redraws canvas.
        mCanvas.redrawCanvas();
      }
    });

    // add menuBar to box

    // this.setAlignment(menuBar, Pos.TOP_CENTER);
    box.getChildren().add(menuBar);
    
    // this.setAlignment(mCanvas, Pos.BOTTOM_CENTER);
    box.getChildren().add(mCanvas);

    // adds box to stackpane.
    getChildren().add(box);
  }
}