package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Type-Object class for Holiday
 */
public class HolidayType {

    /**
     * Fields for hierarchy processing
     */
    protected HolidayType superType = null;
    protected Set<HolidayType> subTypes = new HashSet<HolidayType>();

    protected HolidayManager manager;
    protected String typeName;


    /**
     *
     * @methodtype constructor
     */
    public HolidayType(String typeName){
        this.typeName = typeName;
        manager = HolidayManager.getInstance();
        manager.getHolidayTypes().put(typeName, this);
    }

    /**
     * Creates Holiday Object using current Type Object
     * @return new Holiday Object
     */
    public Holiday createInstance(){
        return new Holiday(this);
    }

    /**
     * List-Iterator for easy subtype access
     * @return Iterator Object
     */
    public Iterator<HolidayType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    /**
     * Add new SubType to current Type
     */
    public void addSubType(HolidayType ht) {
        assert (ht != null) : "tried to set null sub-type";
        ht.setSuperType(this);
        subTypes.add(ht);
    }

    /**
     * Checks if current Type is a SubType of another Type
     * @return Boolean
     */
    public boolean isSubType(){
        if(superType == null){
            return false;
        }
        return true;
    }

    /**
     *
     * @methodtype set
     */
    public void setSuperType(HolidayType ht){
        superType = ht;
    }

    /**
     *
     * @methodtype get
     */
    public HolidayType getSuperType() {
        return superType;
    }

    /**
     *
     * @methodtype get
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Checks if a given Holiday Object has an this Type-Class as an Instance
     * Recursive Call
     * @return Boolean
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HolidayType that = (HolidayType) o;
        return Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName);
    }
}
