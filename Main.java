/* CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Your name(s): Robert Cruz
 */
public class Main {

    /**
     * main() instantiates a new PeopleSim with a finite number for population and runs it
     */
    public static void main(String[] args) {
        PeopleSim sim = new PeopleSim(150);
        sim.createPeople();
        sim.run();

    }

}
