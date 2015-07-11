
package game;

import game.input.KeyBoard;
import game.screens.Menu;
import java.awt.Canvas;
import game.screens.Display;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
    
    //Integers
    public static int height = 720;
    public static int width = 1280;
    public static int topx = 0;
    public static int topy = 0;
    public static int botx = 0;
    public static int boty = 620;
   
    //Statements
    private Display screen2;
    private Display  screen;
    public static KeyBoard key;
    private JFrame frame; 
    public static String Title;
    private Thread thread;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
   
    //booleans
   private boolean running = false;
   boolean fps = false;
    
    public Game() {
        Dimension size = new Dimension(width,height);
        setPreferredSize(size);
        Menu.create();
        frame = new JFrame();
        running = true;
        // create display
        screen2 = new Display(botx,boty);
        screen = new Display(topx,topy);
        //input
        key = new KeyBoard();
        frame.addKeyListener(key);
}
    
    public synchronized void start(){
           thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
                try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public void run() {
         long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;
        long timer = System.currentTimeMillis();
        double delta = 0;
        int ticks = 0;
         int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            while (delta >= 1){
                      tick();
                      ticks++;
                      fps = true;
                      delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                frame.setTitle("Noir" + "   |  " + ticks +"UPS, " + frames + "FPS");
                ticks = 0;
                frames = 0;
             }
        }
        stop();
    }
    
    
    public void tick(){
        screen2.tick(this);
        screen.tick(this);
        key.tick(this);
    }
     //render here
     public void render(){
        BufferStrategy bs = getBufferStrategy();
            if(bs ==  null){
                createBufferStrategy(3);
                return;
        }
           Graphics g = bs.getDrawGraphics();
           
           screen.renderB(g);
           screen.renderF(g);
           screen2.renderF(g);
                      
           bs.show();
           g.dispose();
           
     }

   
     
     public static void main(String[] args) {
            Game game = new Game();
            game.frame.setResizable(false);
            game.frame.setTitle("Noir");
            game.frame.add(game);
            game.frame.pack();
            game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.frame.setVisible(true);
            game.frame.setFocusable(true);
            game.frame.setLocationRelativeTo(null);

            game.start();
    }
    
}
