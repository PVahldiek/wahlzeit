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
        if(newCartesianCoordinate == null)
            throw new IllegalArgumentException("Coordinates must not be null");
        coordinate = newCartesianCoordinate;
    }

    /**
     *
     * @methodtype constructor
     */
    public Location(SphericCoordinate newSphericCoordinate) {
        if(newSphericCoordinate == null)
            throw new IllegalArgumentException("Coordinates must not be null");
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
        coordinate = newCoordinate;
    }

}
