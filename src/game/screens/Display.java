
package game.screens;

import game.Game;
import game.input.KeyBoard;
import java.awt.Color;


import java.awt.Graphics;

//image loader

public class Display {
    
    int Pwidth = 100;
    int Pheight = 300;
     int FGwidth = 3000;
     int FGheight = 100;
     int y = 0;
     int x = 0;
    private int speed = 5;
    int [] pixels;
    Game game;
    KeyBoard key;
    
    
    
    
    public Display(int x, int y){
    this.x=x;
    this.y=y;
}

public void renderB(Graphics g){
    g.setColor(Color.black);
    g.fillRect(0, 0, Game.width, Game.height);
}
    
public void renderF(Graphics g){
    g.setColor(Color.blue);
    g.fillRect(x,y,FGwidth,FGheight);
    g.drawRect(x, y, FGwidth, FGheight);
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
