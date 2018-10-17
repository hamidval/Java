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
public class Instructions extends UserView {

    private Mouse player;
    private Game game;
    private Graphics2D g;
    private int count = 0;
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
    public Instructions(World world, Mouse player, int width, int height, Image background) {
        super(player.getWorld(), width, height);

        this.player = player;

    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    ControlPanel2 cp2 = new ControlPanel2(game);

    /**
     *
     * @param player
     */
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

        // text to be displayed
        Font fnt0 = new Font("arial", Font.BOLD, 20);
        g.setColor(Color.white);
        g.setFont(fnt0);
        g.drawString("w = jump", 120, 150);
        g.drawString("a =  move left", 120, 250);
        g.drawString("d = move right", 120, 350);
        g.drawString("The rest is a mystery", 120, 450);
        g.drawString("If you get stuck check out 'hints'", 120, 550);

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
