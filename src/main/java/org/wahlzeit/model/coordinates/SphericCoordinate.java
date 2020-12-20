package org.wahlzeit.model.coordinates;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate{

    /**
     *
     */
    private double phi;
    private double theta;
    private double radius;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius) throws AssertionError{
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        assertClassInvariants();
    }

    /**
     * Builds a CartesianCoordinate with the current SphericCoordinate
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     */
    @Override
    public CartesianCoordinate doAsCartesianCoordinate() throws IllegalStateException{
        double phi = this.getPhi(), theta = this.getTheta(), radius = this.getRadius();
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        if(radius < 0){
            throw new IllegalStateException("Error in radius convention (Should not be smaller than zero)");
        }
        return new CartesianCoordinate(x, y, z);
    }

    /**
     * Returns current SphericCoordinate
     */
    @Override
    public SphericCoordinate doAsSphericCoordinate() {
        return this;
    }

    /**
     *
     * @methodtype set
     */
    public void setPhi(double newPhi) throws AssertionError {
        assertClassInvariants();
        phi = newPhi;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype get
     */
    public double getPhi() {
        return phi;
    }

    /**
     *
     * @methodtype set
     */
    public void setTheta(double newTheta) throws AssertionError {
        assertClassInvariants();
        theta = newTheta;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype get
     */
    public double getTheta() {
        return theta;
    }

    /**
     *
     * @methodtype set
     */
    public void setRadius(double newRadius) throws AssertionError {
        assertClassInvariants();
        radius = newRadius;
        assertClassInvariants();
    }

    /**
     *
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Class Invariants for SphericCoordinate
     * For conventions see also: https://de.wikipedia.org/wiki/Kugelkoordinaten#%C3%9Cbliche_Konvention
     * - (Math.PI) <= phi <= (Math.PI) or 0 <= phi <= 2 * Math.PI
     * 0 <= theta <= (Math.PI)
     */
    @Override
    protected void assertClassInvariants() throws AssertionError {
        assert phi >= -(Math.PI) && phi <= 2 * Math.PI;
        assert theta >= 0 && theta <= Math.PI;
        assert radius >= 0;
        assert !Double.isNaN(phi) && !Double.isNaN(theta) && !Double.isNaN(radius);
    }
}
