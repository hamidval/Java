/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.bodies;

import game.bodies.Mouse;
import city.cs.engine.*;
import game.Game;
/**
 *
 * @author hamid
 */
public class DoorListener implements CollisionListener {
     private Game game;
     public int level;
    /**
     * 
     * @param game 
     */
    public DoorListener(Game game) {
        this.game = game;
    }
/**
 * 
 * @param e 
 */
    @Override
    public void collide(CollisionEvent e) {
        Mouse player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
                    game.goNextLevel();
        }
    }
}
