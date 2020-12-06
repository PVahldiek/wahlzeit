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
    public CartesianCoordinate asCartesianCoordinate() {
        if(this instanceof CartesianCoordinate)
            return (CartesianCoordinate) this;
        SphericCoordinate sphericCoordinate = this.asSphericCoordinate();
        double phi = sphericCoordinate.getPhi(), theta = sphericCoordinate.getTheta(), radius = sphericCoordinate.getRadius();
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return new CartesianCoordinate(x, y, z);
    }

    /**
     * calculates CartesianDistance
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        CartesianCoordinate thisCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        return Math.sqrt(Math.pow((thisCoordinate.getX() - cartesianCoordinate.getX()), 2) + Math.pow(thisCoordinate.getY() - cartesianCoordinate.getY(), 2) + Math.pow(thisCoordinate.getZ() - cartesianCoordinate.getZ(), 2));
    }

    /**
     * converts a cartesianCoordinate into a sphericCoordinate
     * if object is already a SphericCoordinate, it returns the instance
     * See also: https://de.wikipedia.org/wiki/Kugelkoordinaten
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        if(this instanceof SphericCoordinate)
            return (SphericCoordinate) this;
        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        double x = cartesianCoordinate.getX(), y = cartesianCoordinate.getY(), z = cartesianCoordinate.getZ();
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
     * Calculates the centralAngle using the great-circle-distance formula
     * See also: https://en.wikipedia.org/wiki/Great-circle_distance
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        SphericCoordinate thisCoordinate = this.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
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
