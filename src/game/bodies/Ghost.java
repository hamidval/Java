/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.bodies;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author hamid
 */
public class Ghost extends Walker {
   
    /**
     * 
     * @param world 
     */ 
    public Ghost(World world) {
        super(world, shape);
        addImage(image);
       
        SolidFixture fixture = new SolidFixture(this,shape);
        fixture.setFriction(0);
        fixture.setRestitution(0.99f);
        
      
        
    }
    
   
     private static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    private static final BodyImage image =
        new BodyImage("data/ghost.png", 2.0f);
    
    
    
    
}
