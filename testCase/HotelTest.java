package testCase;  //need to change 

import org.junit.Assert;
import org.junit.Test;

import project.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class HotelTest {

    @Test
    public void HotelTest_testListRooms() {
    	// Add rooms to the hotel
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        
        LocalDate currentTime = LocalDate.of(2023, 8, 4);

        // Capture the output of the listRooms method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        hotel.listRooms(currentTime);         //change the location
        System.setOut(printStream);
        //hotel.listRooms(currentTime);
        String expectedOutput = 
        "Room Number: 101 | Room Type: Queen | Room Status: Occupied | Hygiene Status: Dirty | Device Status: Harmed\n"
    + "Room Number: 201 | Room Type: Deluxe | Room Status: Occupied | Hygiene Status: Dirty | Device Status: Harmed"; //add \n
        //Assert.assertEquals(expectedOutput, outputStream.toString().trim());
    }
 
    @Test
    public void HotelTest_testListGuests() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Capture the output of the listGuests method
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        hotel.listGuests();
        String expectedOutput = "Guest Name: Andy | Guest PassportID: ABC12345\n"
                + "Guest Name: Bob | Guest PassportID: DEF12345";
        //Assert.assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void HotelTest_testFindRoom() {
    	
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Find an existing room
        Room foundRoom = hotel.findRoom("101");

        // Assert that the found room is not null and has the correct room number
        Assert.assertNotNull(foundRoom);
        Assert.assertEquals("101", foundRoom.getRoomNumber());
    }

    @Test
    public void testFindRoom_NoThisRoomNumber_RoomNotFound() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Find a non-existing room
        Room foundRoom = hotel.findRoom("701");

        // Assert that the found room is null
        Assert.assertNull(foundRoom);
    }
    //******************************************************************************************************************************
    @Test
    public void testFindRoomByRoomType_RoomisOk() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), new CleanStatus());
    	//room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), new OccupiedStatus());
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNotNull(foundRoom);
    }
    @Test
    public void testFindRoomByRoomType_RoomNotFound() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), new HarmedStatus());
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), new CleanStatus());
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), new OccupiedStatus());
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }
    
    @Test
    public void testFindRoomByRoomType_RoomNotFound2() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }
    
    @Test
    public void testFindRoomByRoomType_RoomNotFound3() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        //room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }

    @Test
    public void testFindRoomByRoomType_RoomNotFound4() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        //room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }
    @Test
    public void testFindRoomByRoomType_RoomNotFound5() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	//room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }

    @Test
    public void testFindRoomByRoomType_RoomNotFound6() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        //room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        //room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }

    @Test
    public void testFindRoomByRoomType_RoomNotFound7() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        //room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	//room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }
    
    @Test
    public void testFindRoomByRoomType_RoomNotFound8() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), new CleanStatus());
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Queen", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }
    
    @Test
    public void testFindRoomByRoomType_RoomNotFound9() {
    	Hotel hotel = Hotel.getInstance();
    	Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        room.changeDeviceStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        room.changeHygieneStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
    	room.changeRoomStatus(LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), null);
        // Find a room with the specified room type and availability
        Room foundRoom = hotel.findRoomByRoomType("Business", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6));
        Assert.assertNull(foundRoom);
    }

    @Test
    public void testFindGuest_ExistingPassportID_GuestFound() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Find an existing guest
        Guest foundGuest = hotel.findGuest("ABC12345");

        // Assert that the found guest is not null and has the correct passport ID
        Assert.assertNotNull(foundGuest);
        Assert.assertEquals("ABC12345", foundGuest.getPassportID());
    }

    @Test
    public void testFindGuest_NonExistingPassportID_GuestNotFound() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Find a non-existing guest
        Guest foundGuest = hotel.findGuest("EFD78901");

        // Assert that the found guest is null
        Assert.assertNull(foundGuest);
    }

    @Test
    public void testAddRoom_NewRoom_RoomAdded() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Create a new room
    	RoomType rt = new DoubleType();
        Room newRoom = new Room("301", rt);

        // Add the new room to the hotel
        hotel.addRoom(newRoom);

        // Get all rooms from the hotel
        ArrayList<Room> allRooms = hotel.getAllRooms();

        // Assert that the new room is in the list of all rooms
        Assert.assertTrue(allRooms.contains(newRoom));
    }

    @Test
    public void testRemoveRoom_ExistingRoom_RoomRemoved() {
    	Hotel hotel = Hotel.getInstance();
    	Room room1 = new Room("101", new QueenType());
    	Room room2 = new Room("201", new DeluxeType());
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Remove an existing room from the hotel
        hotel.removeRoom(room1);

        // Get all rooms from the hotel
        ArrayList<Room> allRooms = hotel.getAllRooms();

        // Assert that the removed room is not in the list of all rooms
        Assert.assertFalse(allRooms.contains(room1));
    }

    @Test
    public void testAddGuest_NewGuest_GuestAdded() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Create a new guest
        Guest newGuest = new Guest();
        newGuest.setBooking("Alice Johnson", "EF789012", LocalDate.of(2023, 3, 1),
                LocalDate.of(2023, 3, 2), LocalDate.of(2023, 3, 5), "1234567890", "301");

        // Add the new guest to the hotel
        hotel.addGuest(newGuest);

        // Get all guests from the hotel
        ArrayList<Guest> allGuests = hotel.getAllGuests();

        // Assert that the new guest is in the list of all guests
        Assert.assertTrue(allGuests.contains(newGuest));
    }

    @Test
    public void testRemoveGuest_ExistingGuest_GuestRemoved() {
    	Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Create some guests
        Guest guest1 = new Guest();
        guest1.setBooking("Andy", "ABC12345", LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 6), "1234567890", "101");

        Guest guest2 = new Guest();
        guest2.setCheckInDirectly("Bob", "DEF12345", LocalDate.of(2023, 8, 3), LocalDate.of(2023, 8, 5), "9876543210", "201");

        // Add guests to the hotel
        hotel.addGuest(guest1);
        hotel.addGuest(guest2);
        // Remove an existing guest from the hotel
        hotel.removeGuest(guest1);

        // Get all guests from the hotel
        ArrayList<Guest> allGuests = hotel.getAllGuests();

        // Assert that the removed guest is not in the list of all guests
        Assert.assertFalse(allGuests.contains(guest1));
    }
}
