package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class HolidayManagerTest {

    @Test
    public void testCreateHoliday() {

        HolidayManager holidayManager = new HolidayManager();
        HolidayType holidayType = new HolidayType("IceLandType");
        Holiday holiday = holidayManager.createHoliday("IceLandType");
        Assert.assertTrue(!holidayManager.getHolidays().isEmpty());
    }
}
