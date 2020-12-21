package org.wahlzeit.model.coordinates;
import org.junit.Assert;
import org.junit.Test;
import org.wahlzeit.model.coordinates.exc.CalculationException;

public class CartesianCoordinateTest {

    @Test
    public void testGetDistance() throws CalculationException {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertTrue(c1.getCartesianDistance(c2) == 1);

        CartesianCoordinate c3 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c4 = new CartesianCoordinate(3, 7, 9);
        Assert.assertTrue(c3.getCartesianDistance(c4) == 1);

        CartesianCoordinate c5 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c6 = new CartesianCoordinate(4, 6, 9);
        Assert.assertTrue(c5.getCartesianDistance(c6) == 1);
    }

    @Test
    public void testIsEqual() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 9);
        Assert.assertTrue(c1.isEqual(c2));
        Assert.assertTrue(c2.isEqual(c1));
    }

    @Test
    public void testIsNotEqual() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertFalse(c1.isEqual(c2));
        Assert.assertFalse(c2.isEqual(c1));
    }

    @Test
    public void testTestEquals() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 9);
        Assert.assertTrue(c1.equals(c2));
        Assert.assertTrue(c2.equals(c1));
    }

    @Test
    public void testTestNotEquals() {
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertFalse(c1.equals(c2));
        Assert.assertFalse(c2.equals(c1));
    }

    @Test
    public void testHashCodeEquals(){
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 9);
        Assert.assertTrue(c1.hashCode() == c2.hashCode());
    }

    @Test
    public void testHashCodeNotEquals(){
        CartesianCoordinate c1 = new CartesianCoordinate(3, 6, 9);
        CartesianCoordinate c2 = new CartesianCoordinate(3, 6, 10);
        Assert.assertFalse(c1.hashCode() == c2.hashCode());
    }

    @Test
    public void testAsSphericCoordinate(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        SphericCoordinate p1 = c1.asSphericCoordinate();
        Assert.assertTrue(p1.getRadius() == 1);
        Assert.assertTrue(p1.getTheta() == Math.PI/2);
        Assert.assertTrue(p1.getPhi() == 0);
    }

    @Test(expected = IllegalStateException.class)
    public void testAsSphericCoordinateShouldThrowIllegalStateException(){
        CartesianCoordinate p1 = new CartesianCoordinate(0, 0, 0 );
        p1.asSphericCoordinate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetDistanceShouldThrowNullPointer() throws CalculationException {
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        c1.getCartesianDistance(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testisEqualShouldThrowNullPointer(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        c1.isEqual(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCentralAngleShouldThrowNullPointer() throws CalculationException {
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        c1.getCentralAngle(null);
    }

    @Test(expected = AssertionError.class)
    public void testObjectNotInvariant(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, Double.NaN);
    }

    @Test(expected = AssertionError.class)
    public void testObjectSetNotInvariant(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0,0);
        c1.setX(Double.NaN);
    }
}