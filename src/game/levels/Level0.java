package game.levels;

import game.Game;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hamid
 */
public class Level0 extends GameLevel {

    private static final int NUM_COINS = 11;
    private int count = 0;

    //main menu
    @Override
    public void populate(Game game) {
        super.populate(game);
        
   }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() == 0;
    }

    @Override
    public Color getBackgroundColor() {

        return Color.MAGENTA;

    }

    @Override
    public Image getImage() {

        Image background = new ImageIcon("data/background.png").getImage();
        return background;

    }

}
