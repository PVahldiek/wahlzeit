package org.wahlzeit.model.coordinates;

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
