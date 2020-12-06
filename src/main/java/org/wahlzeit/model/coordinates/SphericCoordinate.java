package org.wahlzeit.model.coordinates;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate{

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

    /**
     * Autogenerated equals, forwarded to isEqual
     * @methodtype boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SphericCoordinate that = (SphericCoordinate) o;
        return isEqual(that);
    }

    /**
     * Autogenerated hashCode
     */
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
