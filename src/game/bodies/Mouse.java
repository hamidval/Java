package game.bodies;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Mouse extends Walker {

    private Mouse mouse;

    static public float x = 2.25f;

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    //That means there is a single shape and image for all instances of the class.
    public static final Shape shape = new PolygonShape(
            0.149f, 0.975f, 0.775f, 0.193f, 0.772f, -0.099f, 0.401f, -0.928f, -0.36f, -0.922f, -0.719f, -0.025f, -0.725f, 0.163f, -0.14f, 0.972f);
    public static final Shape shape1 = new PolygonShape(
            0.031f, 0.473f, 0.247f, 0.216f, 0.277f, -0.968f, 0.254f, -1.297f, -0.278f, -0.496f, -0.282f, -0.258f, -0.286f, 0.096f, -0.203f, 0.433f);

    public static final BodyImage image
            = new BodyImage("data/mouse.png", x);

    private int coinCount;
    private int liveCount;
    private int appleCount;
    private int starCount;
    private int blueStarCount;
    private int redStarCount;

    /**
     *
     * @param world
     */
    public Mouse(World world) {
        super(world, shape1);
        addImage(image);
        coinCount = 0;
        liveCount = 100;
        appleCount = 0;
        starCount = 0;
        blueStarCount = 0;
        redStarCount = 0;
        SolidFixture fixture = new SolidFixture(this, shape);
        fixture.setFriction(1);

    }

    public void incrementLiveCount() {
        liveCount = liveCount + 5;

    }
/**
 * 
 * @return 
 */
    public int getCoinCount() {
        return coinCount;
    }

    /**
     *
     * @param cnt
     */
    public void setCoinCount(int cnt) {

        coinCount = cnt;
    }

    public void incrementCoinCount() {
        coinCount++;
        System.out.println("WELL DONE!  Coin count = " + coinCount);

    }
/**
 * 
 * @return 
 */
    public int getLiveCount() {
        return liveCount;
    }

    /**
     *
     * @param liveCount
     */
    public void setLiveCount(int liveCount) {
        this.liveCount = liveCount;
    }

    public void decrementLiveCount() {
        liveCount--;

        System.out.println("lost life!  life count = " + liveCount);

    }

    public void loseFiveLives() {
        liveCount = liveCount - 5;
    }
/**
 * 
 * @return 
 */
    public int getAppleCount() {
        return appleCount;

    }

    /**
     *
     * @param appleCount
     */
    public void setAppleCount(int appleCount) {
        this.appleCount = appleCount;
    }

    public void incrementAppleCount() {
        appleCount++;
        shape.equals(shape1);
        System.out.println("Powerup applecount = " + appleCount);

    }
/**
 * 
 * @return 
 */
    public int redGhostContact() {
        liveCount = 0;

        return liveCount;
    }

    public int getStarCount() {
        return starCount;
    }

    /**
     *
     * @param starCount
     */
    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public void incrementStarCount() {
        starCount++;
        //  System.out.println(starCount);
    }

    public int getBlueStarCount() {
        return blueStarCount;
    }

    /**
     *
     * @param blueStarCount
     */
    public void setBlueStarCount(int blueStarCount) {
        this.blueStarCount = blueStarCount;
    }

    public void incrementBlueStarCount() {
        blueStarCount++;
    }
/**
 * 
 * @return 
 */
    public int getRedStarCount() {
        return redStarCount;
    }

    public void setRedStarCount(int blueStarCount) {
        this.redStarCount = blueStarCount;
    }

    public void incrementRedStarCount() {
        redStarCount++;
    }

}
