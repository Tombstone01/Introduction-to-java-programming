
class Object {
  
  float x, y, dx, dy, r, g, b;
  
  Object(float x, float y) {
    
    /** Sets the initial starting location of an object **/
    this.x = x;
    this.y = y;
    
    /** Change in y and x to simulated movement.
    this.dx = 1;
    this.dy = 1;
    
    /** Random pick color for the object **/
    r = random(255);
    g = random(255);
    b = random(255);
  }
  
  /** Redraws object in the new location **/
  void show() {
    ellipse(this.x, this.y, 30, 30);
    stroke(0);
    fill(r, g, b);
  }
  
  /** Updates the location of the object **/
  void update() {
    
    /** Detect boundaries **/
    if (this.x + 10 > width || this.x < 0) {
      dx *= -1;
    } else if (this.y + 10 > height || this.y < 0) {
       dy *= -1; 
    }
    
    /** Updates new location of the object **/
    this.y += dy;
    this.x += dx;
      
    /** Shows the new location of the object **/
    this.show();
  }
}
