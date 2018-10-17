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
public class Information extends UserView {

    private Mouse player;
    private Game game;
    private Graphics2D g;
    private int count = 0;
    private int centrew = 250;
    private int centreh = 350;

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
    public Information(World world, Mouse player, int width, int height, Image background) {
        super(player.getWorld(), width, height);

        this.player = player;

        //      new ImageIcon("data/background1.png").getImage();
    }

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
        //text to be displayed
        Font fnt0 = new Font("arial", Font.BOLD, 15);
        g.setColor(Color.white);
        g.setFont(fnt0);
        g.drawString("Welcome to Mouse Quest", 100, 100);
        g.drawString("you're on a quest to destroy the Ghosts", 100, 150);
        g.drawString("you will have to avoid contact with the Ghosts", 100, 200);
        g.drawString("or you will lose a life", 100, 250);
        g.drawString("OR WORSE!!!!!!!!!!", 100, 300);
        g.drawString("beware of their tricks", 100, 350);
        g.drawString("at each level you will be give oppertunities to", 100, 400);
        g.drawString("gain powers and lives and all of your Mouse NEEDS!!", 100, 450);
        g.drawString("feeling up to it?", 100, 500);
        g.drawString("GOOD!, put on your brave whiskers", 100, 550);
        g.drawString("and get to work!!!", 100, 600);

    }
/**
 * 
 * @param g 
 */
    public void setG(Graphics2D g) {
        this.g = g;
    }

    public Graphics2D getG() {
        return g;
    }

}
