package org.wahlzeit.model;

import junit.framework.TestCase;

public class HolidayPhotoTest extends TestCase {

    public void testHasHolidays(){
        Holiday holiday = new Holiday(10, 2000, "Australia");
        HolidayPhoto holidayPhoto = new HolidayPhoto();
        holidayPhoto.setHoliday(holiday);
        assertEquals(holidayPhoto.getHoliday().getDays(), 10);
        assertEquals(holidayPhoto.getHoliday().getCosts(), 2000);
        assertEquals(holidayPhoto.getHoliday().getCountry(), "Australia");
    }

}