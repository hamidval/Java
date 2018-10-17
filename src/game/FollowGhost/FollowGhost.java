/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.FollowGhost;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.Walker;
import game.Game;

import game.fsm.FSM;

/**
 *
 * @author hamid
 */
public class FollowGhost extends Walker implements StepListener {

    private Game game;
    private FSM<FollowGhost> fsm;
/**
 * 
 * @param game 
 */
    public FollowGhost(Game game) {
        super(game.getWorld(), shape);
        addImage(image);
        this.game = game;
        orangeCount = 0;
        SolidFixture fixture = new SolidFixture(this, shape);
        fixture.setFriction(0.1f);
        fixture.setRestitution(1);
        fsm = new FSM<FollowGhost>(this, new MoveStandStillState());
        getWorld().addStepListener(this);

    }

    private int orangeCount;
    private static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);

    private static final BodyImage image
            = new BodyImage("data/ghost.png", 2.0f);

    public int getOrangeCount() {
        return orangeCount;
    }

    public void incrementOrangeCount() {
        orangeCount++;
        System.out.println("Tasty!  Orange count = " + orangeCount);

    }

    public boolean inRangeLeft() {
        Body a = game.getActor2();
        float gap = getPosition().x - a.getPosition().x;
        //System.out.println(a.getPosition().x);
        return gap < 5 && gap > 0;

    }

    public boolean inRangeRight() {
        Body a = game.getActor2();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -5 && gap < 0;
    }

    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }
/**
 * 
 * @param e 
 */
    public void preStep(StepEvent e) {
        fsm.update();
    }
/**
 * 
 * @param e 
 */
    public void postStep(StepEvent e) {
    }
}
