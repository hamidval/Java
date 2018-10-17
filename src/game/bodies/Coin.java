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
public class Coin extends Walker {
    /**
     * 
     * @param w 
     */
       public Coin(World w) {
        super(w);
        
        PolygonShape coin = new PolygonShape(-0.015f,0.496f, 0.468f,0.167f, 0.458f,-0.186f, 0.182f,-0.461f,
                -0.299f,-0.411f, -0.479f,-0.165f, -0.437f,0.257f, -0.163f,0.457f); 
        
       
        SolidFixture fixture = new SolidFixture(this, coin);
        this.addImage(new BodyImage("data/coin2.png"));
        fixture.setFriction(1);
        fixture.setRestitution(0);
        fixture.setDensity(10);
        
       
    }
}
