package org.wahlzeit.model.coordinates;

import junit.framework.TestCase;
import org.junit.Assert;

public class SphericCoordinateTest extends TestCase {

    public void testAsCartesianCoordinate() {
        SphericCoordinate p1 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 1);
        CartesianCoordinate c1 = p1.asCartesianCoordinate();
        // Happens due to double precision
        Assert.assertTrue(c1.getX() < 1E-10);
        Assert.assertTrue(c1.getY() == 1);
        Assert.assertTrue(c1.getZ() < 1E-10);
    }

    public void testGetCartesianDistance() {
    }

    public void testAsSphericCoordinate() {
    }

    public void testGetCentralAngle() {
    }

    public void testIsEqual() {
    }
}