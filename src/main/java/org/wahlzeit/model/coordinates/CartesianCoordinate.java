package org.wahlzeit.model.coordinates;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate{

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
    public CartesianCoordinate(double newX, double newY, double newZ) throws AssertionError {
        x = newX;
        y = newY;
        z = newZ;
        assertClassInvariants();
    }

    /**
     * Returns current CartesianCoordinate
     */
    @Override
    public CartesianCoordinate doAsCartesianCoordinate() {
        return this;
    }

    /**
     * converts a cartesianCoordinate into a sphericCoordinate
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     */
    @Override
    public SphericCoordinate doAsSphericCoordinate() throws IllegalStateException, ArithmeticException{
        double x = this.getX(), y = this.getY(), z = this.getZ();
        double phi = 0, theta = 0, radius = 0;
        radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        // Check if radius == 0
        if(radius == 0)
            throw new IllegalStateException("Radius equals zero, can't continue conversion");
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
    public void setX(double newX) throws AssertionError{
        assertClassInvariants();
        x = newX;
        assertClassInvariants();
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
    public void setY(double newY) throws AssertionError{
        assertClassInvariants();
        y = newY;
        assertClassInvariants();
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
    public void setZ(double newZ) throws AssertionError {
        assertClassInvariants();
        z = newZ;
        assertClassInvariants();
    }

    /**
     * Class Invariants for CartesianCoordinate (not NaN)
     */
    @Override
    protected void assertClassInvariants() {
        assert !Double.isNaN(x) && !Double.isNaN(y) && !Double.isNaN(z);
    }
}
