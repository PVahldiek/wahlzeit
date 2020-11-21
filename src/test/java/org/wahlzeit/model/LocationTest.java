package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LocationTest extends TestCase {

    public void testShouldThrowException() {
        try {
            Location location = new Location(null);
            fail();
        }
        catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }
}