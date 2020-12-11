package org.wahlzeit.model.coordinates;


/**
 * Abstract class for minimal redundancy
 */
public abstract class AbstractCoordinate implements Coordinate{

    /**
     * Builds a CartesianCoordinate with the current SphericCoordinate
     * if object is already a CartesianCoordinate, it returns the instance
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate(){
        assertClassInvariants();
        CartesianCoordinate cartesianCoordinate = doAsCartesianCoordinate();
        assertClassInvariants();
        return cartesianCoordinate;
    }

    /**
     * Helper method which is implemented in subclass for maximal redundancy
     */
    protected abstract CartesianCoordinate doAsCartesianCoordinate();

    /**
     * calculates CartesianDistance
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        assertIsNonNullArgument(coordinate);
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        double result = Math.sqrt(Math.pow((thisCoordinate.getX() - cartesianCoordinate.getX()), 2) + Math.pow(thisCoordinate.getY() - cartesianCoordinate.getY(), 2) + Math.pow(thisCoordinate.getZ() - cartesianCoordinate.getZ(), 2));
        assertIsNonNaN(result);
        return result;
    }

    /**
     * converts a cartesianCoordinate into a sphericCoordinate
     * if object is already a SphericCoordinate, it returns the instance
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     */
    @Override
    public SphericCoordinate asSphericCoordinate(){
        assertClassInvariants();
        SphericCoordinate sphericCoordinate = doAsSphericCoordinate();
        assertClassInvariants();
        return sphericCoordinate;
    }

    /**
     * Helper method which is implemented in subclass for maximal redundancy
     */
    protected abstract SphericCoordinate doAsSphericCoordinate();

    /**
     * Calculates the centralAngle using the great-circle-distance formula
     * See also: https://en.wikipedia.org/wiki/Great-circle_distance
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        assertIsNonNullArgument(coordinate);
        SphericCoordinate thisCoordinate = this.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        if(Double.compare(thisCoordinate.getRadius(), sphericCoordinate.getRadius()) != 0)
            throw new IllegalStateException("Radius must be equal for calculating distance");

        double result = thisCoordinate.getRadius() * Math.acos(Math.sin(thisCoordinate.getPhi()) * Math.sin(sphericCoordinate.getPhi()) + Math.cos(thisCoordinate.getPhi()) * Math.cos(sphericCoordinate.getPhi()) * Math.cos(sphericCoordinate.getTheta() - thisCoordinate.getTheta()));
        assertIsNonNaN(result);
        return result;
    }

    /**
     * Checks if two coordinates are equal
     * Equal check uses the conversion into two CartesianCoordinates
     * @methodtype boolean
     */
    @Override
    public boolean isEqual(Coordinate coordinate){
        assertIsNonNullArgument(coordinate);
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return (Math.abs(thisCoordinate.getX() - cartesianCoordinate.getX()) < 1E-7) && (Math.abs(thisCoordinate.getY() - cartesianCoordinate.getY()) < 1E-7) && (Math.abs(thisCoordinate.getZ() - cartesianCoordinate.getZ()) < 1E-7);
    }

    /**
     * Generic pre condition
     * @param object
     */
    protected void assertIsNonNullArgument(Object object){
        if(object == null)
            throw new IllegalArgumentException("Object must be not null");
    }

    /**
     * Generic post condition
     * @param number
     */
    protected void assertIsNonNaN(double number){
        if(Double.isNaN(number))
            throw new IllegalArgumentException("Double must not be NaN");
    }

    /**
     * Class Invariants for subclasses
     */
    protected abstract void assertClassInvariants();
}
