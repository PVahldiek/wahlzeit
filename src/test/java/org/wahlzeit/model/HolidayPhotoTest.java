package org.wahlzeit.model;

import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayPhotoTest extends TestCase {

    public void testHasHolidays(){
        Holiday holiday = new Holiday(10, 2000, "Australia");
        HolidayPhoto holidayPhoto = new HolidayPhoto();
        holidayPhoto.setHoliday(holiday);
        assertEquals(holidayPhoto.getHoliday().getDays(), 10);
        assertEquals(holidayPhoto.getHoliday().getCosts(), 2000);
        assertEquals(holidayPhoto.getHoliday().getCountry(), "Australia");
    }

    @Mock
    private ResultSet rset;

    public void test() throws SQLException {
        rset = Mockito.mock(ResultSet.class);
        // That e-mail is valid string
        Mockito.when(rset.getString("owner_email_address")).thenReturn("a.test@bla.de");
        // That URL is valid string
        Mockito.when(rset.getString("owner_home_page")).thenReturn("https://localhost:8080");
        Photo p = new Photo();
        Mockito.when(rset.getString("location")).thenReturn("3/8/9");
        p.readFrom(rset);
        // Verify that exactly 5 times getString is called -> Previously it was 4 times
        Mockito.verify(rset, Mockito.times(5)).getString(Mockito.any());
    }
}