package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

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
}
