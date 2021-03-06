/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.bodies;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.SolidFixture;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author hamid
 */
public class Apple extends Walker {
    /**
     * 
     * @param w 
     */
       public Apple(World w) {
        super(w);
        
        PolygonShape coin = new PolygonShape(0.004f,0.434f, 0.396f,0.197f, 0.43f,-0.189f, 0.207f,-0.396f,
                -0.248f,-0.393f, -0.443f,-0.131f, -0.416f,0.154f, -0.16f,0.359f); 
        
        
        SolidFixture fixture = new SolidFixture(this, coin);
        this.addImage(new BodyImage("data/apple.png"));
        fixture.setFriction(1);
        fixture.setRestitution(0);
        
        
        
    }
}
