// Name: Kananelo Maxwell
// Date: 20-11-2018

void setup () {
  
  /** Sets the width and height of the canvas **/
  size(800, 400);
  
  /** Sets the background of the canvas to black **/
  background(0);
}

void draw() {
  
  /** Draw a line from the center of the canvas to the location
      of the mouse.
  **/
  line(width/2, height/2,mouseX, mouseY);
  
  /** Set the color of the line to a random color **/
  stroke(random(255), random(255), random(255));
  
  /** Set the weight of the color **/
  strokeWeight(1);
}
