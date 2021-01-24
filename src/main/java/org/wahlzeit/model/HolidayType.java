package org.wahlzeit.model;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Type-Object class for Holiday
 */
public class HolidayType {

    protected HolidayType superType = null;
    protected Set<HolidayType> subTypes = new HashSet<HolidayType>();

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

    public void setSuperType(HolidayType ht){
        superType = ht;
    }

    public HolidayType getSuperType() {
        return superType;
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
