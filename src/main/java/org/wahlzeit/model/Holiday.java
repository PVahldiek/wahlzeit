package org.wahlzeit.model;
import java.util.Objects;

/**
 * Holiday class representing holidays
 */
public class Holiday {

    protected int days;
    protected int costs;
    protected String country;

    /**
     *
     * @methodtype constructor
     */
    public Holiday(int newDays, int newCosts, String newCountry) {
        days = newDays;
        costs = newCosts;
        country = newCountry;
    }

    /**
     *
     * @methodtype get
     */
    public int getDays() {
        return days;
    }

    /**
     *
     * @methodtype set
     */
    public void setDays(int newDays) {
        days = newDays;
    }

    /**
     *
     * @methodtype get
     */
    public int getCosts() {
        return costs;
    }

    /**
     *
     * @methodtype set
     */
    public void setCosts(int newCosts) {
        costs = newCosts;
    }

    /**
     *
     * @methodtype get
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @methodtype set
     */
    public void setCountry(String newCountry) {
        country = newCountry;
    }

    /**
     * Checks if two holidays are equal
     * @methodtype boolean
     */
    public boolean isEqual(Holiday holiday) {
        return (days == holiday.getDays()) && (costs == holiday.getCosts()) && (country == holiday.getCountry());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return isEqual(holiday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, costs, country);
    }
}
