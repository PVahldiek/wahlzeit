package org.wahlzeit.model;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        return new HolidayPhoto(id);
    }

    /**
     *
     */
    public HolidayPhoto createPhoto(ResultSet rs) throws SQLException {
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
