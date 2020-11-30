package org.wahlzeit.model;

import junit.framework.TestCase;
import org.wahlzeit.model.coordinates.SphericCoordinate;

public class LocationTest extends TestCase {

    public void testShouldThrowException() {
        try {
            SphericCoordinate c = null;
            Location location = new Location(c);
            fail();
        }
        catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
}