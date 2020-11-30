package org.wahlzeit.model.coordinates;

import junit.framework.TestCase;
import org.junit.Assert;

public class CartesianCoordinateTest extends TestCase {

    public void testGetDistance() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertTrue(c1.getDistance(c2) == 1);

        CartesianCoordinate c3 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c4 = new CartesianCoordinate(3, 7, 9);
        Assert.assertTrue(c3.getDistance(c4) == 1);

        CartesianCoordinate c5 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c6 = new CartesianCoordinate(4, 6, 9);
        Assert.assertTrue(c5.getDistance(c6) == 1);
    }

    public void testIsEqual() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 9);
        Assert.assertTrue(c1.isEqual(c2));
        Assert.assertTrue(c2.isEqual(c1));
    }

    public void testIsNotEqual() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertFalse(c1.isEqual(c2));
        Assert.assertFalse(c2.isEqual(c1));
    }

    public void testTestEquals() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 9);
        Assert.assertTrue(c1.equals(c2));
        Assert.assertTrue(c2.equals(c1));
    }

    public void testTestNotEquals() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertFalse(c1.equals(c2));
        Assert.assertFalse(c2.equals(c1));
    }

    public void testHashCodeEquals(){
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 9);
        Assert.assertTrue(c1.hashCode() == c2.hashCode());
    }

    public void testHashCodeNotEquals(){
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertFalse(c1.hashCode() == c2.hashCode());
    }

    public void testAsSphericCoordinate(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        SphericCoordinate p1 = c1.asSphericCoordinate();
        Assert.assertTrue(p1.getRadius() == 1);
        Assert.assertTrue(p1.getTheta() == Math.PI/2);
        Assert.assertTrue(p1.getPhi() == 0);
    }
}