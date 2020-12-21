package org.wahlzeit.model.coordinates;


import java.util.Objects;

/**
 * Abstract class for minimal redundancy
 */
public abstract class AbstractCoordinate implements Coordinate{

    /**
     * Builds a CartesianCoordinate with the current SphericCoordinate
     * if object is already a CartesianCoordinate, it returns the instance
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     * @return cartesian representation of the coordinate
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() throws AssertionError, IllegalStateException{
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
     * Calculates CartesianDistance between two CartesianCoordinates
     * @param coordinate Coordinate to which the distance should be calculated
     * @return distance
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException, ArithmeticException, CalculationException {
        assertIsNonNullArgument(coordinate);
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        double result = Math.sqrt(Math.pow((thisCoordinate.getX() - cartesianCoordinate.getX()), 2) + Math.pow(thisCoordinate.getY() - cartesianCoordinate.getY(), 2) + Math.pow(thisCoordinate.getZ() - cartesianCoordinate.getZ(), 2));
        assertIsNonNaN(result);
        assertIsPositive(result);
        return result;
    }

    /**
     * converts a cartesianCoordinate into a sphericCoordinate
     * if object is already a SphericCoordinate, it returns the instance
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     * @return spheric representation of the coordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() throws AssertionError, IllegalStateException{
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
     * @param coordinate Coordinate to which the CentralAngle should be calculated
     * @return central angle
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) throws IllegalArgumentException, ArithmeticException, IllegalStateException, CalculationException {
        assertIsNonNullArgument(coordinate);
        SphericCoordinate thisCoordinate = this.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        if(Double.compare(thisCoordinate.getRadius(), sphericCoordinate.getRadius()) != 0)
            throw new IllegalStateException("Radius must be equal for calculating distance");

        double result = thisCoordinate.getRadius() * Math.acos(Math.sin(thisCoordinate.getPhi()) * Math.sin(sphericCoordinate.getPhi()) + Math.cos(thisCoordinate.getPhi()) * Math.cos(sphericCoordinate.getPhi()) * Math.cos(sphericCoordinate.getTheta() - thisCoordinate.getTheta()));
        assertIsNonNaN(result);
        assertIsPositive(result);
        return result;
    }

    /**
     * Checks if two coordinates are equal
     * Equal check uses the conversion into two CartesianCoordinates
     * @methodtype boolean
     * @param coordinate Coordinate which should be compared
     * @return true if the two coordinates are equal, false otherwise
     */
    @Override
    public boolean isEqual(Coordinate coordinate) throws IllegalArgumentException{
        assertIsNonNullArgument(coordinate);
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return (Math.abs(thisCoordinate.getX() - cartesianCoordinate.getX()) < 1E-7) && (Math.abs(thisCoordinate.getY() - cartesianCoordinate.getY()) < 1E-7) && (Math.abs(thisCoordinate.getZ() - cartesianCoordinate.getZ()) < 1E-7);
    }

    /**
     * Autogenerated equals, forwarded to isEqual
     * @methodtype boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return isEqual(that);
    }

    /**
     * Autogenerated equals, forwarded to isEqual
     * @methodtype boolean
     */
    @Override
    public int hashCode() {
        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        return Objects.hash(cartesianCoordinate.getX(), cartesianCoordinate.getY(), cartesianCoordinate.getZ());
    }

    /**
     * Generic pre condition
     * @param object which is tested for null
     */
    protected void assertIsNonNullArgument(Object object) throws IllegalArgumentException{
        if(object == null)
            throw new IllegalArgumentException("Object must be not null");
    }

    /**
     * Generic post condition
     * @param number which is tested for NaN
     */
    protected void assertIsNonNaN(double number) throws IllegalArgumentException{
        if(Double.isNaN(number))
            throw new IllegalArgumentException("Double must not be NaN");
    }

    protected void assertIsPositive(double distance) throws CalculationException{
        if(distance < 0){
            throw new CalculationException("Error in distance calculation, distance can't be less zero");
        }
    }

    /**
     * Class Invariants for subclasses
     */
    protected abstract void assertClassInvariants();
}
