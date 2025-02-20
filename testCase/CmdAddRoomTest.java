package testCase;

import org.junit.Assert;
import org.junit.Test;

import project.CmdAddRoom;
import project.Hotel;
import project.Room;

public class CmdAddRoomTest {

    @Test
    public void CmdAddRoomTest_testExecute_Queen() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
        // Execute the command with valid cmdParts
        String[] cmdParts = {"addRoom", "101", "Queen"};
        cmdAddRoom.execute(cmdParts);

        // Get the room with room number "101" from the hotel
        Room addedRoom = hotel.findRoom("101");

        // Assert that the added room is not null and has the correct room number and room type
        Assert.assertNotNull(addedRoom);
        Assert.assertEquals("101", addedRoom.getRoomNumber());
        Assert.assertEquals("Queen", addedRoom.getRoomType().getType());
    }
    
    @Test
    public void CmdAddRoomTest_testExecute_Deluxe() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
        String[] cmdParts = {"addRoom", "201", "Deluxe"};
        cmdAddRoom.execute(cmdParts);

        Room addedRoom = hotel.findRoom("201");

        Assert.assertNotNull(addedRoom);
        Assert.assertEquals("201", addedRoom.getRoomNumber());
        Assert.assertEquals("Deluxe", addedRoom.getRoomType().getType());
    }
   
    @Test
    public void CmdAddRoomTest_testExecute_Double() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
    	
        String[] cmdParts = {"addRoom", "301", "Double"};
        cmdAddRoom.execute(cmdParts);
        Room addedRoom = hotel.findRoom("301");

        Assert.assertNotNull(addedRoom);
        Assert.assertEquals("301", addedRoom.getRoomNumber());
        Assert.assertEquals("Double", addedRoom.getRoomType().getType());
    }
    
    @Test
    public void CmdAddRoomTest_testExecute_Family() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
    	
        String[] cmdParts = {"addRoom", "401", "Family"};
        cmdAddRoom.execute(cmdParts);

        Room addedRoom = hotel.findRoom("401");

        Assert.assertNotNull(addedRoom);
        Assert.assertEquals("401", addedRoom.getRoomNumber());
        Assert.assertEquals("Family", addedRoom.getRoomType().getType());
    }
    
    @Test
    public void CmdAddRoomTest_testExecute_Standard() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
    	
        String[] cmdParts = {"addRoom", "501", "Standard"};
        cmdAddRoom.execute(cmdParts);

        Room addedRoom = hotel.findRoom("501");

        Assert.assertNotNull(addedRoom);
        Assert.assertEquals("501", addedRoom.getRoomNumber());
        Assert.assertEquals("Standard", addedRoom.getRoomType().getType());
    }
    
    @Test
    public void CmdAddRoomTest_testExecute_Business() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
    	
        String[] cmdParts = {"addRoom", "601", "Business"};
        cmdAddRoom.execute(cmdParts);

        Room addedRoom = hotel.findRoom("601");

        Assert.assertNotNull(addedRoom);
        Assert.assertEquals("601", addedRoom.getRoomNumber());
        Assert.assertEquals("Business", addedRoom.getRoomType().getType());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void CmdAddRoomTest_testExecute_InvalidRoomType() {
    	CmdAddRoom cmdAddRoom = new CmdAddRoom();
        Hotel hotel = Hotel.getInstance();
        
        // Execute the command with an invalid room type
        String[] cmdParts = {"addRoom", "105", "Lego"};
        cmdAddRoom.execute(cmdParts);
        
        //Assert.assertEquals("Invalid room type: Lego",  cmdAddRoom.execute(cmdParts))
        // The test should throw an IllegalArgumentException
    }
}