/*
 * CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Your name(s): Robert Cruz
 */
import java.awt.*;
import java.util.Random;

public class Alive extends People {
    Random rand = new Random();

    /**
     * constructor for alive people that gets the location and destination
     */
    Alive(Location location, Location destination) {
        super(location, destination);
        //this.location = location;
        //this.destination = destination;


    }


    /**
     * Update method compares the current x,y location to the x,y destination and moves one step closer to dest each iteration
     */
    @Override
    public void update() {
        Location moveUp = new Location(0,-1);
        Location moveDown = new Location(0,1);
        Location moveLeft = new Location(-1,0);
        Location moveRight= new Location(1,0);
        if (location.getX() > destination.getX()) {
            location.add(moveLeft);
        }
        if(location.getX() < destination.getX()) {
            location.add(moveRight);
        }
        if (location.getY() > destination.getY()) {
            location.add(moveUp);
        }
        if (location.getY() < destination.getY()) {
            location.add(moveDown);
        }
        // Question - when destination is reached they do not continue to new destination they just stop and idk why
        if (location.getX() == destination.getX() && location.getY() == destination.getY()) {
            destination = new Location(rand.nextInt(700), rand.nextInt(700));
            }
        }

        /**
         * the paint() method sets the color for the alive person and paints the  alive dot on the gui
         */
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.drawOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);
        g.setColor(Color.BLACK);
        if (isAlive())
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.GREEN);
        g.fillOval(location.getX() - RADIUS + 1, location.getY() - RADIUS + 1, RADIUS * 2 - 1, RADIUS * 2 - 1);
        g.setColor(color);
    }



}
