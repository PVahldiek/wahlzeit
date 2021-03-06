package org.wahlzeit.model.coordinates;

import java.util.HashMap;

public class CoordinateUtil {


    /**
     * Helper method to return String from SphericCoordinate
     */
    public static String serializeSphericCoordinate(SphericCoordinate sphericCoordinate){
        return sphericCoordinate.getPhi() + "/" + sphericCoordinate.getTheta() + "/" + sphericCoordinate.getRadius();
    }

    /**
     * Helper method to return SphericCoordinate from String
     */
    public static SphericCoordinate deSerializeSphericCoordinate(String sphericCoordinate){
        return new SphericCoordinate(Double.parseDouble(sphericCoordinate.split("/")[0]), Double.parseDouble(sphericCoordinate.split("/")[1]), Double.parseDouble(sphericCoordinate.split("/")[2]));
    }

    /**
     * Helper method to return String from SphericCoordinate
     */
    public static String serializeCartesianCoordinate(CartesianCoordinate cartesianCoordinate){
        return cartesianCoordinate.getX() + "/" + cartesianCoordinate.getY() + "/" + cartesianCoordinate.getZ();
    }

    /**
     * Helper method to return SphericCoordinate from String
     */
    public static CartesianCoordinate deSerializeCartesianCoordinate(String cartesianCoordinate){
        return new CartesianCoordinate(Double.parseDouble(cartesianCoordinate.split("/")[0]), Double.parseDouble(cartesianCoordinate.split("/")[1]), Double.parseDouble(cartesianCoordinate.split("/")[2]));
    }

    /**
     * Helper method to return String from HashMap
     * To minimize Code duplicates
     */
    public static String getString(String coordinateAsString, HashMap<Integer, String> coordinatesMap, int hash) {
        String result = coordinatesMap.get(hash);
        if(result == null) {
            synchronized (coordinatesMap) {
                result = coordinatesMap.get(hash);
                if (result == null) {
                    result = coordinateAsString;
                    coordinatesMap.put(hash, coordinateAsString);
                }
            }
        }
        return result;
    }
}
