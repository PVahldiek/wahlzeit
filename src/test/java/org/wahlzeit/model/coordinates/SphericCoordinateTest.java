package org.wahlzeit.model.coordinates;
import org.junit.Assert;
import org.junit.Test;

public class SphericCoordinateTest {

    @Test
    public void testAsCartesianCoordinate() {
        SphericCoordinate p1 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 1);
        CartesianCoordinate c1 = p1.asCartesianCoordinate();
        // Happens due to double precision
        Assert.assertTrue(c1.getX() < 1E-10);
        Assert.assertTrue(c1.getY() == 1);
        Assert.assertTrue(c1.getZ() < 1E-10);
    }

    @Test
    public void testGetCartesianDistance() {
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0);
        SphericCoordinate p1 = new SphericCoordinate(0,0,0);
        double distance = p1.getCartesianDistance(c1);
        Assert.assertTrue(distance == 1);
    }

    @Test
    public void testAsSphericCoordinate() {
        // Reverse test of testAsCartesianCoordinate
        CartesianCoordinate c1 = new CartesianCoordinate(0, 1, 0);
        SphericCoordinate p1 = c1.asSphericCoordinate();
        Assert.assertTrue(p1.getPhi() == Math.PI / 2);
        Assert.assertTrue(p1.getTheta() == Math.PI / 2);
        Assert.assertTrue(p1.getRadius() == 1);
    }

    @Test
    public void testGetCentralAngle() {
        SphericCoordinate p1 = new SphericCoordinate(0, Math.PI/ 2, 1);
        SphericCoordinate p2 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 1);
        double distance = p1.getCentralAngle(p2);
        Assert.assertTrue(distance == Math.PI/2);
    }

    @Test
    public void testIsEqual() {
        SphericCoordinate p1 = new SphericCoordinate(0, Math.PI/ 2, 1);
        SphericCoordinate p2 = new SphericCoordinate(0, Math.PI/ 2, 1);
        Assert.assertTrue(p1.isEqual(p2));
        Assert.assertTrue(p2.isEqual(p1));
    }

    @Test
    public void testIsNotEqual() {
        SphericCoordinate p1 = new SphericCoordinate(0, Math.PI/ 2, 1);
        SphericCoordinate p2 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 1);
        Assert.assertFalse(p1.isEqual(p2));
        Assert.assertFalse(p2.isEqual(p1));
    }

    @Test
    public void testTestEquals() {
        SphericCoordinate p1 = new SphericCoordinate(0, Math.PI/ 2, 1);
        SphericCoordinate p2 = new SphericCoordinate(0, Math.PI/ 2, 1);
        Assert.assertTrue(p1.equals(p2));
        Assert.assertTrue(p2.equals(p1));
    }

    @Test
    public void testTestNotEquals() {
        SphericCoordinate p1 = new SphericCoordinate(0, Math.PI/ 2, 1);
        SphericCoordinate p2 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 1);
        Assert.assertFalse(p1.equals(p2));
        Assert.assertFalse(p2.equals(p1));
    }

    @Test
    public void testIsEqualTwoDifferentTypes() {
        // Parameters from testAsCartesianCoordinate
        SphericCoordinate p1 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 1);
        CartesianCoordinate c1 = new CartesianCoordinate(0, 1, 0);
        Assert.assertTrue(p1.isEqual(c1));
        Assert.assertTrue(c1.isEqual(p1));
    }

    @Test
    public void testIsNotEqualTwoDifferentTypes() {
        // Parameters from testAsCartesianCoordinate
        SphericCoordinate p1 = new SphericCoordinate(Math.PI / 2, Math.PI/2, 0);
        CartesianCoordinate c1 = new CartesianCoordinate(0, 1, 0);
        Assert.assertFalse(p1.isEqual(c1));
        Assert.assertFalse(c1.isEqual(p1));
    }

    @Test
    public void testHashCodeEquals(){
        SphericCoordinate p1 = new SphericCoordinate(3, 6, 9);
        SphericCoordinate p2 = new SphericCoordinate(3, 6, 9);
        Assert.assertTrue(p1.hashCode() == p2.hashCode());
    }

    @Test
    public void testHashCodeNotEquals(){
        SphericCoordinate p1 = new SphericCoordinate(3, 6, 9);
        SphericCoordinate p2 = new SphericCoordinate(3, 6, 10);
        Assert.assertFalse(p1.hashCode() == p2.hashCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCartesianDistanceShouldThrowNullPointer(){
        SphericCoordinate p1 = new SphericCoordinate(1, 0, 0 );
        p1.getCartesianDistance(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisEqualShouldThrowNullPointer(){
        SphericCoordinate p1 = new SphericCoordinate(1, 0, 0 );
        p1.isEqual(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCentralAngleShouldThrowNullPointer(){
        SphericCoordinate p1 = new SphericCoordinate(1, 0, 0 );
        p1.getCentralAngle(null);
    }

}