package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * A holiday manager for creating and operating Holiday Objects
 */
@PatternInstance(patternName = "Singleton", participants = "PhotoManager")
public class HolidayManager extends ObjectManager {

    protected static HashMap<String, HolidayType> holidayTypes = new HashMap<>();
    protected static HashMap<Integer, Holiday> holidays = new HashMap<>();
    protected static HolidayManager instance = null;

    protected HolidayManager() {
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

    public HashMap<String, HolidayType> getHolidayTypes(){
        return holidayTypes;
    }

    public HashMap<Integer, Holiday> getHolidays(){
        return holidays;
    }

    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException {
        return createHoliday(rset.getObject("holidayType", HolidayType.class).getTypeName());
    }
}
