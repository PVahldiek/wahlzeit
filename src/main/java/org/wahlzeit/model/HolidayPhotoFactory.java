package org.wahlzeit.model;
import java.sql.ResultSet;
import java.sql.SQLException;

@PatternInstance(patternName = "Abstract Factory", participants = {"HolidayPhoto", "HolidayPhotoFactory"})
public class HolidayPhotoFactory extends PhotoFactory{

    /**
     * @methodtype constructor
     */
    public HolidayPhotoFactory(){
        super();
    }

    /**
     * @methodtype factory
     */
    public HolidayPhoto createPhoto() {
        return new HolidayPhoto();
    }

    /**
     *
     */
    public HolidayPhoto createPhoto(PhotoId id) {
        if(id == null)
            throw new IllegalArgumentException("PhotoId should not be null");
        return new HolidayPhoto(id);
    }

    /**
     *
     */
    public HolidayPhoto createPhoto(ResultSet rs) throws SQLException {
        if(rs == null)
            throw new IllegalArgumentException("ResultSet should not be null");
        return new HolidayPhoto(rs);
    }

    /**
     *
     */
    public PhotoFilter createPhotoFilter() {
        return new PhotoFilter();
    }

    /**
     *
     */
    public PhotoTagCollector createPhotoTagCollector() {
        return new PhotoTagCollector();
    }
}
