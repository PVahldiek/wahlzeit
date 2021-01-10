package org.wahlzeit.model;

import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.wahlzeit.model.coordinates.CartesianCoordinate;
import org.wahlzeit.model.coordinates.SphericCoordinate;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoTest extends TestCase {

    @Mock
    private ResultSet rsetRead;

    @Mock
    private ResultSet rsetWrite;

    public void testLocationIsRead() throws SQLException {
        rsetRead = Mockito.mock(ResultSet.class);
        // That e-mail is valid string - otherwise error occurs
        Mockito.when(rsetRead.getString("owner_email_address")).thenReturn("a.test@bla.de");
        // That URL is valid string - otherwise error occurs
        Mockito.when(rsetRead.getString("owner_home_page")).thenReturn("https://localhost:8080");
        Photo p = new Photo();
        Mockito.when(rsetRead.getString("location")).thenReturn("3/8/9");
        p.readFrom(rsetRead);
        // Verify that exactly 5 times getString is called -> Previously it was 4 times
        Mockito.verify(rsetRead, Mockito.times(5)).getString(Mockito.any());
    }

    public void testLocationIsWritten() throws SQLException, MalformedURLException {
        rsetWrite = Mockito.mock(ResultSet.class);
        Photo p = new Photo();
        // That URL is valid string - otherwise error occurs
        p.setOwnerHomePage(new URL("https://localhost:8080"));
        // Verify that exactly 5 times getString is called -> Previously it was 4 times
        p.writeOn(rsetWrite);
        Mockito.verify(rsetWrite, Mockito.times(5)).updateString(Mockito.any(), Mockito.any());
    }

    public void testWriteOnLocationIsCorrectObjectSpheric() throws SQLException, MalformedURLException {
        rsetWrite = Mockito.mock(ResultSet.class);
        Photo p = new Photo();
        // That URL is valid string - otherwise error occurs
        p.setOwnerHomePage(new URL("https://localhost:8080"));
        Location location = new Location(SphericCoordinate.createSphericCoordinate(2,2, 2));
        p.setLocation(location);
        // Verify that exactly 5 times getString is called -> Previously it was 4 times
        p.writeOn(rsetWrite);
        Mockito.verify(rsetWrite, Mockito.times(1)).updateString("location", "s(" + location.getCoordinate().asSphericCoordinate().getPhi() + "/" + location.getCoordinate().asSphericCoordinate().getTheta() + "/" + location.getCoordinate().asSphericCoordinate().getRadius() + ")");
    }

    public void testWriteOnLocationIsCorrectObjectCartesian() throws SQLException, MalformedURLException {
        rsetWrite = Mockito.mock(ResultSet.class);
        Photo p = new Photo();
        // That URL is valid string - otherwise error occurs
        p.setOwnerHomePage(new URL("https://localhost:8080"));
        Location location = new Location(CartesianCoordinate.createCartesianCoordinate(2,2, 2));
        p.setLocation(location);
        // Verify that exactly 5 times getString is called -> Previously it was 4 times
        p.writeOn(rsetWrite);
        Mockito.verify(rsetWrite, Mockito.times(1)).updateString("location", "c(" + location.getCoordinate().asCartesianCoordinate().getX() + "/" + location.getCoordinate().asCartesianCoordinate().getY() + "/" + location.getCoordinate().asCartesianCoordinate().getZ() + ")");
    }
}
