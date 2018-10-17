/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.bodies;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *
 * @author hamid
 */
public class Door extends StaticBody {
      
    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Door(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/Door.png", 2.8f));
    }
}
