// Name: Kananelo Khotle
// Date: 20-11-2018

PImage image;

void setup() {
  /** Load image in processing **/
  image = loadImage("Koala.jpg");
  
  /** Set the size of the canvas to be equal to the size of the  
      windows 
  **/
  size(1024, 768);
  
  /** Draw the second image **/
  image(image, 0, 0);
  
  /** Load pixels **/
  loadPixels();
  
  /** Loop throught the width of the image **/
  for (int x = 0; x < 1024; x++) {
     /** Loop throught the height of the image **/
     for (int y = 0; y < 768; y++) {
        
        /** This is the algorithm for accessing 
            every pixel in the image
        **/
        int loc = x + y * 1024;
        
        /** Access red, green and blue channels of 
            the image.
        **/
        float r = red(pixels[loc]);
        float g = green(pixels[loc]);
        float b = green(pixels[loc]);
        
        /** If the red channel is greater than 100, 
            the reset it to 0.
        **/
        if (r > 100) {
           pixels[loc] = color(0, g, b); 
        }
     }
  }
  
  updatePixels();
}
