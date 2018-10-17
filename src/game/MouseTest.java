package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Dummy mouse listener.
 */

public class MouseTest implements MouseListener {
/**
 * 
 * @param e 
 */
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }
/**
 * 
 * @param e 
 */
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
    }
/**
 * 
 * @param e 
 */
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }
/**
 * 
 * @param e 
 */
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
    }
/**
 * 
 * @param e 
 */
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }
   
}
