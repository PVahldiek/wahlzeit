package org.wahlzeit.model.coordinates;

import org.wahlzeit.model.PatternInstance;

@PatternInstance(patternName = "Flyweight", participants = {"CartesianCoordinate", "SphericCoordinate"})
public class CartesianCoordinate extends AbstractCoordinate{

    /**
     *
     */
    private final double x;
    private final double y;
    private final double z;

    /**
     *
     * @methodtype constructor
     */
    CartesianCoordinate(double newX, double newY, double newZ) throws AssertionError {
        x = newX;
        y = newY;
        z = newZ;
        assertClassInvariants();
    }

    public static CartesianCoordinate createCartesianCoordinate(double x, double y, double z) throws AssertionError{
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, z);
        String cartesianCoordinateAsString = fetchOrSetCartesianCoordinate(cartesianCoordinate);
        return CoordinateUtil.deSerializeCartesianCoordinate(cartesianCoordinateAsString);
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
        return SphericCoordinate.createSphericCoordinate(phi, theta, radius);
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
    public CartesianCoordinate setX(double newX) throws AssertionError{
        assertClassInvariants();
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(newX, y, z);
        String cartesianCoordinateAsString = fetchOrSetCartesianCoordinate(cartesianCoordinate);
        assertClassInvariants();
        return CoordinateUtil.deSerializeCartesianCoordinate(cartesianCoordinateAsString);
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
    public CartesianCoordinate setY(double newY) throws AssertionError{
        assertClassInvariants();
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, newY, z);
        String cartesianCoordinateAsString = fetchOrSetCartesianCoordinate(cartesianCoordinate);
        assertClassInvariants();
        return CoordinateUtil.deSerializeCartesianCoordinate(cartesianCoordinateAsString);
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
    public CartesianCoordinate setZ(double newZ) throws AssertionError {
        assertClassInvariants();
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(x, y, newZ);
        String cartesianCoordinateAsString = fetchOrSetCartesianCoordinate(cartesianCoordinate);
        assertClassInvariants();
        return CoordinateUtil.deSerializeCartesianCoordinate(cartesianCoordinateAsString);
    }

    /**
     * Helper method doing all stuff needed to serialize and look for shared objects etc...
     * Needed in setters and initializer
     */
    private static String fetchOrSetCartesianCoordinate(CartesianCoordinate cartesianCoordinate){
        String cartesianCoordinateAsString = CoordinateUtil.serializeCartesianCoordinate(cartesianCoordinate);
        return CoordinateUtil.getString(cartesianCoordinateAsString, cartesianCoordinates, cartesianCoordinate.hashCode());
    }

    /**
     * Class Invariants for CartesianCoordinate (not NaN)
     */
    @Override
    protected void assertClassInvariants() {
        assert !Double.isNaN(x) && !Double.isNaN(y) && !Double.isNaN(z);
    }
}
