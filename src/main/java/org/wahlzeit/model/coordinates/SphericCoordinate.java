package org.wahlzeit.model.coordinates;

public class SphericCoordinate implements Coordinate{

    /**
     *
     */
    private double phi;
    private double theta;
    private double radius;

    /**
     * @methodtype constructor
     */
    public SphericCoordinate(double phi, double theta, double radius){
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return 0;
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        return false;
    }

    /**
     *
     * @methodtype set
     */
    public void setPhi(double newPhi) {
        phi = newPhi;
    }

    /**
     *
     * @methodtype get
     */
    public double getPhi() {
        return phi;
    }

    /**
     *
     * @methodtype set
     */
    public void setTheta(double newTheta) {
        theta = newTheta;
    }

    /**
     *
     * @methodtype get
     */
    public double getTheta() {
        return theta;
    }

    /**
     *
     * @methodtype set
     */
    public void setRadius(double newRadius) {
        radius = newRadius;
    }

    /**
     *
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }
}
