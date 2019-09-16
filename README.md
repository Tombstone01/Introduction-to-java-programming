# :rainbow: Introduction to processing :rainbow:
This repository is designed for those who are new to processing, including myself :)

I'll be keeping track of all the information I come across as I create more sketches in processing.

## :star: Functions :star:

### setup().

This is one of the functions that processing provides and can be used to configure variables and other information that the application
will need during its execution. It is worth mentioning that this application only runs once, hence it configures information that the application will need during its execution.

### draw()

This is another function that comes with processing and has to be implemented. This function should not be called explicitly, instead it is automatically called after draw function executes. It is possible to tell this function to not run continously by calling __noLoop__ from the inside of it.

## :fire: Shapes :fire:

### rect(x, y, dx, dy) 
### rect(x, y, dx, dy, r) 
### rect(x, y, dx, dy, tl, tr, br, bl)

This function takes 4, 5 or 8 arguments and draws a rectangle on the canvas.

x - This is the x position of the rectangle. <br/>
y - This is the y position of the rectangle. <br/>
dx - This is the width of the rectangle. <br/> 
dy - This is the height of the rectangle. <br/>
r - This is the radius of all the edges of the rectangle. <br/>
tl - Sets the radius of top left radius. <br/>
tr - Sets the radius of top right radius. <br/>
br - Sets the radius of the bottom right radius. <br/>
bl - Sets the radius of the bottom left radius. <br/>

### ellipse(x, y, dx, dy)

This function takes 4 arguments and draws an ellipse on the canvas.

x - This is the x position of the ellipse. <br/>
y - This is the y position of the ellipse. <br/>
dx - This is the width of the ellipse. <br/>
dy - This is the height of the ellipse. <br/>

:heart: :heart: :heart:

