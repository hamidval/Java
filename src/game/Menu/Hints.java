package game.Menu;

import game.bodies.Mouse;
import java.awt.Graphics2D;
import city.cs.engine.*;
import game.ControlPanel2;
import game.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

/**
 *
 * @author hamid
 */
public class Hints extends UserView {

    private Mouse player;
    private Game game;
    private Graphics2D g;
    private int count = 0;
    private int centrew = 250;
    private int centreh = 350;
/**
 * 
 * @return 
 */
    public Game getGame() {
        return game;
    }
/**
 * 
 * @param game 
 */
    public void setGame(Game game) {
        this.game = game;

    }

    private Image background;

    //private Image background;
    /**
     *
     * @param world
     * @param player
     * @param width
     * @param height
     * @param background
     */
    public Hints(World world, Mouse player, int width, int height, Image background) {
        super(player.getWorld(), width, height);

        this.player = player;

        //      new ImageIcon("data/background1.png").getImage();
    }
/**
 * 
 * @return 
 */
    public int getCount() {
        return count;
    }
/**
 * 
 * @param count 
 */
    public void setCount(int count) {
        this.count = count;
    }

    ControlPanel2 cp2 = new ControlPanel2(game);

    public void setPlayer(Mouse player) {
        this.player = player;
    }
/**
 * 
 * @param background 
 */
    public void setBackground(Image background) {
        this.background = background;
    }
/**
 * 
 * @param g 
 */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
/**
 * 
 * @param g 
 */
    @Override
    public void paintForeground(Graphics2D g) {
        //text to be displayed
        Font fnt0 = new Font("arial", Font.BOLD, 15);
        g.setColor(Color.white);
        g.setFont(fnt0);
        g.drawString("Apple's can be a gift and a curse", 50, 250);
        g.drawString("Got a red star?, I think you'll figure it out", 50, 300);
        g.drawString("Picked up a gold star?, try tapping '9', you never know? ", 50, 350);
        g.drawString("Picked up Blue star?, touch a white ghost!, I dare you!! ", 50, 400);

    }
/**
 * 
 * @param g 
 */
    public void setG(Graphics2D g) {
        this.g = g;
    }
/**
 * 
 * @return 
 */
    public Graphics2D getG() {
        return g;
    }

}
