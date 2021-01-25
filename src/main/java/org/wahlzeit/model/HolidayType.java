package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Type-Object class for Holiday
 */
public class HolidayType {

    protected HolidayType superType = null;
    protected Set<HolidayType> subTypes = new HashSet<HolidayType>();
    protected HolidayManager manager;
    protected String typeName;

    /**
     * Synchronized counter
     */
    private static AtomicLong idCounter = new AtomicLong();

    public HolidayType(String typeName){
        this.typeName = typeName;
        manager = HolidayManager.getInstance();
        manager.getHolidayTypes().put(typeName, this);
    }

    public Holiday createInstance(){
        return new Holiday(this);
    }

    public Iterator<HolidayType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(HolidayType ht) {
        assert (ht != null) : "tried to set null sub-type";
        ht.setSuperType(this);
        subTypes.add(ht);
    }

    public boolean isSubType(){
        if(superType == null){
            return false;
        }
        return true;
    }

    public void setSuperType(HolidayType ht){
        superType = ht;
    }

    public HolidayType getSuperType() {
        return superType;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean hasInstance(Holiday holiday) {
        assert (holiday != null) : "asked about null object";
        if (holiday.getType() == this) {
            return true;
        }
        for (HolidayType type : subTypes) {
            if (type.hasInstance(holiday)) {
                return true;
            }
        }
        return false;
    }
}
