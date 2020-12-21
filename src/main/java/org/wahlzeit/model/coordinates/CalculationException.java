package org.wahlzeit.model.coordinates;

/**
 * Exception class for distances that doesn't meet contracts
 */
public class CalculationException extends Exception{

    public CalculationException(String message){
        super(message);
    }
}
