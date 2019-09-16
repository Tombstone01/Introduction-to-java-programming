int numCities = floor(random(10, 15));
Point[] points = new Point[numCities];
Point[] best;

float recordDistance;

void setup() {
  
  /** Sets the width and height of canvas
  **/
  size(800, 400);
  
  /** This array will hold an array with
      the sortest distance thus far.
  **/
  best = new Point[numCities];
  
  /** Loop through all the points in the array **/
  for (int i = 0; i < points.length; i++) {
    points[i] = new Point(random(width), random(50, height));
  }
  
  /** Calculate the distance between the cities in this order
  **/
  recordDistance = calcDistance(points);
  
  /** Make a copy of the array
  **/
  arrayCopy(points, best);
}

void draw() {
  /** Set background to white
  **/
  background(255);
  textSize(16);
  text("Distance so far: " + recordDistance, 10, 20);
  
  /** Loop through all the point in the array
  **/
  for (int i = 0; i < points.length; i++) {
    /** Show each point on the canvas
    **/
    points[i].show(); 
  }
  
  /** Draw a line between the points **/
  for (int i = 0; i < points.length - 1; i++) {
    line(best[i].getX(), best[i].getY(), best[i+1].getX(), best[i+1].getY());
  }
  
  /** Randomly pick points and swap them
  **/
  int i = floor(random(points.length));
  int j = floor(random(points.length));
  swap(points, i, j);
  
  /** Calculate the distance now
  **/
  float d = calcDistance(points);
  
  /** If the newly calculated distance is 
      less than record distance, 
      update record distance
  **/
  if (d < recordDistance) {
    recordDistance = d;
    arrayCopy(points, best);
  }
}

/** Swap two any two points in the array
**/
void swap(Point[] points, int i, int j) {
    Point temp = points[i];
    points[i] = points[j];
    points[j] = temp;
    println("Swaping: " + i + " and " + j); 
}

/** Calculate the distance between all
    points in the array
**/
float calcDistance(Point[] points) {
  
  float d = 0;
  float sum = 0;
  
  /** Loop through all the points in the array
  **/
  for (int i = 0; i < points.length - 1; i++) {
     d = dist(points[i].getX(), points[i].getY(), points[i+1].getX(), points[i+1].getY());
     sum += d;
  }
  
  return sum;
}
