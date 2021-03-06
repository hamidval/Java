/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.levels;

import game.bodies.Star;
import game.bodies.RedGhostListener;
import game.bodies.RedGhost;
import game.bodies.Coin;
import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import game.BlackGhost.YellowGhost;
import game.Game;
import game.bodies.Mouse;
import game.Pickup;
import game.bodies.Apple;
import game.FollowGhost.FollowGhost;
import game.bodies.StarListener;
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
public class Level3 extends GameLevel {

    public static final int NUM_OF_COINS = 33;
    public Mouse mouse;
    private Game game;
    private int count = 0;

    /**
     *
     * @param game from populate method
     */
    public void addPlayer(Game game) {

        this.game = game;

        int random = (int) Math.abs(Math.random() * 10);

        if (count >= 4) {
            random = 11;
        }

        if (random <= 3) {
            YellowGhost ghost = new YellowGhost(game);

            ghost.setPosition(new Vec2(0, 0));
            ghost.addCollisionListener(new Pickup(getPlayer()));
        } else if (random >= 4 && random <= 5) {

            Body apple = new Apple(this);
            apple.setPosition(new Vec2(0, 0));
            apple.addCollisionListener(new Pickup(getPlayer()));

        } else if (random >= 6 && random <= 7) {

            FollowGhost ghost = new FollowGhost(game);
            ghost.setPosition(new Vec2(0, 0));
            ghost.addCollisionListener(new Pickup(getPlayer()));

        } else if (random >= 8 && random <= 10) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(0, 0));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }

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
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(2, 0f));

        for (int i = 0; i < 11; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i * 2 - 10, 10));
            coin.addCollisionListener(new Pickup(getPlayer()));
        }
        RedGhost redGhost = new RedGhost(this);
        redGhost.setPosition(new Vec2(0, 0));
        redGhost.addCollisionListener(new RedGhostListener(game));

        for (int i = 0; i < 3; i++) {
            FollowGhost ghost = new FollowGhost(game);
            ghost.setPosition(new Vec2(-5 * i + 10, 10));
            ghost.addCollisionListener(new Pickup(getPlayer()));
        }

        for (int i = 0; i < 2; i++) {
            Body star = new Star(this);
            star.setPosition(new Vec2(0, 0 + i * 5));
            star.addCollisionListener(new StarListener(game));

        }

        for (int i = 0; i < 3; i++) {
            Apple apple = new Apple(this);
            apple.setPosition(new Vec2(i * 2 - 10, 10));
            apple.addCollisionListener(new Pickup(getPlayer()));

        }

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleAtFixedRate(() -> {

            addPlayer(game);
            count++;

            //stuff goes here
        }, 5, 10, TimeUnit.SECONDS);// delay for 5 seconds then add object every 10 seconds

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

        return Color.CYAN;

    }

    @Override
    public Image getImage() {

        Image background = new ImageIcon("data/background.png").getImage();
        return background;

    }

}
