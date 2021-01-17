package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

@PatternInstance(patternName = "Abstract Factory", participants = {"HolidayPhoto", "HolidayPhotoFactory"})
public class HolidayPhoto extends Photo{

    /**
     * Holiday object - needs to be set for example in the UI (we can ignore, so it remains null)
     * If we would initialize an object here, it will be displayed in the database (like that i tested that it works)
     * Right now, every object has these properties... Removing them means null-Pointer currently.
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
    public HolidayPhoto(PhotoId myId) throws IllegalArgumentException {
        assertIsNonNullArgument(myId);
        id = myId;
        incWriteCount();
    }

    /**
     *
     * @methodtype constructor
     */
    public HolidayPhoto(ResultSet rset) throws SQLException {
        assertIsNonNullArgument(rset);
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
    public void setHoliday(Holiday newHoliday) throws IllegalArgumentException{
        assertIsNonNullArgument(newHoliday);
        holiday = newHoliday;
    }

    //Adjust writeOn and readFrom for persistence
    @Override
    public void readFrom(ResultSet rset) throws SQLException, IllegalArgumentException {
        assertIsNonNullArgument(rset);
        super.readFrom(rset);
        setHoliday(new Holiday(rset.getInt("holiday_days"), rset.getInt("holiday_costs"), rset.getString("holiday_country")));
    }

    @Override
    public void writeOn(ResultSet rset) throws SQLException, IllegalArgumentException {
        assertIsNonNullArgument(rset);
        super.writeOn(rset);
        rset.updateInt("holiday_days", getHoliday().getDays());
        rset.updateInt("holiday_costs", getHoliday().getCosts());
        rset.updateString("holiday_country", getHoliday().getCountry());
    }

    /**
     * Generic pre condition
     * @param object which is tested for null
     */
    protected void assertIsNonNullArgument(Object object){
        if(object == null)
            throw new IllegalArgumentException("Object must be not null");
    }
}