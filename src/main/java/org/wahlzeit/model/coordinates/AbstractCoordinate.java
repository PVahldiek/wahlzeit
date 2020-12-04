package org.wahlzeit.model.coordinates;


/**
 * Abstract class for minimal redundancy
 */
public abstract class AbstractCoordinate implements Coordinate{

    /**
     * calculates CartesianDistance with getDistance as Helper
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        return Math.sqrt(Math.pow((thisCoordinate.getX() - cartesianCoordinate.getX()), 2) + Math.pow(thisCoordinate.getY() - cartesianCoordinate.getY(), 2) + Math.pow(thisCoordinate.getZ() - cartesianCoordinate.getZ(), 2));
    }

    /**
     * Calculates the centralAngle using the great-circle-distance formula
     * See also: https://en.wikipedia.org/wiki/Great-circle_distance
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate thisCoordinate = this.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        if(Double.compare(thisCoordinate.getRadius(), sphericCoordinate.getRadius()) != 0)
            throw new IllegalStateException("Radius must be equal for calculating distance");

        return thisCoordinate.getRadius() * Math.acos(Math.sin(thisCoordinate.getPhi()) * Math.sin(sphericCoordinate.getPhi()) + Math.cos(thisCoordinate.getPhi()) * Math.cos(sphericCoordinate.getPhi()) * Math.cos(sphericCoordinate.getTheta() - thisCoordinate.getTheta()));
    }

    /**
     * Checks if two coordinates are equal
     * Equal check uses the conversion into two CartesianCoordinates
     * @methodtype boolean
     */
    @Override
    public boolean isEqual(Coordinate coordinate){
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        if(cartesianCoordinate == null)
            throw new NullPointerException("cartesianCoordinate must not be null");
        return (Math.abs(thisCoordinate.getX() - cartesianCoordinate.getX()) < 1E-7) && (Math.abs(thisCoordinate.getY() - cartesianCoordinate.getY()) < 1E-7) && (Math.abs(thisCoordinate.getZ() - cartesianCoordinate.getZ()) < 1E-7);
    }
}
