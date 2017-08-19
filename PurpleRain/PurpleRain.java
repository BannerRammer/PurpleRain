import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PurpleRain extends PApplet {

// Lorenzo Tablante
// https://www.youtube.com/channel/UCmG6SapAb7E7nojDbYXWRcA?
// Thanks for the code

// Purple Rain
// (138, 43, 226)
// (230, 230, 250)

Drop[] drops = new Drop[500];

public void setup() {
 
 for (int i = 0; i < drops.length; i++) {
 drops[i] = new Drop();
 
  }
}

public void draw() {
  background(230, 230, 250);
  for (int i = 0; i < drops.length; i++) {
    drops[i].fall();
    drops[i].show();
  }
}
class Drop {
  float x;
  float y;
  float z;
  float len;
  float yspeed;

  
  Drop() {
    x = random(width);
    y = random(-500, -500);
    z = random(0,20);
    len = map(z, 0, 20, 1, 20);
  }
  
  public void fall() {
    y = y + yspeed;
    float grav = map(z, 0, 20, 0, 0.2f);
    yspeed = yspeed + grav;
    
    if (y > height) {
      y = random(-200, -200);
      yspeed = map(z, 0, 20, 4, 10);
    }
  }

  public void show() {
    float thick = map(z, 0, 20, 1,3);
    strokeWeight(thick);
    stroke(138, 43, 226);
    line(x,y,x,y+len);
  }
}
  public void settings() {  size(640, 360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PurpleRain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
