/** Author: Kananelo Maxwell
**/

float r;
float dr;

void setup() {

  /** Set the dimensions of the canvas
  **/
  size(800, 400, P3D);
 
  /** Set the value of the angle to 0
  **/
  r = 0;
  
  /** Set the value of increment the angle by to 
      0.01
  **/
  dr = 0.01;
}

void draw() {
  
  /** Set background to black
  **/
  background(255);
  
  /** Switch the lights on
  **/
  lights();
  
  /** Move to the center of the canvas
  **/
  translate(width/2, height/2);
  
  /** Rotate by the value of r
  **/
  rotateY(r);
 
 /** Scale the object by moving the mouse h
     horizontally.
 **/
  scale(map(mouseX, 0, width, 1, 10));
  
  /** Set the sphere to have a radius of 
      60.
  **/
  sphere(60);
  
  /** If r is greater than -PI or PI,
      make the sphere rotate the other
      way around.
  **/
  if (abs(r) > PI) {
    r = 0;
    dr *= -1;
  }
  
  /** Increment the value of the angle.
  **/
  r += dr;
}
