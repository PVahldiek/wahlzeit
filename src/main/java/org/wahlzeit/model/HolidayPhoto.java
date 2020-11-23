package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayPhoto extends Photo{

    /**
     * Holiday object - needs to be set for example in the UI (we can ignore, so it remains null)
     * If we would initialize an object here, it will be displayed in the database (like that i tested that it works)
     */
    protected Holiday holiday = new Holiday(10, 3300, "Island");

    /**
     *
     * @methodtype constructor
     */
    public HolidayPhoto() {
        id = PhotoId.getNextId();
        incWriteCount();
    }

    /**
     *
     * @methodtype constructor
     */
    public HolidayPhoto(PhotoId myId) {
        id = myId;
        incWriteCount();
    }

    /**
     *
     * @methodtype constructor
     */
    public HolidayPhoto(ResultSet rset) throws SQLException {
        readFrom(rset);
    }

    /**
     *
     * @methodtype get
     */
    public Holiday getHoliday() {
        return holiday;
    }

    /**
     *
     * @methodtype set
     */
    public void setHoliday(Holiday newHoliday){
        if(newHoliday == null)
            throw new IllegalArgumentException("Holiday must not be null");
        holiday = newHoliday;
    }

    //Adjust writeOn and readFrom for persistence
    @Override
    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        setHoliday(new Holiday(rset.getInt("holiday_days"), rset.getInt("holiday_costs"), rset.getString("holiday_country")));
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException {
        super.writeOn(rset);
        rset.updateInt("holiday_days", getHoliday().getDays());
        rset.updateInt("holiday_costs", getHoliday().getCosts());
        rset.updateString("holiday_country", getHoliday().getCountry());
    }
}