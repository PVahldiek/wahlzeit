package org.wahlzeit.model;
import java.io.File;


public class HolidayPhotoManager extends PhotoManager{

    /**
     *
     */
    protected static final PhotoManager instance = new HolidayPhotoManager();


    /**
     * @methodtype constructor
     */
    public HolidayPhotoManager() {
        super();
    }

    /**
     * Overriding method so that HolidayPhotos are processed
     */
    public HolidayPhoto createPhoto(File file) throws Exception {
        PhotoId id = PhotoId.getNextId();
        HolidayPhoto result = (HolidayPhoto) PhotoUtil.createPhoto(file, id);
        addPhoto(result);
        return result;
    }
}
