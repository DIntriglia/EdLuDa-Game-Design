package game.input;

import game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener {

        private boolean [] keys = new boolean[120];
        public boolean up, down, left, right;
        
        public void tick(Game game){
            up = keys[KeyEvent.VK_W];
                      left = keys[KeyEvent.VK_A];
                             right = keys[KeyEvent.VK_D];
        }

    public void keyTyped(KeyEvent e) {
    
    }


    public void keyPressed(KeyEvent e) {
      keys[e.getKeyCode()] = true;
    
    }


    public void keyReleased(KeyEvent e) {
               keys[e.getKeyCode()] = false;
    }
    
}
