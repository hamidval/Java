package game;

import game.bodies.Mouse;
import game.bodies.GreenGhost;
import game.bodies.Star;
import game.bodies.RedGhost;
import game.bodies.Ghost;
import game.bodies.Coin;
import game.bodies.Apple;
import city.cs.engine.*;
import game.BlackGhost.YellowGhost;
import game.FollowGhost.FollowGhost;
import game.bodies.BlueStar;

import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {

    private Mouse mouse;
    public Shape shape1;
    public Shape shape;
    public Body body;
    public Body platform3;
    private Ghost ghost;
    // private Level2 level;

    Controller controller = new Controller(mouse);

    public static final BodyImage image
            = new BodyImage("data/mouse.png", 3);

    /**
     *
     * @param mouse
     */
    //sets mouse to the main character at any level
    public Pickup(Mouse mouse) {
        this.mouse = mouse;
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Coin && e.getOtherBody() == mouse) { //'collecting a coin
            mouse.incrementCoinCount();
            e.getReportingBody().destroy();
        } else if (e.getReportingBody() instanceof FollowGhost && mouse.getBlueStarCount() > 0 && e.getOtherBody() == mouse) {//contact with ghosts after picking up blue star
            // mouse.decrementLiveCount();

            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Apple && e.getOtherBody() == mouse) { // collecting apples

            mouse.incrementAppleCount();

            e.getReportingBody().destroy();
            mouse.incrementLiveCount();
            mouse.addImage(image);
        } else if (e.getReportingBody() instanceof RedGhost && e.getOtherBody() == mouse) { //contact with red ghosts 
            // mouse.redGhostContact();

            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof Star && e.getOtherBody() == mouse) { // collecting the gold star

            e.getReportingBody().destroy();
            mouse.incrementStarCount();

        } else if (e.getReportingBody() instanceof GreenGhost && e.getOtherBody() == mouse) {// contact with green ghost

            mouse.destroy();

        } else if (e.getReportingBody() instanceof BlueStar && e.getOtherBody() == mouse) {//collecting blue star, kills white ghosts

            mouse.incrementBlueStarCount();
            e.getReportingBody().destroy();

        } else if (e.getReportingBody() instanceof FollowGhost && e.getOtherBody() == mouse) {// contact with white ghosts with fsm
            mouse.decrementLiveCount();

        } else if (e.getReportingBody() instanceof YellowGhost && e.getOtherBody() == mouse) { //contact with yellow ghost,
            System.out.println("contact");
            mouse.loseFiveLives();
            e.getReportingBody().destroy();

        }

        if (mouse.getLiveCount() < 1) {// lost all lives, main character is destroyed
            mouse.setPosition(new Vec2(0, 0));
            mouse.destroy();

        }

    }

}
