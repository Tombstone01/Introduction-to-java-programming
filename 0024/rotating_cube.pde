float r;
float dr;

void setup() {
  
  /** Set the size of the canvas to span the entire
      screen.
  **/
  fullScreen(P3D);
  
  /** Set the initial angle to be equal to
      0.
  **/
  r = 0;
  
  /** Set the value to increment the angle by
      to 0.01.
  **/
  dr = 0.01;
}

void draw() {
  
  /** Set background color to white.
  **/
  background(255);
  
  /** Switch on the lights.
  **/
  lights();
  
  /** Move to the center of the canvas.
  **/
  translate(width/2, height/2);
  
  /** Do not color the sides of the cube.
  **/
  noFill();
  
  /** Scale the size of the cube by the horizontal movements 
      of the mouse.
  **/
  scale(map(mouseX, 0, width, 1, 10));
  
  /** Rotate the cube by the value of r.
  **/
  rotateY(r);
  
  /** Set the size of the box to 50.
  **/
  box(50);
  
  /** If the angle exceeds -PI or PI, make the cube
      rotate the other way around.
  **/
  if (abs(r) > PI) {
    dr *= -1; 
    r = 0;
  }
  
  r += dr;
}
