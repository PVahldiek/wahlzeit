package org.wahlzeit.model;
import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Holiday class representing holidays
 */
public class Holiday extends DataObject {

    protected int days;
    protected int costs;
    protected String country;

    /**
     * Type-Object
     */
    protected HolidayType type = null;

    /**
     * Synchronized counter
     */
    private static AtomicLong idCounter = new AtomicLong();
    private long id = 0;


    /**
     * HolidayManager for Type-Object
     */
    protected HolidayManager manager;

    /**
     *
     * @methodtype constructor
     */
    public Holiday(int newDays, int newCosts, String newCountry) throws AssertionError{
        days = newDays;
        costs = newCosts;
        country = newCountry;
        id = idCounter.incrementAndGet();
        assertClassInvariants();
    }

    /**
     *
     * @methodtype constructor
     */
    public Holiday(HolidayType holidayType) throws AssertionError{
        this.type = holidayType;
        this.manager = HolidayManager.getInstance();
        id = idCounter.incrementAndGet();
        manager.getHolidays().put((int)getId(), this);
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
    public void setDays(int newDays) throws AssertionError{
        assertClassInvariants();
        days = newDays;
        assertClassInvariants();
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
    public void setCosts(int newCosts) throws AssertionError {
        assertClassInvariants();
        costs = newCosts;
        assertClassInvariants();
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
    public boolean isEqual(Holiday holiday) throws IllegalArgumentException{
        assertIsNonNullArgument(holiday);
        return (days == holiday.getDays()) && (costs == holiday.getCosts()) && (country == holiday.getCountry());
    }

    /**
     * Autogenerated equals, forwarded to isEqual
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holiday holiday = (Holiday) o;
        return isEqual(holiday);
    }

    /**
     * Autogenerated hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(days, costs, country);
    }

    /**
     * Generic pre condition
     * @param object which is tested for null
     */
    protected void assertIsNonNullArgument(Object object) throws IllegalArgumentException{
        if(object == null)
            throw new IllegalArgumentException("Object must be not null");
    }

    /**
     * Class Invariants for Holiday (not negative)
     */
    protected void assertClassInvariants() throws AssertionError{
        assert !(days < 0) && !(costs < 0);
    }

    public HolidayType getType() {
        return type;
    }

    public long getId() {
        long id = this.id;
        return id;
    }

    @Override
    public String getIdAsString() {
        return String.valueOf(id);
    }

    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        id = Long.parseLong(rset.getString("id"));
        days = rset.getInt("holiday_days");
        costs = rset.getInt("holiday_costs");
        country = rset.getString("holiday_country");
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateString("id", String.valueOf(id));
        rset.updateString("holiday_days", String.valueOf(days));
        rset.updateString("holiday_days", String.valueOf(costs));
        rset.updateString("holiday_days", String.valueOf(country));
    }

    @Override
    public void writeId(PreparedStatement stmt, int pos) throws SQLException {
        stmt.setNString(pos, String.valueOf(id));
    }
}
