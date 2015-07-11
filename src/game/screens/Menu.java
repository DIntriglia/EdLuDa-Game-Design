
package game.screens;

import game.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Menu {
    private static Game game;
    
    private static Rectangle play, options, quit;
    private static int centerX = game.width/2;
    private static int centerY = game.height/2;
    
    public static void create(){
        int fillerY = 150;
        play= new Rectangle(centerX - 100, fillerY, 200, 50);
        options = new Rectangle(centerX - 100, fillerY+=60,200,50);
        quit = new Rectangle(centerX - 100, fillerY+=60,200,50);
    }
    
    public static void drawButton(Graphics g, Rectangle rect, String text, int offsetX){
        Font font = new Font("Arial", Font.BOLD, 45);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(text, rect.x + offsetX, rect.y + 38);
    }
    
    public static void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, game.width, game.height);
        drawButton(g, play, "Play", 55);
        drawButton(g, options, "Options", 15);
        drawButton(g, quit, "Quit", 55);
        
    }
}
