package org.wahlzeit.model;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class HolidayPhotoTest {

    @Test
    public void testHasHolidays(){
        Holiday holiday = new Holiday(10, 2000, "Australia");
        HolidayPhoto holidayPhoto = new HolidayPhoto();
        holidayPhoto.setHoliday(holiday);
        assertEquals(holidayPhoto.getHoliday().getDays(), 10);
        assertEquals(holidayPhoto.getHoliday().getCosts(), 2000);
        assertEquals(holidayPhoto.getHoliday().getCountry(), "Australia");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHolidayShouldThrowNullPointer(){
        HolidayPhoto holidayPhoto = new HolidayPhoto();
        holidayPhoto.setHoliday(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWriteOnShouldThrowNullPointer() throws SQLException {
        HolidayPhoto holidayPhoto = new HolidayPhoto();
        holidayPhoto.writeOn(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReadFromShouldThrowNullPointer() throws SQLException {
        HolidayPhoto holidayPhoto = new HolidayPhoto();
        holidayPhoto.readFrom(null);
    }

}