/*
 * CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Your name(s): Robert Cruz
 */
import java.awt.*;
import java.util.Random;

public class Undead extends People{

    protected static final int MAX_LIFESPAN = 100;
    int lifespan;

    /**
     * constructor that gets a location for the undead there is no destination for the undead
     * sets lifespan to max lifespan
     */
    public Undead(Location location) {
        super(location);
        this.location = location;
        this.lifespan = MAX_LIFESPAN;



    }

    /**
     *isUndead() method returns true if lifespan is greater than 0 otherwise false
     */
    public boolean isUnDead() {
        if(lifespan > 0){
            return true;
        }
        return false;
    }

    /**
     * returns lifespan
     */
    // TODO return lifespan
    public int getLifespan(){
        return lifespan;
    }


    /**
     * Move UnDead Person either up, down, left, or right 5 units randomly
     * subtract 1 from lifespan
     */
    @Override
    public void update() {
        Random randInt = new Random();
        int direction = randInt.nextInt(4);
        final int UP = 0;
        final int DOWN = 1;
        final int LEFT = 2;
        final int RIGHT = 3;
        Location moveUp = new Location(0, -5);
        Location moveDown = new Location(0, 5);
        Location moveLeft = new Location(-5, 0);
        Location moveRight = new Location(5, 0);
        if(isUnDead()) {
            if (direction == UP) {
                location.add(moveUp);
                --lifespan;
            }
            if (direction == DOWN) {
                location.add(moveDown);
                --lifespan;
            }
            if (direction == LEFT) {
                location.add(moveLeft);
                --lifespan;
            }
            if (direction == RIGHT) {
                location.add(moveRight);
                --lifespan;
            }
        }
        }


        /**
         * paint method paints the undead people red and when they die paints them too dark grey
         */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.drawOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
        g.setColor(Color.BLACK);
        if (isUnDead())
            g.setColor(Color.RED);
        else
            g.setColor(Color.DARK_GRAY);
        g.fillOval(location.getX() - RADIUS + 1, location.getY() - RADIUS + 1, RADIUS * 2 - 1, RADIUS * 2 - 1);
        g.setColor(color);
    }


}
