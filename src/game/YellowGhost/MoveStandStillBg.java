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
public class MoveStandStillBg extends FSMState<YellowGhost>{
    
    protected void update() {
        YellowGhost fg = getContext();
        if (fg.inRangeLeft()) {
            gotoState(new MoveLeftStateBg());
        } else if (fg.inRangeRight()) {
            gotoState(new MoveRightStateBg());
        }else{
            fg.applyImpulse(new Vec2(0,4));
          
        }
    }
    
     protected void enter() {
        YellowGhost fg = getContext();
        fg.setAngularVelocity(0);
        fg.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }
    
    
    
}
