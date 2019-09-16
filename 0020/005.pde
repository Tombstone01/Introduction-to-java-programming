// Name: Kananelo Khotle
// Date: 20-11-2018

PImage image;

void setup() {
  /** Creates RGB Image **/
  image = createImage(1080, 720, RGB);
  
  /** Set the size of the canvas to be equal to the size of the  
      windows 
  **/
  size(1080, 720);
  
  /** Draw the second image **/
  image(image, 0, 0);

  loadPixels();
  
  for (int x = 0; x < 1080; x++) {
    for (int y = 0; y < 720; y++) {
       int location = x + y * width;
       pixels[location] = color(random(255), random(255), random(255));
    }
  }
  
  updatePixels();
  save("image.png");
}
