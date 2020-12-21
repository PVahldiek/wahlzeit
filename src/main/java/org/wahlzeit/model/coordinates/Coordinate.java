package org.wahlzeit.model.coordinates;

import org.wahlzeit.model.coordinates.exc.CalculationException;

/**
 * An interface for different coordinate types
 */
public interface Coordinate {

    CartesianCoordinate asCartesianCoordinate();

    double getCartesianDistance(Coordinate coordinate) throws CalculationException;

    SphericCoordinate asSphericCoordinate();

    double getCentralAngle(Coordinate coordinate) throws CalculationException;

    boolean isEqual(Coordinate coordinate);
}
