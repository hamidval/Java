/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.levels;

import city.cs.engine.Body;
import game.bodies.DoorListener;
import game.bodies.Door;
import game.bodies.Mouse;
import city.cs.engine.World;
import game.BlackGhost.YellowGhost;
import game.FollowGhost.FollowGhost;
import game.Game;
import game.Pickup;
import game.bodies.Apple;
import game.bodies.Coin;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jbox2d.common.Vec2;

/**
 *
 * @author hamid
 */
public abstract class GameLevel extends World {

    private Mouse player;
    private Game game;
    private World world;
    private int count;

    public GameLevel() {

    }

    /**
     *
     * @param g
     */

    public void render(Graphics2D g) {

        Font fnt0 = new Font("arial", Font.BOLD, 20);
        g.setColor(Color.white);
        g.setFont(fnt0);
        g.drawString("w = jump, a = left, d = right", 150, 350);

    }

    /**
     *
     * @param world
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /**
     *
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     *
     * @return
     */
    public Mouse getPlayer() {
        return player;
    }

    /**
     * Populate the world of this level. Child classes should this method with
     * additional bodies.
     */
    /**
     *
     * @param game
     */
    public void populate(Game game) {
        player = new Mouse(this);
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
        this.game = game;
        setWorld(this);

    }

    /**
     * The initial position of the player.
     */
    public abstract Vec2 startPosition();

    /**
     * The position of the exit door.
     */
    public abstract Vec2 doorPosition();

    /**
     * Is this level complete?
     */
    public abstract boolean isCompleted();

    public abstract Color getBackgroundColor();

    public abstract Image getImage();

}
