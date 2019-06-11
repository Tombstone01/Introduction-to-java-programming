// Name: Kananelo Khotle
// Date: 20-11-2018

PImage image;

void setup() {
  image = loadImage("Koala.jpg");
  
  size(800, 400);
  background(0);
  
  /** Draw the second image **/
  image(image, 0, 0, 400, 400);
  
  /** Tint function can take 1, 2 or 3 arguements **/
  tint(100);
  
  /** Draw the first image **/
  image(image, 400, 0, 400, 400);
}
