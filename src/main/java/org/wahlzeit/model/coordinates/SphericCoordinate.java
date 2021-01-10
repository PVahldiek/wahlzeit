package org.wahlzeit.model.coordinates;

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

    public static SphericCoordinate createSphericCoordinate(double phi, double theta, double radius) throws AssertionError{
        SphericCoordinate sphericCoordinate = new SphericCoordinate(phi, theta, radius);
        String sphericCoordinateAsString = fetchOrSetSphericCoordinate(sphericCoordinate);
        return deSerializeSphericCoordinate(sphericCoordinateAsString);
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
    public SphericCoordinate setPhi(double newPhi) throws AssertionError {
        assertClassInvariants();
        SphericCoordinate sphericCoordinate = new SphericCoordinate(newPhi, theta, radius);
        String sphericCoordinateAsString = fetchOrSetSphericCoordinate(sphericCoordinate);
        assertClassInvariants();
        return deSerializeSphericCoordinate(sphericCoordinateAsString);
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
        return deSerializeSphericCoordinate(sphericCoordinateAsString);
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
        return deSerializeSphericCoordinate(sphericCoordinateAsString);
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
     * Needed in setters and initializer
     */
    private static String fetchOrSetSphericCoordinate(SphericCoordinate sphericCoordinate){
        String sphericCoordinateAsString = serializeSphericCoordinate(sphericCoordinate);
        String result = sphericCoordinates.get(sphericCoordinate.hashCode());
        if(result == null) {
            synchronized (sphericCoordinates) {
                result = sphericCoordinates.get(sphericCoordinate.hashCode());
                if (result == null) {
                    result = sphericCoordinateAsString;
                    sphericCoordinates.put(sphericCoordinate.hashCode(), sphericCoordinateAsString);
                }
            }
        }
        return result;
    }

    /**
     * Helper method to return String from SphericCoordinate
     */
    private static String serializeSphericCoordinate(SphericCoordinate sphericCoordinate){
        return sphericCoordinate.getPhi() + "/" + sphericCoordinate.getTheta() + "/" + sphericCoordinate.getRadius();
    }

    /**
     * Helper method to return SphericCoordinate from String
     */
    private static SphericCoordinate deSerializeSphericCoordinate(String sphericCoordinate){
        return createSphericCoordinate(Double.parseDouble(sphericCoordinate.split("/")[0]), Double.parseDouble(sphericCoordinate.split("/")[1]), Double.parseDouble(sphericCoordinate.split("/")[2]));
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
