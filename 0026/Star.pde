/** Author: Kananelo Maxwell
**/

class Star {
 
  float x, y;
  
  float brightness;
  float db;
  
  /** Constructor
  **/
  Star(float x, float y) {

    /** Sets both the x and y
    location of the star
    **/
    this.x = x;
    this.y = y;
    
    /** Sets the brightness of the star to
    a random number between 0 and 255
    **/
    this.brightness = random(255);
    
    /** Sets the rate of change of the brightness 
    of the star to a random number between negative 10
    and positive 10.
    **/
    this.db = random(-10, 10);
  }  
  
  void show() {
    noStroke();
    fill(this.brightness);
    ellipse(this.x, this.y, 2, 2); 
  }
  
  void update() {
    
    /** If the brightness of the star goes beyond
    a range of -255 and 255, change the rate of change
    of the brightness of the star.
    **/
    if (this.brightness < 0|| this.brightness > 255) {
      db *= -1; 
    }
    
    /** Change the brightness of the star by
    the rate of change of the star.
    **/
    this.brightness += this.db;
  }
}
