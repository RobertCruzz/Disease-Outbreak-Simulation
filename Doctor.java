/*
 * CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Your name(s): Robert Cruz
 */
import java.awt.*;
import java.util.Random;

public class Doctor extends People{


    Doctor(Location location) {
        super(location);

    }

    /**
     * updates the doctor in the gui and moves them around so that they can heal the Undead people
     */
    @Override
    public void update() {
        Random randInt = new Random();
        int direction = randInt.nextInt(4);
        final int UP = 0;
        final int DOWN = 1;
        final int LEFT = 2;
        final int RIGHT = 3;
        Location moveUp = new Location(0, -10);
        Location moveDown = new Location(0, 10);
        Location moveLeft = new Location(-10, 0);
        Location moveRight = new Location(10, 0);
            if (direction == UP) {
                location.add(moveUp);

            }
            if (direction == DOWN) {
                location.add(moveDown);

            }
            if (direction == LEFT) {
                location.add(moveLeft);

            }
            if (direction == RIGHT) {
                location.add(moveRight);

            }
        }

        /**
         * paints the docotrs on the gui green and updates and repaints the dot throughout the sim
         */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.drawOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
        g.setColor(Color.BLACK);
        if (isAlive())
            g.setColor(Color.GREEN);
        else
            g.setColor(Color.ORANGE);
        g.fillOval(location.getX() - RADIUS + 1, location.getY() - RADIUS + 1, RADIUS * 2 - 1, RADIUS * 2 - 1);
        g.setColor(color);
    }
}
