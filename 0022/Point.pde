
class Point {
  
  float x, y, r, g, b;
  
  /** Constructor **/
  Point(float x, float y) {
     this.x = x;
     this.y = y;
     
     /** Randomly pick colors for the shape
     **/ 
  }  
  
  /** Draw object on the screen
  **/
  void show() {
     ellipse(this.x, this.y, 20, 20); 
     fill(r, g, b);
  }
  
  /** Returns the x position of 
      the object.
  **/
  float getX() {
    return this.x; 
  }
  
  /** Returns the y position of
     the object
  **/
  float getY() { 
    return this.y;
  }
}
