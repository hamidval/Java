package game.levels;

import city.cs.engine.*;
import game.Game;
import game.BlackGhost.YellowGhost;
import game.FollowGhost.FollowGhost;
import game.Pickup;
import game.bodies.Apple;
import game.bodies.Coin;
import game.bodies.Ghost;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * A world with some bodies.
 */
/**
 *
 * @author hamid
 */
public class Level1 extends GameLevel {

    private Game game;
    private int count =0; // controls number of objects that can be added by the timer
    private int count2 = 0;
    private int time = 0;
    private static final int NUM_OF_COINS = 11;
    private Timer timer;
/**
 * 
 * @param game from populate method
 */
    public void addPlayer(Game game) {

        this.game = game;

        
        
        int random = (int) Math.abs(Math.random() * 10);
        
        if(count >= 4){
       
            random = 11;
        }

        if (random <= 2) {
            YellowGhost ghost = new YellowGhost(game);

            ghost.setPosition(new Vec2(0, 0));
            ghost.addCollisionListener(new Pickup(getPlayer()));
        } else if (random >= 3 && random <= 5) {
            
                Body apple = new Apple(this);
                apple.setPosition(new Vec2(0, 0));
                apple.addCollisionListener(new Pickup(getPlayer()));
            
        }else if(random >=6 && random <=8){
             
            FollowGhost ghost = new FollowGhost(game);
            ghost.setPosition(new Vec2(0, 0));
            ghost.addCollisionListener(new Pickup(getPlayer()));
           
        }else if(random >=9 && random <=10){
             Body coin = new Coin(this);
            coin.setPosition(new Vec2(0, 0));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }
        

    }
      public void actionPerformed(ActionEvent ae) {
        System.out.println("Action event!");
    }
    
    
/**
 * 
 * @param game 
 */
    @Override
    public void populate(Game game) {
        super.populate(game);

        
        
   
        
        
        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -15.5f));
        ground.setFillColor(Color.yellow);

        Shape rightWall2 = new BoxShape(9, 0.5f);
        Body rightWallShape2 = new StaticBody(this, rightWall2);
        rightWallShape2.setPosition(new Vec2(11.5f, 6));
        rightWallShape2.setFillColor(Color.RED);
        rightWallShape2.setAngleDegrees(90);

        Shape leftWall2 = new BoxShape(9, 0.5f);
        Body leftWallShape2 = new StaticBody(this, leftWall2);
        leftWallShape2.setPosition(new Vec2(-11.5f, 6));
        leftWallShape2.setFillColor(Color.BLUE);
        leftWallShape2.setAngleDegrees(90);

        Shape top = new BoxShape(12, 0.5f);
        Body topShape = new StaticBody(this, top);
        topShape.setPosition(new Vec2(0f, 15));
        topShape.setFillColor(Color.magenta);
        topShape.setAngleDegrees(0);

        Shape leftHelper = new BoxShape(2, 0.5f);
        Body leftHelperShape = new StaticBody(this, leftHelper);
        leftHelperShape.setPosition(new Vec2(-10f, -12f));
        leftHelperShape.setFillColor(Color.pink);
        leftHelperShape.setAngleDegrees(0);

        Shape rightHelper = new BoxShape(2, 0.5f);
        Body rightHelperShape = new StaticBody(this, rightHelper);
        rightHelperShape.setPosition(new Vec2(8.5f, -3f));
        rightHelperShape.setFillColor(Color.pink);
        rightHelperShape.setAngleDegrees(0);

        Shape Helper = new BoxShape(2, 0.5f);
        Body HelperShape = new StaticBody(this, Helper);
        HelperShape.setPosition(new Vec2(-8.5f, 4f));
        HelperShape.setFillColor(Color.pink);
        HelperShape.setAngleDegrees(-20f);

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);

        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make platforms
        Shape boxShape = new BoxShape(4f, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-6.5f, 2f));
        platform1.setFillColor(Color.cyan);
        platform1.setAngleDegrees(0);

        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(8, -7f));
        platform2.setFillColor(Color.ORANGE);
        platform2.setAngleDegrees(0);

        Body platform4 = new StaticBody(this, boxShape);
        platform4.setPosition(new Vec2(-2f, 2));
        platform4.setAngleDegrees(0);
        platform4.setFillColor(Color.GREEN);

        Body platform5 = new StaticBody(this, boxShape);
        platform5.setPosition(new Vec2(0f, -7f));
        platform5.setAngleDegrees(0);
        platform5.setFillColor(Color.YELLOW);

        // make a character
        
        
        Coin c = new Coin(this);
        Walker w = new Walker(this);
        w = c;
        
        
        
        for (int i = 0; i < 0; i++) {
            Ghost ghost = new Ghost(this);
            ghost.setPosition(new Vec2(-5 * i + 5, 10));
            ghost.addCollisionListener(new Pickup(getPlayer()));

        }

        for (int i = 0; i < 2; i++) {
            FollowGhost ghost = new FollowGhost(game);
            ghost.setPosition(new Vec2(-5 *i + 5, 10));
            ghost.addCollisionListener(new Pickup(getPlayer()));

        }

        for (int i = 0; i < 11; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 2 - 10, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 2; i++) {
            Body apple = new Apple(this);
            apple.setPosition(new Vec2(i * 2 - 5, 5));
            apple.addCollisionListener(new Pickup(getPlayer()));
        }
        for (int i = 0; i < 2; i++) {
            Body apple = new Apple(this);
            apple.setPosition(new Vec2(i * 2 - 5, -5));
            apple.addCollisionListener(new Pickup(getPlayer()));
        }

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(() -> {
           
            addPlayer(game);
            count++;
           
            //stuff goes here

        }, 5, 10, TimeUnit.SECONDS);

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() >= NUM_OF_COINS;
    }

    @Override
    public Color getBackgroundColor() {

        return Color.MAGENTA;

    }

    @Override
    public Image getImage() {

        Image background = new ImageIcon("data/background.png").getImage();
        return background;

    }

}
