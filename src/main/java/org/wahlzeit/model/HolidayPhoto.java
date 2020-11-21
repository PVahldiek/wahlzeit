package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayPhoto extends Photo{

    /**
     * Holiday object
     */
    protected Holiday holiday;

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
}
