
package game.screens;

import game.Game;
import game.input.KeyBoard;
import java.awt.Color;


import java.awt.Graphics;

public class Foreground {
     int width = 50;
     int height = 50;
     int x  = 200;
     int y = 200;
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
    g.fillRect(x,y,width,height);
    }


    public void tick(Game game) {
        if (Game.key.left){
            x+=5;
            System.out.println(x);
            return;
        }
        if (Game.key.right){
            x-=5;
            return;
        }
    }
}
