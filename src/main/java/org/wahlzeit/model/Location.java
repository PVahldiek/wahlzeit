package org.wahlzeit.model;

public class Location {

    /**
     *
     */
    protected Coordinate coordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(Coordinate newCoordinate) {
        coordinate = newCoordinate;
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
