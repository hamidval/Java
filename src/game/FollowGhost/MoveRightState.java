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
public class MoveRightState extends FSMState<FollowGhost> {

    protected void update() {
        FollowGhost fg = getContext();
        if (fg.inRangeLeft()) {
            gotoState(new MoveLeftState());

           
        } else if (!fg.inRange()) {
            gotoState(new MoveStandStillState());

        } else {
            fg.applyImpulse(new Vec2(1, 0));// moves the ghost right

        }
    }

    protected void enter() {
        FollowGhost fg = getContext();
        
    }

    protected void exit() {
    }
}
