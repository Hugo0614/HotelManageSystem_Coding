package testCase;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import project.RoomStatus;
import project.OccupiedStatus;
import project.BookedStatus;
import project.AvailableStatus;
import project.HygieneStatus;
import project.DirtyStatus;
import project.CleanStatus;
import project.DeviceStatus;
import project.HarmedStatus;
import project.OrdinaryStatus;

public class StatusTest {
	
    @Test
    public void testOccupiedStatus() {
        RoomStatus status = new OccupiedStatus();
        assertEquals("Occupied", status.getStatus());
    }

    @Test
    public void testBookedStatus() {
        RoomStatus status = new BookedStatus();
        assertEquals("Booked", status.getStatus());
    }

    @Test
    public void testAvailableStatus() {
        RoomStatus status = new AvailableStatus();
        assertEquals("Available", status.getStatus());
    }
    
    @Test
    public void testDirtyStatus() {
        HygieneStatus status = new DirtyStatus();
        assertEquals("Dirty", status.getStatus());
    }

    @Test
    public void testCleanStatus() {
        HygieneStatus status = new CleanStatus();
        assertEquals("Clean", status.getStatus());
    }
    
    @Test
    public void testHarmedStatus() {
        DeviceStatus status = new HarmedStatus();
        assertEquals("Harmed", status.getStatus());
    }
    
    @Test
    public void testOrdinaryStatus() {
        DeviceStatus status = new OrdinaryStatus();
        assertEquals("Ordinary", status.getStatus());
    }
}
