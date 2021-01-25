package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class HolidayTypeTest {

    @Test
    public void testCreateInstance() {
        HolidayType ht = new HolidayType("IceLand");
        Holiday h = ht.createInstance();
        Assert.assertTrue(h.getType() == ht);
    }

    @Test
    public void testAddSubType() {
        HolidayType type = new HolidayType("IceLand");
        HolidayType subType = new HolidayType("IreLand");
        type.addSubType(subType);
        Iterator it = type.getSubTypeIterator();
        while(it.hasNext()){
            if(it.next() == subType){
                if(type.getSubTypeIterator().next().superType == type){
                    return;
                }
            }
        }
        Assert.fail();
    }

    @Test
    public void testIsSubType() {
        HolidayType type = new HolidayType("IceLand");
        HolidayType subType = new HolidayType("IreLand");

        type.addSubType(subType);
        Assert.assertFalse(type.isSubType());
        Assert.assertTrue(subType.isSubType());
    }

    @Test
    public void testHasInstance() {
        HolidayManager holidayManager = new HolidayManager();
        HolidayType holidayType = new HolidayType("IceLand");
        Holiday holiday = holidayManager.createHoliday("IceLand");
        Assert.assertTrue(holiday.getType().hasInstance(holiday));
    }

    @Test
    public void testHierarchy() {
        HolidayManager holidayManager = HolidayManager.getInstance();
        HolidayType top = new HolidayType("top");
        HolidayType mid = new HolidayType("mid");
        HolidayType bot = new HolidayType("bot");
        top.addSubType(mid);
        mid.addSubType(bot);

        Assert.assertFalse(top.isSubType());
        Assert.assertTrue(mid.isSubType());
        Assert.assertTrue(mid.getSuperType().equals(top));
        Assert.assertTrue(bot.isSubType());
        Assert.assertTrue(bot.getSuperType().equals(mid));
    }
}
