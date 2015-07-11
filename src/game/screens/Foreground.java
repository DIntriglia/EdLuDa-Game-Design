
package game.screens;

import game.Game;
import game.input.KeyBoard;
import java.awt.Color;


import java.awt.Graphics;

public class Foreground {
     int width = 50;
     int height = 50;
     int x = 0;
     int y = 0;
    private int speed = 5;
    int [] pixels;
    Game game;
    KeyBoard key;
    
    
    
    
    public Foreground(int x, int y){
    this.x=x;
    this.y=y;
}


public void render(Graphics g){
    g.setColor(Color.blue);
    g.fillRect(0,0,width,height);
    
    for (int y = 0; y < height; y++){
    for (int x = 0; x < width; x++){
        
            }
    }
    }


    public void tick(Game game) {
        if (Game.key.left){
            x+=5;
        }
        if (Game.key.right){
            x-=5;
        }
    }
}
