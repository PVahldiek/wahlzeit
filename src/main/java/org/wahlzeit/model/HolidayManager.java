package org.wahlzeit.model;

import org.wahlzeit.services.ObjectManager;
import org.wahlzeit.services.Persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * A holiday manager for creating and operating Holiday Objects
 */
@PatternInstance(patternName = "Singleton", participants = "HolidayManager")
public class HolidayManager extends ObjectManager {

    /**
     * HashMaps for processing Holidays and HolidayTypes
     */
    protected static HashMap<String, HolidayType> holidayTypes = new HashMap<>();
    protected static HashMap<Integer, Holiday> holidays = new HashMap<>();

    /**
     * Instance for Singleton usage
     */
    protected static HolidayManager instance = null;

    /**
     *
     * @methodtype constructor
     */
    protected HolidayManager() {
        // do nothing
    }

    public static HolidayManager getInstance() {
        if (instance == null) {
            instance = new HolidayManager();
        }
        return instance;
    }

    /**
     * Creates Holiday Object, checks for existing Type-Object
     * @methodtype factory
     */
    public Holiday createHoliday(String typeName) {
        assertIsValidHolidayTypeName(typeName);
        HolidayType ht = getHolidayType(typeName);
        Holiday result = ht.createInstance();
        holidays.put((int) result.getId(), result);
        return result;
    }

    /**
     *
     * @methodtype factory
     */
    private HolidayType getHolidayType(String typename){
        return holidayTypes.get(typename);
    }

    /**
     * Assert that Type Object is existing
     * @throws IllegalArgumentException if HolidayType is not found
     */
    private void assertIsValidHolidayTypeName(String typename){
        if(holidayTypes.get(typename) == null){
            throw new IllegalArgumentException("HolidayType not found");
        }
    }

    /**
     *
     * @methodtype get
     */
    public HashMap<String, HolidayType> getHolidayTypes(){
        return holidayTypes;
    }

    /**
     *
     * @methodtype get
     */
    public HashMap<Integer, Holiday> getHolidays(){
        return holidays;
    }

    @Override
    protected Persistent createObject(ResultSet rset) throws SQLException {
        return createHoliday(rset.getObject("holidayType", HolidayType.class).getTypeName());
    }
}
