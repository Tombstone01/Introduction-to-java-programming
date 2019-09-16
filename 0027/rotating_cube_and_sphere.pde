float r;
float dr;

void setup() {
  fullScreen(P3D);
  
  r = 0;
  dr = 0.01;
}

void draw() {
  background(0);
  lights();
  translate(width/2, height/2);
  noFill();
  stroke(255);
  
  rotateY(r);
  
  scale(map(mouseX, 0, width, 1, 10));
  
  box(100);
  
  sphere(50);
  
  if (abs(r) > PI) {
     dr *= -1; 
     r = 0;
  }
  
  r += dr;
  
}
