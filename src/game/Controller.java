package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {

    private static int y = 13;
    private static float JUMPING_SPEED = y;
    private static float power_side = 7;
    private static float power_up = 20;
    public int z = 7;
    private Walker body;
    private int x = 0;
/**
 * 
 * @param body of main character
 */
    public Controller(Walker body) {
        this.body = body;

    }

    public int getZ() {// not using at the moment, but may need in future to increase speed of character when they collect red star
        return z;
    }
/**
 * 
 * @param z 
 */
    public void setZ(int z) {// not using at the moment, usesd for increasing speed of main character on collection of red star
        this.z = z;
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            body.startWalking(-z); // A = walk left
        } else if (code == KeyEvent.VK_D) {
            body.startWalking(z);// D = walk right
        } else if (code == KeyEvent.VK_O) {
            body.startWalking(-power_side);// O = speed walk left
        } else if (code == KeyEvent.VK_P) {
            body.startWalking(power_side);// P = speed walk right
        } else if (code == KeyEvent.VK_ENTER) {// enter = pause
            body.getWorld().stop();
        } else if (code == KeyEvent.VK_SHIFT) {// shift = restart
            body.getWorld().start();
        } else if (code == KeyEvent.VK_9) {//allows character to fly once gold start is collected 

            body.applyImpulse(new Vec2(0, x));

        }
    }
/**
 * 
 * @param x 
 */
    public void setForce(int x) {// sets the y value for the force to be applied to character 
        this.x = x;
    }

    public int getForce() { // gets the y value of the force applied to character
        return x;
    }
/**
 * 
 * @param y 
 */
    public void setJumpSpeed(int y) {// allows me to change the jumping speed, may use in future
        this.y = y;
    }

    public int getJumpSpeed() {// gets the jumping speed, may use in future
        return y;
    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {// stops the character from moving when key is released
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {// stops the character from moving when key is released
            body.stopWalking();
        }
    }
/**
 * 
 * @param body 
 */
    public void setBody(Walker body) {
        this.body = body;
    }
}
