package org.wahlzeit.model;

import junit.framework.TestCase;
import org.junit.Assert;

public class CoordinateTest extends TestCase {

    public void testGetDistance() {
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 10);
        Assert.assertTrue(c1.getDistance(c2) == 1);

        Coordinate c3 = new Coordinate(3, 6, 9);
        Coordinate c4 = new Coordinate(3, 7, 9);
        Assert.assertTrue(c3.getDistance(c4) == 1);

        Coordinate c5 = new Coordinate(3, 6, 9);
        Coordinate c6 = new Coordinate(4, 6, 9);
        Assert.assertTrue(c5.getDistance(c6) == 1);
    }

    public void testIsEqual() {
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 9);
        Assert.assertTrue(c1.isEqual(c2));
        Assert.assertTrue(c2.isEqual(c1));
    }

    public void testIsNotEqual() {
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 10);
        Assert.assertFalse(c1.isEqual(c2));
        Assert.assertFalse(c2.isEqual(c1));
    }

    public void testTestEquals() {
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 9);
        Assert.assertTrue(c1.equals(c2));
        Assert.assertTrue(c2.equals(c1));
    }

    public void testTestNotEquals() {
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 10);
        Assert.assertFalse(c1.equals(c2));
        Assert.assertFalse(c2.equals(c1));
    }

    public void testHashCodeEquals(){
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 9);
        Assert.assertTrue(c1.hashCode() == c2.hashCode());
    }

    public void testHashCodeNotEquals(){
        Coordinate c1 = new Coordinate(3, 6, 9);
        Coordinate c2 = new Coordinate(3, 6, 10);
        Assert.assertFalse(c1.hashCode() == c2.hashCode());
    }
}