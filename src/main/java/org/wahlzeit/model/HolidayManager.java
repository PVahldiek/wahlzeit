package org.wahlzeit.model;

import java.util.HashMap;

/**
 * A holiday manager for creating and operating Holiday Objects
 */
@PatternInstance(patternName = "Singleton", participants = "PhotoManager")
public class HolidayManager {

    protected static HashMap<Integer, HolidayType> holidayTypes = new HashMap<>();
    protected static HashMap<Integer, Holiday> holidays = new HashMap<>();
    protected static HolidayManager instance = null;

    private HolidayManager() {
        // do nothing
    }

    public static HolidayManager getInstance() {
        if (instance == null) {
            instance = new HolidayManager();
        }
        return instance;
    }

    public Holiday createHoliday(String typeName) {
        assertIsValidHolidayTypeName(typeName);
        HolidayType ht = getHolidayType(typeName);
        Holiday result = ht.createInstance();
        holidays.put((int) result.getId(), result);
        return result;
    }

    private HolidayType getHolidayType(String typename){
        return holidayTypes.get(typename);
    }

    private void assertIsValidHolidayTypeName(String typename){
        if(holidayTypes.get(typename) == null){
            throw new IllegalArgumentException("HolidayType not found");
        }
    }
}
