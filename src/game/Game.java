package game;

import game.levels.GameLevel;
import game.Menu.Instructions;
import game.levels.Level0;
import city.cs.engine.Body;
import city.cs.engine.World;
import game.Menu.Hints;
import game.Menu.Information;
import game.bodies.Mouse;
import game.levels.Level1;
import game.levels.Level4;
import game.levels.Level3;
import game.levels.Level2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */

public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    
    private GameLevel world;

    Container cp2 = new ControlPanel2(this);

    private int level = 0;
    // all the images used in the levels and are changed as levels are incremented
    private Image img5 = new ImageIcon("data/firebackground.jpg").getImage();
    private Image img = new ImageIcon("data/greenbackground.png").getImage();
    private Image img3 = new ImageIcon("data/background3.png").getImage();
    private Image img4 = new ImageIcon("data/background4.png").getImage();
    private Image img6 = new ImageIcon("data/blackbackground.jpg").getImage();
    final JFrame frame = new JFrame("Multi-level game");

    //private Level1 world;
    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;
    private Instructions view2;
    private Information view3;
    private Hints view4;
    private Game game;
    private Controller controller;
    private Graphics2D g;
    private int width = 500;
    private int height = 700;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        
        world = new Level0();
        world.populate(this);

        //view = new MyView(world, 700, 700);
        //main menu views
        view = new MyView(world, world.getPlayer(), width, height, img);
        view2 = new Instructions(world, world.getPlayer(), width, height, img);
        view3 = new Information(world, world.getPlayer(), width, height, img);
        view4 = new Hints(world, world.getPlayer(), width, height, img);
        // view.setBackground(world.getBackgroundColor());
        view.setBackground(img);
        view.setGame(game);
        view.add(cp2, BorderLayout.CENTER);

        world.getPlayer().setPosition(new Vec2(0, -20));

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);
        // display the view in a frame
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.WEST);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer());

        //   frame.addKeyListener(new Controller(world.getPlayer()));
        frame.addKeyListener(controller);

        world.start();

    }

    public Mouse getPlayer() {
        return world.getPlayer();
    }

    public MyView getView() {
        return view;
    }

    public void pause() {
        world.stop();
    }

    public void restart() {
        world.start();
    }

    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    public int Level() {
        return level++;
    }

    public int decrementLevel() {
        return level--;
    }

    public int getLevel() {
        return level;
    }
/**
 * 
 * @param i 
 */
    public void setLevel(int i) {
        level = i;
        goNextLevel();
        
    }

    public void changeController() {

        controller.setForce(20);

    }

    public void change2Controller() {

        controller.setZ(20);

    }

    public Game getGame() {
        return this;
    }
/**
 * 
 * @param game 
 */
    public void setGame(Game game) {
        this.game = game;
    }

    public void RedGhostContact() { // if the character touches redGhost take back one level
        world.stop();
    }

    public void goNextLevel() {
        world.stop();
        Mouse oldMouse = world.getPlayer();// getting the old mouse
        level++;

        //System.out.println(level);
        if (level == 1) {
            view2.setVisible(false);
            frame.add(view);

            world = new Level1();

            // fill it with bodies
            world.populate(this);

            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(oldMouse.getCoinCount());// setting coin count to coin count of mouse on previous level
            world.getPlayer().setAppleCount(oldMouse.getAppleCount());// setting apple count to coin count of mouse on previous level
            world.getPlayer().setLiveCount(oldMouse.getLiveCount());// setting live count to coin count of mouse on previous level

            // show the new world in the view
            view.setBackground(img);// setting the background
            view.remove(cp2);// removing main menu buttons

            view.setPlayer(world.getPlayer());
            view.setWorld(world);
            img = world.getImage();
            
            world.start();

        } else if (level == 2) {

            // get a new world
            world = new Level2();

            // fill it with bodies
            world.populate(this);

            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(oldMouse.getCoinCount());// setting coin count to coin count of mouse on previous level
            world.getPlayer().setAppleCount(oldMouse.getAppleCount());// setting apple to coin count of mouse on previous level
            world.getPlayer().setLiveCount(oldMouse.getLiveCount());// setting live count to coin count of mouse on previous level

            // show the new world in the view
            view.setBackground(img5);
            view.setPlayer(world.getPlayer());
            view.setWorld(world);
            img = world.getImage();

            world.start();

        } else if (level == 3) {
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(oldMouse.getCoinCount());// setting coin count to coin count of mouse on previous level
            world.getPlayer().setAppleCount(oldMouse.getAppleCount());// setting apple count to coin count of mouse on previous level
            world.getPlayer().setLiveCount(oldMouse.getLiveCount());// setting live count to coin count of mouse on previous level
            // show the new world in the view
            view.setWorld(world);
            //  view.setBackground(world.getBackgroundColor());
            view.setBackground(img3);

            view.setPlayer(world.getPlayer());
            view.setWorld(world);
            controller.setZ(6);// make void as I have found alternative method
            //  this.changeController();

            world.start();

        } else if (level == 4) {

            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());

            world.getPlayer().setCoinCount(oldMouse.getCoinCount());// setting coin count to coin count of mouse on previous level
            world.getPlayer().setAppleCount(oldMouse.getAppleCount());// setting apple count to coin count of mouse on previous level
            world.getPlayer().setLiveCount(oldMouse.getLiveCount());// setting live count to coin count of mouse on previous level
            // show the new world in the view

            view.setPlayer(world.getPlayer());
            view.setWorld(world);
            //   view.setBackground(world.getBackgroundColor());
            view.setBackground(img4);
            world.start();

        } else if (level == 5) {
            System.exit(0);
        } else if (level == 6) {//instructions
           // System.out.println("in level 6");

            // get a new world
            //   world = new Instructions();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            view2.remove(cp2);
            view.setVisible(false);
            frame.add(view2);
            view2.setVisible(true);

            //view.Instructions(view.getG());
            world.getPlayer().setCoinCount(oldMouse.getCoinCount());
            world.getPlayer().setPosition(new Vec2(0,-1000));// setting mouse position off the screen as in instructions
            // show the new world in the view
            view2.setWorld(world);
            view2.setBackground(img6);
            world.start();

        } else if (level == 7) {
            //information

            // get a new world
            //   world = new Instructions();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            view3.remove(cp2);
            view.setVisible(false);

            frame.add(view3);
            view3.setVisible(true);
            //view.Instructions(view.getG());

            world.getPlayer().setCoinCount(oldMouse.getCoinCount());
            world.getPlayer().setPosition(new Vec2(0,-1000));// setting mouse position off the screen as in information
            // show the new world in the view
            view3.setWorld(world);
            view3.setPlayer(world.getPlayer());
            //   view.setBackground(world.getBackgroundColor());
            view3.setBackground(img6);
            world.start();

        } else if (level == 8) {
           // go back to main menu

            // get a new world
            //   world = new Instructions();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // view.remove(cp2);
            view2.setVisible(false);
            view3.setVisible(false);
            view4.setVisible(false);
            view.setVisible(true);
            frame.add(view);

            //view.Instructions(view.getG());
            world.getPlayer().setCoinCount(oldMouse.getCoinCount());
            world.getPlayer().setPosition(new Vec2(0,-1000));
            // show the new world in the view
            view.setWorld(world);
            view.setPlayer(world.getPlayer());
            //   view.setBackground(world.getBackgroundColor());
            view.setBackground(img);
            world.start();

        } else if (level == 9) {
           //hints

            // get a new world
            //   world = new Instructions();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            view4.remove(cp2);
            view.setVisible(false);

            frame.add(view4);
            view4.setVisible(true);
            //view.Instructions(view.getG());

            world.getPlayer().setCoinCount(oldMouse.getCoinCount());
            world.getPlayer().setPosition(new Vec2(0,-1000));
            // show the new world in the view
            view4.setWorld(world);
            view4.setPlayer(world.getPlayer());
            
            //   view.setBackground(world.getBackgroundColor());
            view4.setBackground(img6);
            world.start();

        }

    }

    public Body getActor2() {
        return world.getPlayer();
    }

    public World getWorld() {
        return world;
    }

    public static void main(String[] args) {
        new Game();

    }

    // uncomment to make the view track the bird
    // world.addStepListener(new Tracker(view, world.getPlayer()));
    // uncomment this to make a debugging view
    //JFrame debugView = new DebugViewer(world, 500, 500);
    // start!
}
