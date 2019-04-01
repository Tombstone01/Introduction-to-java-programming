package csc2a.ham.ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.LinkedList;

import csc2a.ham.models.TeamMissionEntity;
import csc2a.ham.models.MissionEntity;

/** - This class should stpre an array of MissionEntities.
 *  - It is also used to draw mission entities on the canvas
 * 
 * @author Kananelo Khotle
 * @version 0.0.1
 */
public class MissionCanvas extends Canvas{
    
  LinkedList<TeamMissionEntity> mEntities;

  /** - This constructor sets the height and width of
   *    the canvas calling the base class.
   * 
   *  @param width - the width of the canvas
   *  @param heigth - the height of the canvas.
   */
  public MissionCanvas(int width, int height) {
    super(width-200, height-200);
  }

  /** This method set the array of MissionEntities
   *  
   * @param mEntitite an array of MissionEntities.
   */
  public void setEntities(LinkedList<TeamMissionEntity> mEntities) {
    this.mEntities = mEntities;
  }

  /** Draws shapes to the canvas.
   */
  public void redrawCanvas() {
    
    GraphicsContext gc = this.getGraphicsContext2D();

    /** The width and height of rectangle */
    int incr = 30;

    /** Keeps track of row and column */
    int keeperX = 0;
    int keeperY = 0;

    /** Loops through all the rows in the grid.
     */
    for (int i = 0; i < this.getWidth(); i+=incr) {

      /** Loops through all the columns in the grid.
       */
      for (int j = 0; j < this.getHeight(); j+=incr) {

        gc.setFill(Color.web("#92e830"));

        // draws a rectangle at a particular location
        // in canvas.
        gc.fillRect(i, j, incr, incr);

        int entNum = -1;

        // keeps track of whether a rectangle 
        // is occupied or not.
        boolean isOccupied = false;

        /** Loops through all the MissionEntities. 
         */
        for (int x = 0; x < this.mEntities.size(); x++) {

          /** If a mission entity is located at the current grid.
           */
          if (this.mEntities.get(x).getRow() == keeperX && this.mEntities.get(x).getCol() == keeperY) {
            
            // set the grid to is occupied.
            isOccupied = true;

            entNum = x;
          }
        }

        /** If the rectangle is occupied.
            draw a rectangle and circle 
            at that particular location.
        */
        if (isOccupied) {
          gc.setFill(this.mEntities.get(entNum).getHero().getStrength());
          gc.fillRect(i+2, j+2, incr-2, incr-2);
          gc.setFill(this.mEntities.get(entNum).getHero().getWeakness());
          gc.fillOval(i+5, j+5, incr-10, incr-10);
        } else {
          gc.setFill(Color.web("#6edb0f"));
          gc.fillRect(i+2, j+2, incr-2, incr-2);  
        }

        keeperY += 1;
      }
      
      keeperX += 1;
      keeperY = 0;
    }

    keeperX = 0;
  }
}