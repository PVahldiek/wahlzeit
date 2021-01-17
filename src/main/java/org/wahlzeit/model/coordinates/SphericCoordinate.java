package org.wahlzeit.model.coordinates;

import org.wahlzeit.model.PatternInstance;

@PatternInstance(patternName = "Flyweight", participants = {"CartesianCoordinate", "SphericCoordinate"})
public class SphericCoordinate extends AbstractCoordinate{

    /**
     *
     */
    private final double phi;
    private final double theta;
    private final double radius;

    /**
     * @methodtype constructor
     */
    SphericCoordinate(double phi, double theta, double radius) throws AssertionError{
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        assertClassInvariants();
    }

    public static SphericCoordinate createSphericCoordinate(double phi, double theta, double radius) throws AssertionError{
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        String sphericCoordinateAsString = fetchOrSetSphericCoordinate(sphericCoordinate);
        return CoordinateUtil.deSerializeSphericCoordinate(sphericCoordinateAsString);
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
        return CartesianCoordinate.createCartesianCoordinate(x, y, z);
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
    public SphericCoordinate setPhi(double newPhi) throws AssertionError {
        assertClassInvariants();
        SphericCoordinate sphericCoordinate = new SphericCoordinate(newPhi, theta, radius);
        String sphericCoordinateAsString = fetchOrSetSphericCoordinate(sphericCoordinate);
        assertClassInvariants();
        return CoordinateUtil.deSerializeSphericCoordinate(sphericCoordinateAsString);
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
    public SphericCoordinate setTheta(double newTheta) throws AssertionError {
        assertClassInvariants();
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, newTheta, radius);
        String sphericCoordinateAsString = fetchOrSetSphericCoordinate(sphericCoordinate);
        assertClassInvariants();
        return CoordinateUtil.deSerializeSphericCoordinate(sphericCoordinateAsString);
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
    public SphericCoordinate setRadius(double newRadius) throws AssertionError {
        assertClassInvariants();
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, newRadius);
        String sphericCoordinateAsString = fetchOrSetSphericCoordinate(sphericCoordinate);
        assertClassInvariants();
        return CoordinateUtil.deSerializeSphericCoordinate(sphericCoordinateAsString);
    }

    /**
     *
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Helper method doing all stuff needed to serialize and look for shared objects etc...
     * Needed in initializer
     */
    private static String fetchOrSetSphericCoordinate(SphericCoordinate sphericCoordinate){
        String sphericCoordinateAsString = CoordinateUtil.serializeSphericCoordinate(sphericCoordinate);
        return CoordinateUtil.getString(sphericCoordinateAsString, sphericCoordinates, sphericCoordinate.hashCode());
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
