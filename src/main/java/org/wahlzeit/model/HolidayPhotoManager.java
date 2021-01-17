package org.wahlzeit.model;
import org.wahlzeit.services.SysLog;

import java.io.File;
import java.io.IOException;

@PatternInstance(patternName = "Singleton", participants = "HolidayPhotoManager")
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
        HolidayPhoto result;
        try{
            result = (HolidayPhoto) PhotoUtil.createPhoto(file, id);
        }catch (Exception e){
            SysLog.logThrowable(e);
            throw new IOException("Error during creation of photo from file");
        }
        addPhoto(result);
        return result;
    }
}
