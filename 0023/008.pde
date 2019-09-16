PImage image1, image2;
int threshold = floor(random(255));

void setup() {
  size(1400, 800);
  background(255);
  image1 = loadImage("Koala.jpg");
  image(image1, 0, 0, 700, 800);
  image2 = loadImage("Koala.jpg");
}

void draw() {
  image(image2, 700, 0, 700, 800);
  loadPixels();
  
  for (int x = 700; x < 1400; x++) {
     for (int y = 0; y < 800; y++) {
        int loc = x + y * width;
        if (brightness(pixels[loc]) > mouseX) {
          pixels[loc] = color(255); 
        } else {
          pixels[loc] = color(0); 
        }
     }
  }
  updatePixels();
  save("image.jpg");
}
