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
  
  void fall() {
    y = y + yspeed;
    float grav = map(z, 0, 20, 0, 0.2);
    yspeed = yspeed + grav;
    
    if (y > height) {
      y = random(-200, -200);
      yspeed = map(z, 0, 20, 4, 10);
    }
  }

  void show() {
    float thick = map(z, 0, 20, 1,3);
    strokeWeight(thick);
    stroke(138, 43, 226);
    line(x,y,x,y+len);
  }
}