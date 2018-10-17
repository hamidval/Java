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
public class MoveStandStillState extends FSMState<FollowGhost> {

    
    protected void update() {
        FollowGhost fg = getContext();
        if (fg.inRangeLeft()) {
            gotoState(new MoveLeftState());
        } else if (fg.inRangeRight()) {
            gotoState(new MoveRightState());
        } else {
            fg.applyImpulse(new Vec2(0, 4));

        }
    }

    protected void enter() {
        FollowGhost fg = getContext();
        fg.setAngularVelocity(0);
        fg.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }

}
