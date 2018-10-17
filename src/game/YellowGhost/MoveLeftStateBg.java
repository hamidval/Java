/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.BlackGhost;

import game.fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 *
 * @author hamid
 */
public class MoveLeftStateBg extends FSMState<YellowGhost> {

    protected void update() {
        YellowGhost fg = getContext();
        if (fg.inRangeRight()) {
            gotoState(new MoveRightStateBg());

            //this.update();
        } else if (!fg.inRange()) {
            gotoState(new MoveStandStillBg());
        } else {
            //  fg.setAngularVelocity(2);
            fg.applyImpulse(new Vec2(-1, 0));
        }
    }

    protected void enter() {
        YellowGhost fg = getContext();
        // fg.setAngularVelocity(1);
    }

    protected void exit() {
    }

}
