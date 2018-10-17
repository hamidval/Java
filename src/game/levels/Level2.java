/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.levels;

import game.bodies.Coin;
import game.bodies.Apple;
import city.cs.engine.*;
import game.BlackGhost.YellowGhost;
import game.Game;
import game.Pickup;
import game.FollowGhost.FollowGhost;
import game.bodies.RedStar;
import game.bodies.RedStarListener;
import java.awt.Color;
import java.awt.Image;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;

/**
 *
 * @author hamid
 */
public class Level2 extends GameLevel {

    private static final int NUM_OF_COINS = 22;
    private int x = -5;
    private int y = 13;
    private Body z;
    private Game game;
    private int count = 0; // controls the number of objects that can be added by the timer, max 4

    public Level2() {

    }

    public Body getPlatform() {
        return z;
    }

    public void addPlayer(Game game) {

        this.game = game;

        int random = (int) Math.abs(Math.random() * 10);// creates a random number between 1 and 10

        if (count >= 4) {// max 4 objects can be added 
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

        } else if (random >= 6 && random <= 8) {

            FollowGhost ghost = new FollowGhost(game);
            ghost.setPosition(new Vec2(0, 0));
            ghost.addCollisionListener(new Pickup(getPlayer()));

        } else if (random >= 9 && random <= 10) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(0, 0));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }

    }

    /**
     * Populate the world.
     */
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

        Body ground1 = new StaticBody(this, groundShape);
        ground1.setPosition(new Vec2(0, 15.5f));

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 15, new Vec2(-11.5f, 14.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 15, new Vec2(11.5f, 14.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

        // make some platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-7, -3f));
        platform1.setAngleDegrees(90);

        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(0, -1f));
        platform2.setAngleDegrees(0);

        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(6, -2f));
        platform3.setAngleDegrees(90);

        Body platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(7, 8f));
        platform4.setAngleDegrees(0);

        for (int i = 0; i < 2; i++) {
            FollowGhost ghost = new FollowGhost(game);
            ghost.setPosition(new Vec2(-5 * i + 10, 10));
            ghost.addCollisionListener(new Pickup(getPlayer()));

        }

        for (int i = 0; i < 3; i++) {
            Body apple = new Apple(this);
            apple.setPosition(new Vec2(i * 2 - 5, -5));
            apple.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 2; i++) {
            RedStar redStar = new RedStar(this);
            redStar.setPosition(new Vec2(i * 2 - 5, -5));
            redStar.addCollisionListener(new RedStarListener(game));
        }

        for (int i = 0; i < NUM_OF_COINS; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 2 - 10, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
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
        return new Vec2(8, -10);
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

        return Color.GRAY;

    }

    @Override
    public Image getImage() {

        Image background = new ImageIcon("data/background2.png").getImage();
        return background;

    }

}
