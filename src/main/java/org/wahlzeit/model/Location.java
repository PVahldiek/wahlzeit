package org.wahlzeit.model;

import org.wahlzeit.model.coordinates.CartesianCoordinate;

public class Location {

    /**
     *
     */
    protected CartesianCoordinate cartesianCoordinate;

    /**
     *
     * @methodtype constructor
     */
    public Location(CartesianCoordinate newCartesianCoordinate) {
        if(newCartesianCoordinate == null)
            throw new IllegalArgumentException("Coordinates must not be null");
        cartesianCoordinate = newCartesianCoordinate;
    }

    /**
     *
     * @methodtype get
     */
    public CartesianCoordinate getCartesianCoordinate() {
        return cartesianCoordinate;
    }

    /**
     *
     * @methodtype set
     */
    public void setCartesianCoordinate(CartesianCoordinate newCartesianCoordinate) {
        cartesianCoordinate = newCartesianCoordinate;
    }

}
