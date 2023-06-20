/*
 * CSCI121 - Computer Science II - Spring 2019
 * Instructors: Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - World
 * Your name(s): Robert Cruz
 */

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;

public class World extends JPanel {

    private int xMin, xMax, yMin, yMax;
    private List<People> population;

    /**
     * gets the mins and maxes for the world and creates population as a new Arraylist
     */
    World(int xMin, int yMin, int xMax, int yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        population = new CopyOnWriteArrayList<>();
    }

    /**
     * add People to the world population
     */
    void add(People person) {
        population.add(person);

    }

    /**
     *  returns true if population.size() is greater than 0
     */
    public boolean hasPeople() {
        if (population.size() > 0) {
            return true;
        }

        return false;
    }

    /**
     *return true if the world population contains active unDead People
     */
    boolean hasUndeadPeople() {
        for (People person : population) {
            if (population.contains(person instanceof Undead)) {
                return true;
            }
        }
        return false;
    }

    /**
     *    First cycle through the world population comparing the distance between Alive People
     *      and UnDead. If Alive person is 16 units from an UnDead person, the the Alive Person comes an
     *      UnDead Person.
     *      if doc comes within 5 units of undead, The Undead person comes an alive person
     *     Then call update for each Alive and UnDead Person to move them to a new location
     *     if a doctor gets within 20 units of an undeadperson the UndeadPerson because a new person of type Immune which is indicated by a orange dot
     */
    void update() {
        People alivePerson, undeadPerson, doc;
        for (int i = 0; i < population.size(); ++i) {
            alivePerson = population.get(i);
            if (alivePerson instanceof Alive) {
                for (int a = 0; a < population.size(); ++a) {
                    undeadPerson = population.get(a);
                    if (undeadPerson instanceof Undead) {
                        if (((Undead) undeadPerson).isUnDead()) {
                            double distance;
                            distance = Location.distance(alivePerson.getLocation(), undeadPerson.getLocation());
                            if (distance <= 16) {
                                population.set(i, new Undead(alivePerson.getLocation()));
                                a = population.size();
                            }
                        }
                    }
                }
            }
        }
            for(int g = 0; g < population.size(); ++g) {
                doc = population.get(g);
                if (doc instanceof Doctor) {
                    for (int q = 0; q < population.size(); ++q) {
                        undeadPerson = population.get(q);
                        if (undeadPerson instanceof Undead) {
                            if (((Undead) undeadPerson).isUnDead()) {
                                double distance = Location.distance(doc.getLocation(), undeadPerson.getLocation());
                                if (distance <= 20) {
                                    Random rand = new Random();
                                    Location newLoc = new Location(rand.nextInt(700), rand.nextInt(700));
                                    population.set(q, new Immune(undeadPerson.getLocation(), newLoc));
                                    q = population.size();
                                }
                            }
                        }
                    }

                }
            }
        for (People person : population)
        {

            person.update();

        }
    }




    /**
     * cleans the dot of the gui if person is not alive
     */
    void clean() {
        for (Iterator<People> iterator = population.iterator(); iterator.hasNext(); ) {
            People person = iterator.next();
            if (!person.isAlive())
                population.remove(person);
        }
    }

    /**
     * paints the people and updates the dots on the gui
     */
    @Override
    public void paint(Graphics g) {
        for (Iterator<People> iterator = population.iterator(); iterator.hasNext(); ) {
            People person = iterator.next();
            person.paint(g);
        }
    }
}
