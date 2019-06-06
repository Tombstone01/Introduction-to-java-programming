package csc2a.hamm;

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
import java.io.File;
import java.util.Random;

/** This class is responsible for stroring nodes that
 *  will be responsible for opening team transmission
 *  file and displaying the contents on a GUI.
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

    /** @param stage this is where everything is drawn.
     */
    public TeamPane(Stage stage) {

      random = new Random();
      box = new VBox();

      // Draw menu bar on stage.
      createMenuBar(stage, box);
    }

    /** This function attemps to add 
     *  menu bar to the stage.
     * 
     *  @param stage the canvas to draw on.
     *  @param box to draw on stage.
     */
    private void createMenuBar(Stage stage, VBox box) {

      // An instance of menubar.
      MenuBar menuBar = new MenuBar();

      Menu menu = new Menu("File");
      MenuItem menuItem_1 = new MenuItem("Open");
      MenuItem menuItem_2 = new MenuItem("Save");

      handleOpenFile(stage, menuItem_1);
      handleSaveFile(menuItem_2);

      // Add menu items to menu.
      menu.getItems().add(menuItem_1);
      menu.getItems().add(menuItem_2);

      // add menu to menu bar.
      menuBar.getMenus().add(menu);

      // add menuBar to box
      // box.getChildren().add(menuBar);
      box.getChildren().add(menuBar);

      // add box to stackpane.
      getChildren().add(box);

      // set the position of the menu bar.
      setAlignment(Pos.TOP_CENTER);
    }

    /** This method opens a file in storage.
     *  From the opened file, create a team.
     *  The show the information to the stage.
     * 
     * @param stage this is what to draw nodes on.
     * @param menuItem this is the button to press to open file.
     */
    private void handleOpenFile(Stage stage, MenuItem menuItem) {
      
      // fileChooser lets user pick a file 
      // from the file system.
      final FileChooser fileChooser = new FileChooser(); 
    
      // lambda function.
      menuItem.setOnAction(e -> {
      
        /** This instance is responsible for the creation of team object and
         *  also for opening and reading persistent files.
         */
        handler = new  TeamFileHandler();

        /** Prompt the user to choose a file in persistent memory.
         *  Then create a handle to the file so that it can be 
         *  read.
         */
        final File file = fileChooser.showOpenDialog(stage);
          
        /** Read file then recreate team information 
         *  from opened file.
         */

        team = handler.readTeam(file);
          
        /** Each of the following panes contains information
         *  about a specific part of the team, like team information, 
         *  leader information and members information.
         */
        TitledPane teamInfo = readTeamInfo();
        TitledPane leaderInfo = readLeaderInfo();
        TitledPane matesInfo = readMembersInfo();

        // Create an instanc ef accordion class.
        Accordion accordion = new Accordion();

        // Add titledpanes to the accordion.
        accordion.getPanes().addAll(teamInfo, leaderInfo, matesInfo);

        // Add accordion to vertical box.
        box.getChildren().add(accordion);
      });
    }

    /** This function saves information to the text file 
     * 
     *  @param MenuItem this is a menu item.
    */
    private void handleSaveFile(MenuItem menuItem) {
      menuItem.setOnAction(event -> {
        System.out.println("Saving information to file.");
      });
    }
  
    /** This function read team members information 
     *  from Team class.
     * 
     *  @return TitledPane
    */
    private TitledPane readTeamInfo() {
      
      // Creates an instance of TitledPane and GridPane.
      TitledPane teamInfo = new TitledPane();
      GridPane gridPane = new GridPane();

      // Sets text to the TitledPane.
      teamInfo.setText("Team information");

      // Adds nodes to the gridpane.
      gridPane.add(new Label("Team ID: "), 1, 0);
      gridPane.add(new TextField(team.getID()), 2, 0);
      gridPane.add(new Label("Team name: "), 1, 1);
      gridPane.add(new TextField(team.getName()), 2, 1);
      gridPane.add(new Label("Team slogan: "), 1, 2);
      gridPane.add(new TextField(team.getSlogan()), 2, 2);

      // adds gridpane to the stackpane.
      teamInfo.setContent(gridPane);

      // returns the instance of TitledPane.
      return teamInfo;
    }

    /** This function is responsible for
     *  working with leader data read from
     *  an external file.
     * 
     *  @return TitlePane
     */
    private TitledPane readLeaderInfo() {
      
      // Create an instance of titledPane and gridPane.
      TitledPane teamInfo = new TitledPane();
      GridPane gridPane = new GridPane();
      ProgressBar progressBar = new ProgressBar();

      // Write text on the titledPane.
      teamInfo.setText("Leader information.");

      // Add labes and textfield to the gridpane.
      gridPane.add(new Label("Leader ID: "), 1, 0);
      gridPane.add(new TextField(team.getLeader().getID()), 2, 0);
      gridPane.add(new Label("Leader name: "), 1, 1);
      gridPane.add(new TextField(team.getLeader().getName()), 2, 1);
      gridPane.add(new Label("Progress: "), 1, 2);
      gridPane.add(progressBar, 2, 2);

      // set the progress of a hero.
      progressBar.setProgress(random.nextInt(99));

      // add gridpane to titledPane.
      teamInfo.setContent(gridPane);

      // return titledPane.
      return teamInfo;
    }

    /** This function is responsible for 
     *  retrieving members information 
     *  from the team class and displays their
     *  information using TitledPane.
     * 
     *  @return TitledPane
     */
    private TitledPane readMembersInfo() {
      
      // Creates an instance of TitledPane and GridPane.
      TitledPane teamInfo = new TitledPane();
      GridPane gridPane = new GridPane();
      
      // Sets the text of the TitlePane.
      teamInfo.setText("Team members");

      // Loop through the members of the team.
      for (int i = 0; i < team.getMembers().length; i++) {

        // Adds label to the grid pane.
        gridPane.add(new Label("Member " + (i+1) + "\t"), 1, i);

        // Adds members name to the gridpane.
        gridPane.add(new TextField(team.getMembers()[i]), 2, i);
      }

      // Adds gridpane to the titledpane.
      teamInfo.setContent(gridPane);

      // returns titledpane.
      return teamInfo;
    }
}