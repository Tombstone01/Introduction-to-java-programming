/** Author: Kananelo Maxwell
**/

int num_stars = 1000;

Star[] stars;

void setup() {
  
  /** Set the  size of the display
  **/
  fullScreen(P3D);
  
  /** Initialize the array with number of stars
  **/
  stars = new Star[num_stars];
  
  /** Creates each star individually.
  **/
  for (int i = 0; i < num_stars; i++) {
    stars[i] = new Star(random(width), random(height)); 
  }
}

void draw() {
  
  /** Set the bakground to white 
  **/
  background(0);
  
  /** Draw and update each star individually
  **/
  for (int i = 0; i < num_stars; i++) {
    stars[i].show();
    stars[i].update();
  }
}
