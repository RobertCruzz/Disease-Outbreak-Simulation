/*
 * CSCI121 - Computer Science II - Spring 2020
 * Instructors: Greg Schaper, Thyago Mota & Jeffrey Bush
 * Description: Lab 04 - Vector
 * Your name(s): Robert Cruz
 */

class Location {

    private int x;
    private int y;

    Location() {
        x = y = 0;
    }

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void add(Location other) {
        this.x += other.x;
        this.y += other.y;
    }

    public static double distance(Location v1, Location v2)
    {

        double result;
        result = Math.pow((v1.getX() - v2.getX()), 2) + Math.pow((v1.getY() - v2.getY()), 2);
        result = Math.pow(result, 0.5);
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        Location other = (Location) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
