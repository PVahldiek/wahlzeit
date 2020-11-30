package org.wahlzeit.model.coordinates;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate{

    /**
     *
     */
    private double x;
    private double y;
    private double z;

    /**
     *
     * @methodtype constructor
     */
    public CartesianCoordinate(double newX, double newY, double newZ) {
        x = newX;
        y = newY;
        z = newZ;
    }

    /**
     * Returns cartesian distance formula
     * @methodtype get
     */
    public double getDistance(CartesianCoordinate cartesianCoordinate) {
        return Math.sqrt(Math.pow((x - cartesianCoordinate.getX()), 2) + Math.pow(y - cartesianCoordinate.getY(), 2) + Math.pow(z - cartesianCoordinate.getZ(), 2));
    }

    /**
     * Checks if two coordinates are equal
     * @methodtype boolean
     */
    public boolean isEqual(CartesianCoordinate cartesianCoordinate) {
        return Double.compare(x, cartesianCoordinate.getX()) == 0 && Double.compare(y, cartesianCoordinate.getY()) == 0 && Double.compare(z, cartesianCoordinate.getZ()) == 0;
    }

    /**
     * Forward equals to isEqual
     * @methodtype boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianCoordinate that = (CartesianCoordinate) o;
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

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return getDistance(coordinate.asCartesianCoordinate());
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double phi = 0, theta = 0, radius = 0;
        // Changed to formula from https://de.wikipedia.org/wiki/Kugelkoordinaten
        radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        theta = Math.acos(z/radius);
        if(x > 0){
            phi = Math.atan(y/x);
        } else if(x == 0){
            phi = Math.signum(y) * Math.PI / 2;
        } else if(x < 0 && y >= 0){
            phi = Math.atan(y/x) + Math.PI;
        } else if(x < 0 && y < 0){
            phi = Math.atan(y/x) - Math.PI;
        }
        return new SphericCoordinate(phi, theta, radius);
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate.asSphericCoordinate());
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        return isEqual(coordinate.asCartesianCoordinate());
    }
}
