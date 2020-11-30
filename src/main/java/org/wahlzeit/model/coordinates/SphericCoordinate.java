package org.wahlzeit.model.coordinates;

import java.util.Objects;

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
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public double getCentralAngle(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        SphericCoordinate p1 = coordinate.asSphericCoordinate();
        if(Double.compare(radius, p1.getRadius()) != 0){
            throw new IllegalStateException("Radius must be equal for calculating distance");
        }
        return radius * Math.acos(Math.sin(phi) * Math.sin(p1.getPhi()) + Math.cos(phi) * Math.cos(p1.getPhi()) * Math.cos(p1.getTheta() - theta));
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(coordinate == null)
            throw new NullPointerException("coordinate must not be null");
        return isEqual(coordinate.asSphericCoordinate());
    }

    public boolean isEqual(SphericCoordinate sphericCoordinate){
        if(sphericCoordinate == null)
            throw new NullPointerException("sphericCoordinate must not be null");
        return (Math.abs(phi - sphericCoordinate.getPhi()) < 1E-7) && (Math.abs(theta - sphericCoordinate.getTheta()) < 1E-7) && (Math.abs(radius - sphericCoordinate.getRadius()) < 1E-7);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphericCoordinate that = (SphericCoordinate) o;
        return isEqual(that);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phi, theta, radius);
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
