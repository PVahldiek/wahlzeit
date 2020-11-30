package org.wahlzeit.model.coordinates;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class CartesianCoordinateTest {

    @Test
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

    @Test(expected = NullPointerException.class)
    public void testGetDistanceShouldThrowNullPointer(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        c1.getDistance(null);
    }

    @Test(expected = NullPointerException.class)
    public void testisEqualShouldThrowNullPointer(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        c1.isEqual(null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetCentralAngleShouldThrowNullPointer(){
        CartesianCoordinate c1 = new CartesianCoordinate(1, 0, 0 );
        c1.getCentralAngle(null);
    }
}