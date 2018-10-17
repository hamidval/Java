/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.FollowGhost;

import game.fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 *
 * @author hamid
 */
public class MoveLeftState extends FSMState<FollowGhost> {

    protected void update() {
        FollowGhost fg = getContext();
        if (fg.inRangeRight()) {
            gotoState(new MoveRightState());

            
        } else if (!fg.inRange()) {
            gotoState(new MoveStandStillState());
        } else {
            //  fg.setAngularVelocity(2);
            fg.applyImpulse(new Vec2(-1, 0));//moves the ghost left
        }
    }

    protected void enter() {
        FollowGhost fg = getContext();
        // fg.setAngularVelocity(1);
    }

    protected void exit() {
    }

}
