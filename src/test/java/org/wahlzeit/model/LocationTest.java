package org.wahlzeit.model;

import org.junit.Test;
import org.wahlzeit.model.coordinates.SphericCoordinate;

public class LocationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowException() {
        SphericCoordinate c = null;
        Location location = new Location(c);
    }
}