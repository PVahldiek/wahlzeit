package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayPhoto extends Photo{

    /**
     *
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
}
