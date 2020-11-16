package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

    /**
     *
     */
    private double x;
    private double y;
    private double z;

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
     * Forward equals to isEqual
     * @methodtype boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return isEqual(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
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

}
