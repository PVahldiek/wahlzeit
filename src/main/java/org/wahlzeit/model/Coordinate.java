package org.wahlzeit.model;

public class Coordinate {

    /**
     *
     */
    protected double x;
    protected double y;
    protected double z;

    /**
     *
     */
    protected Location location;

    /**
     *
     */
    public Coordinate(double newX, double newY, double newZ) {
        x = newX;
        y = newY;
        z = newZ;
    }

    /**
     * Returns cartesian distance formula
     * @methodtype get
     */
    public double getDistance(Coordinate coordinate) {
        return Math.sqrt(Math.pow((x - coordinate.getX()), 2) + Math.pow(y - coordinate.getY(), 2) + Math.pow(z - coordinate.getZ(), 2));
    }

    /**
     * Checks if two coordinates are equal
     * @methodtype boolean
     */
    public boolean isEqual(Coordinate coordinate) {
        return (x == coordinate.getX() && y == coordinate.getY() && z == coordinate.getZ()) ? true : false;
    }

    /**
     *
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @methodtype set
     */
    public void setX(double newX) {
        x = newX;
    }

    /**
     *
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @methodtype set
     */
    public void setY(double newY) {
        y = newY;
    }

    /**
     *
     * @methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     *
     * @methodtype set
     */
    public void setZ(double newZ) {
        z = newZ;
    }

    /**
     *
     * @methodtype get
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @methodtype set
     */
    public void setLocation(Location newLocation) {
        location = newLocation;
    }

}
