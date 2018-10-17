/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.bodies;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Game;

/**
 *
 * @author hamid
 */
public class StarListener implements CollisionListener {
     private Game game;
     public int level;
     private Mouse mouse;
/**
 * 
 * @param game 
 */
    public StarListener(Game game) {
        this.game = game;
    }
/**
 * 
 * @param e 
 */
    @Override
    public void collide(CollisionEvent e) {
        Mouse player = game.getPlayer();
        if (e.getOtherBody() == player) {
            e.getReportingBody().destroy();
                game.changeController();
        }
    }
}
