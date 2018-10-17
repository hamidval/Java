package game;

import game.bodies.Mouse;
import java.awt.Graphics2D;
import city.cs.engine.*;
import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author hamid
 */

public class MyView extends UserView {

    private Mouse player;
    private Game game;
    private Graphics2D g;
    private int count = 0;

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
    public MyView(World world, Mouse player, int width, int height, Image background) {
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
    //main menu buttons
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
 * @param g found at top left of the screen and displays the coin count, apple count, and live count
 */
    @Override
    public void paintForeground(Graphics2D g) {

        //Instructions i = new Instructions();    
        g.setColor(Color.white);
        g.drawString("Score: " + player.getCoinCount(), 10, 20);
        g.drawString("Apple " + player.getAppleCount(), 10, 40);
        g.drawString("Lives Left " + player.getLiveCount(), 10, 60);

    }
   

}
