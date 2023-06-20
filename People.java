/*
 * CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Your name(s): Robert Cruz
 */

import java.awt.*;
import java.util.Random;


public abstract class People {
/**
 * insatntiates a location and destination also sets radius to 4 and MAXlIFESPAN to 100
 */
    protected Location location;
    protected Location destination;


    protected static final int MAX_LIFESPAN = 100;
    protected static final int RADIUS       = 4;


    /**
     * constructor that sets location and destination to location and destination
     */
    People(Location location, Location destination) {
        this.location = location;
        this.destination = destination;

    }

    People(Location location)
    {
        this(location, new Location());
    }


    /**
     * isAlive() returns true if person is Alive
     */
    boolean isAlive() {
        return true;
    }
    /**
     * getDestination() returns the destination x,y
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * getLocation returns the x,y of current location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * updates the particles
     */
    public abstract void update();


    // Note: do not change this method as it will be used to draw your particles on the screen
    public abstract void paint(Graphics g);
}
