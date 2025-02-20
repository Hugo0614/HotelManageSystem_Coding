package testCase;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;
import java.util.ArrayList;

import project.*;

public class RoomTest {

    @Test
    public void RoomTest_testChangeRoomStatus() {
        // Create a room with room number "101" and room type "Queen"
        Room room = new Room("101", new QueenType());

        // Define check-in and check-out dates
        LocalDate checkInDate = LocalDate.of(2023, 8, 3);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 6);

        // Change the room status to "Occupied" for the given dates
        room.changeRoomStatus(checkInDate, checkOutDate, new OccupiedStatus());

        // Get the room status map
        Map<LocalDate, RoomStatus> roomStatusMap = room.getRoomStatusMap();

        // Assert that the room status is "Occupied" for each date within the range
        LocalDate date = checkInDate;
        while (!date.isAfter(checkOutDate)) {
            Assert.assertTrue(roomStatusMap.get(date) instanceof OccupiedStatus);
            date = date.plusDays(1);
        }
    }
    
    @Test
    public void RoomTest_testChangeHygieneStatus() {
        Room room = new Room("201", new DeluxeType());

        LocalDate checkInDate = LocalDate.of(2023, 8, 3);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 6);

        room.changeHygieneStatus(checkInDate, checkOutDate, new DirtyStatus()); //Have the question, so it need to change back to Dirty?

        Map<LocalDate, HygieneStatus> hygieneStatusMap = room.getHygieneStatusMap();

        // Assert that the Hygiene status is "Dirty" for each date within the range
        LocalDate date = checkInDate;
        while (!date.isAfter(checkOutDate)) {
            Assert.assertTrue(hygieneStatusMap.get(date) instanceof DirtyStatus);
            date = date.plusDays(1);
        }
    }
    
    @Test
    public void RoomTest_testChangeDeviceStatus() {
        Room room = new Room("301", new DoubleType());

        LocalDate checkInDate = LocalDate.of(2023, 8, 3);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 6);

        room.changeDeviceStatus(checkInDate, checkOutDate, new HarmedStatus());

        Map<LocalDate, DeviceStatus> deviceStatusMap = room.getDeviceStatusMap();

        // Assert that the Device status is "Harmed" for each date within the range
        LocalDate date = checkInDate;
        while (!date.isAfter(checkOutDate)) {
            Assert.assertTrue(deviceStatusMap.get(date) instanceof HarmedStatus);
            date = date.plusDays(1);
        }
    }
    
    @Test
    public void RoomTest_testGetRoomStatuss() {
        // Create a room with room number "101" and room type "Queen"
        Room room = new Room("101", new QueenType());

        // Define a specific date
        LocalDate date = LocalDate.of(2023, 8, 1);

        // Get the room status for the specified date
        RoomStatus roomStatus = room.getRoomStatus(date);

        // Assert that the room status is an instance of AvailableStatus
        Assert.assertTrue(roomStatus instanceof AvailableStatus);
    }
    
    @Test
    public void RoomTest_testGetHygieneStatuss() {
        Room room = new Room("101", new QueenType());

        LocalDate date = LocalDate.of(2023, 8, 1);

        HygieneStatus hygieneStatus = room.getHygieneStatus(date);

        Assert.assertTrue(hygieneStatus instanceof DirtyStatus);
    }
    
    @Test
    public void RoomTest_testGetDeviceStatuss() {
        Room room = new Room("101", new QueenType());

        LocalDate date = LocalDate.of(2023, 8, 1);

        DeviceStatus deviceStatus = room.getDeviceStatus(date);

        Assert.assertTrue(deviceStatus instanceof OrdinaryStatus);
    }

    @Test
    public void RoomTest_testList() {
        // Create a list of rooms and add the current room to it
    	Room room = new Room("401", new FamilyType());
        ArrayList<Room> allRooms = new ArrayList<>();
        allRooms.add(room);

        // Set the room status to occupied, hygiene status to dirty, and device status to ordinary for the current date
        LocalDate currentTime = LocalDate.of(2023, 8, 4);
        LocalDate checkInDate = LocalDate.of(2023, 8, 3);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 6);
        room.changeRoomStatus(checkInDate, checkOutDate, new OccupiedStatus());
        room.changeHygieneStatus(checkInDate, checkOutDate, new DirtyStatus());  //Also have the question
        room.changeDeviceStatus(checkInDate, checkOutDate, new HarmedStatus());

        // Redirect the console output to capture it
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the list method to print the room details
        Room.list(allRooms, currentTime);

        // Restore the standard console output
        System.setOut(System.out);

        // Get the printed room details
        String printedOutput = outputStream.toString().trim();

        // Assert that the printed room details match the expected format
        Assert.assertEquals("Room Number: 401 | Room Type: Family | Room Status: Occupied | Hygiene Status: Dirty | Device Status: Harmed", printedOutput);
    }
}
