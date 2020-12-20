package org.wahlzeit.model;

import org.wahlzeit.model.coordinates.CartesianCoordinate;
import org.wahlzeit.model.coordinates.Coordinate;
import org.wahlzeit.model.coordinates.SphericCoordinate;

public class Location {

    /**
     *
     */
    protected Coordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(CartesianCoordinate newCartesianCoordinate) {
        assertIsNonNullArgument(newCartesianCoordinate);
        coordinate = newCartesianCoordinate;
    }

    /**
     *
     * @methodtype constructor
     */
    public Location(SphericCoordinate newSphericCoordinate) {
        assertIsNonNullArgument(newSphericCoordinate);
        coordinate = newSphericCoordinate;
    }

    /**
     *
     * @methodtype get
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setCoordinate(Coordinate newCoordinate) {
        assertIsNonNullArgument(newCoordinate);
        coordinate = newCoordinate;
    }

    /**
     * Generic pre condition
     * @param object which is tested for null
     */
    protected void assertIsNonNullArgument(Object object){
        if(object == null)
            throw new IllegalArgumentException("Object " + object.toString() + " must be not null");
    }
}
