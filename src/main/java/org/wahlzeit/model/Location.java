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
    public Location(CartesianCoordinate newCartesianCoordinate) throws IllegalArgumentException{
        assertIsNonNullArgument(newCartesianCoordinate);
        coordinate = newCartesianCoordinate;
    }

    /**
     *
     * @methodtype constructor
     */
    public Location(SphericCoordinate newSphericCoordinate) throws IllegalArgumentException{
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
    public void setCoordinate(Coordinate newCoordinate) throws IllegalArgumentException{
        assertIsNonNullArgument(newCoordinate);
        coordinate = newCoordinate;
    }

    /**
     * Generic pre condition
     * @param object which is tested for null
     */
    protected void assertIsNonNullArgument(Object object){
        if(object == null)
            throw new IllegalArgumentException("Object must be not null");
    }
}
