package org.wahlzeit.model.coordinates.exc;

/**
 * Exception class for distances that doesn't meet contracts
 */
public class CalculationException extends Exception{

    public CalculationException(String message){
        super(message);
    }
}
