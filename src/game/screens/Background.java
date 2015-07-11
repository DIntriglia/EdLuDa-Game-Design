/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.screens;

import game.Game;
import game.input.KeyBoard;
import java.awt.Graphics;

/**
 *
 * @author lualdu
 */
public class Background {
    int y = 0;
    int x = 0;
     int width = Game.width;
    int height = Game.height;
    private int speed = 5;
    int [] pixels;
    Game game;
    KeyBoard key;
    
    public Background(int x, int y){
        
    }
    
    public void renderBackground(Graphics g){
    
    Menu.render(g);

}
    public void renderForeground(Graphics g){
            
        }
    
    
}
