// Name: Kananelo Khotle
// Date: 20-11-2018

int no_of_objects = 10;

Object[] obj = new Object[no_of_objects];

void setup() {
  
  /** Sets the size of the canvas **/
  size(800, 800);
  
  /** Creates a new object of type of Object **/
  for (int i = 0; i < no_of_objects; i++) {
    obj[i] = new Object(random(800), random(800));
  }
}

void draw() {
  
  /** Sets the backgroud to white **/
  background(255);
  
  for (int i = 0; i < no_of_objects; i++) {
    /** Update the object class **/
    obj[i].update();
    
    /** Show the updates to the screen **/
    obj[i].show();     
  }
}
