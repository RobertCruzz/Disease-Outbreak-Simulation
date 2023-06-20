/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - ParticlesSim
 * Your name(s): Robert Cruz
 */

import javax.swing.*;
import java.util.Random;

public class PeopleSim extends JFrame {

    /**
     * creates all the instance variables
     */
    private static final int    WIDTH                   = 700;
    private static final int    HEIGHT                  = 700;
    private static final int    TITLE_HEIGHT            = 15;
    private static final String TITLE                   = "Zombies";
    private static final int    NUMBER_PEOPLE           = 100;
    private static final int    SLEEP_TIME_PER_PERSON = 1; // ms
    private static Random rnd = new Random();
    int docSize = 2;

    private World world;
    private int   numberOfPeople;

    /**
     * PeopleSim() sets the numberOfPeople and also sets title, width, world size, and makes sure its visible
     */
    PeopleSim(int numberOfPeople) {
        if (numberOfPeople > 0)
            this.numberOfPeople = numberOfPeople;
        else
            this.numberOfPeople = NUMBER_PEOPLE;
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT + TITLE_HEIGHT);
        world = new World(0, 0, WIDTH - 1, HEIGHT - 1);
        setContentPane(world);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * returns random int between the min and max
     */
    static int randomInt(int min, int max) {
        return rnd.nextInt(max - min + 1) + min;
    }

    /**
     * createPeople() method creates a new person with a random location and destination within the world for the number of population
     * it also creates one undead person in the center of the world
     * it also creates two doctors in the world which will go and vaccinate the Undead
     */
    void createPeople() {
        for (int i = 0; i < numberOfPeople; ++i) {
            Location livingLocation = new Location(randomInt(0, 700), randomInt(0, 700));
            Location destinationAlive = new Location(randomInt(0, 700), randomInt(0, 700));
            Alive people = new Alive(livingLocation, destinationAlive);
            world.add(people);

        }
        Location undeadLocation = new Location(WIDTH / 2, HEIGHT / 2);
        Undead person = new Undead(undeadLocation);
        world.add(person);

        Location docLocation1 = new Location(randomInt(0, 700), randomInt(0, 700));
        Doctor doc1 = new Doctor(docLocation1);
        world.add(doc1);

        Location docLocation2 = new Location(randomInt(0, 700), randomInt(0, 700));
        Doctor doc2 = new Doctor(docLocation2);
        world.add(doc2);

        Location docLocation3 = new Location(randomInt(0, 700), randomInt(0, 700));
        Doctor doc3 = new Doctor(docLocation3);
        world.add(doc3);

        
        }


    /**
     * run() will update and repaint world as long as there are active people within it
     */
    void run() {
        int i = 0;
        while (world.hasPeople()) {
            world.update();
            world.repaint();
            try {
                Thread.sleep(numberOfPeople * SLEEP_TIME_PER_PERSON);
            }
            catch (InterruptedException ex) {

            }
        }
        JOptionPane.showMessageDialog(null, "No more people alive; simulation ends now!");
        System.exit(0);
    }


}
