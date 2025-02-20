package testCase;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import project.*;

public class RoomTypeTest {

    @Test
    public void testStandardType() {
        RoomType roomType = new StandardType();
        assertEquals("Standard", roomType.getType());
        assertEquals(100.0, roomType.getPrice(), 0.001);
        
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("501", new StandardType()));
        
        guest1.setBooking("John", "ABC12345", LocalDate.of(2023, 7, 11), LocalDate.of(2023, 8, 22), LocalDate.of(2023, 8, 23), "1234567890", "501");
        guest2.setCheckInDirectly("Andy", "DEF12345", LocalDate.of(2023, 7, 15), LocalDate.of(2023, 7, 17), "0987654321", "501");
        roomType.addGuest(guest1);
        roomType.addGuest(guest2);
        ArrayList<Guest> guests = roomType.getGuests();
        assertEquals(2, guests.size());
        assertEquals("John", guests.get(0).getName());
        assertEquals("Andy", guests.get(1).getName());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roomType.listGuestsByRoomType();

        System.setOut(System.out);
        
        String output1 = "Guest Name: " + "John"+ " | Guest PassportID: " + "ABC12345" 
        + " | Guest PhoneNumber: " + "1234567890" + " | Guest Day Stay: " + guest1.getDayStay() + " | Guest Need To Pay: " + guest1.getFee() + "\n";
        
        String output2 = "Guest Name: " + "Andy"+ " | Guest PassportID: " + "DEF12345" 
        + " | Guest PhoneNumber: " + "0987654321" + " | Guest Day Stay: " + guest2.getDayStay() + " | Guest Need To Pay: " + guest2.getFee() + "\n";
        
        //assertEquals(output1 + output2, outputStream.toString());
        
    }

    @Test
    public void testQueenType() {
        RoomType roomType = new QueenType();
        assertEquals("Queen", roomType.getType());
        assertEquals(800.0, roomType.getPrice(), 0.001);
        
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        
        guest1.setBooking("John", "ABC12345", LocalDate.of(2023, 5, 11), LocalDate.of(2023, 7, 22), LocalDate.of(2023, 7, 23), "1234567890", "101");
        guest2.setCheckInDirectly("Andy", "DEF12345", LocalDate.of(2023, 9, 15), LocalDate.of(2023, 9, 17), "0987654321", "101");
        roomType.addGuest(guest1);
        roomType.addGuest(guest2);
        ArrayList<Guest> guests = roomType.getGuests();
        assertEquals(2, guests.size());
        assertEquals("John", guests.get(0).getName());
        assertEquals("Andy", guests.get(1).getName());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roomType.listGuestsByRoomType();

        System.setOut(System.out);
        
        String output1 = "Guest Name: " + "John"+ " | Guest PassportID: " + "ABC12345" 
        + " | Guest PhoneNumber: " + "1234567890" + " | Guest Day Stay: " + guest1.getDayStay() + " | Guest Need To Pay: " + guest1.getFee() + "\n";
        
        String output2 = "Guest Name: " + "Andy"+ " | Guest PassportID: " + "DEF12345" 
        + " | Guest PhoneNumber: " + "0987654321" + " | Guest Day Stay: " + guest2.getDayStay() + " | Guest Need To Pay: " + guest2.getFee() + "\n";
        
        //assertEquals(output1 + output2, outputStream.toString());
    }

    @Test
    public void testFamilyType() {
        RoomType roomType = new FamilyType();
        assertEquals("Family", roomType.getType());
        assertEquals(300.0, roomType.getPrice(), 0.001);
        
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("401", new FamilyType()));
        
        guest1.setBooking("John", "ABC12345", LocalDate.of(2023, 6, 21), LocalDate.of(2023, 6, 22), LocalDate.of(2023, 6, 23), "1234567890", "401");
        guest2.setCheckInDirectly("Andy", "DEF12345", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 3), "0987654321", "401");
        roomType.addGuest(guest1);
        roomType.addGuest(guest2);
        ArrayList<Guest> guests = roomType.getGuests();
        assertEquals(2, guests.size());
        assertEquals("John", guests.get(0).getName());
        assertEquals("Andy", guests.get(1).getName());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roomType.listGuestsByRoomType();

        System.setOut(System.out);
        
        String output1 = "Guest Name: " + "John"+ " | Guest PassportID: " + "ABC12345" 
        + " | Guest PhoneNumber: " + "1234567890" + " | Guest Day Stay: " + guest1.getDayStay() + " | Guest Need To Pay: " + guest1.getFee() + "\n";
        
        String output2 = "Guest Name: " + "Andy"+ " | Guest PassportID: " + "DEF12345" 
        + " | Guest PhoneNumber: " + "0987654321" + " | Guest Day Stay: " + guest2.getDayStay() + " | Guest Need To Pay: " + guest2.getFee() + "\n";
        
        //assertEquals(output1 + output2, outputStream.toString());
    }
    
    @Test
    public void testDoubleType() {
        RoomType roomType = new DoubleType();
        assertEquals("Double", roomType.getType());
        assertEquals(200.0, roomType.getPrice(), 0.01);
        
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("301", new DoubleType()));
        
        guest1.setBooking("John", "ABC12345", LocalDate.of(2023, 4, 11), LocalDate.of(2023, 4, 22), LocalDate.of(2023, 4, 23), "1234567890", "301");
        guest2.setCheckInDirectly("Andy", "DEF12345", LocalDate.of(2023, 9, 10), LocalDate.of(2023, 9, 12), "0987654321", "301");
        roomType.addGuest(guest1);
        roomType.addGuest(guest2);
        ArrayList<Guest> guests = roomType.getGuests();
        assertEquals(2, guests.size());
        assertEquals("John", guests.get(0).getName());
        assertEquals("Andy", guests.get(1).getName());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roomType.listGuestsByRoomType();

        System.setOut(System.out);
        
        String output1 = "Guest Name: " + "John"+ " | Guest PassportID: " + "ABC12345" 
        + " | Guest PhoneNumber: " + "1234567890" + " | Guest Day Stay: " + guest1.getDayStay() + " | Guest Need To Pay: " + guest1.getFee() + "\n";
        
        String output2 = "Guest Name: " + "Andy"+ " | Guest PassportID: " + "DEF12345" 
        + " | Guest PhoneNumber: " + "0987654321" + " | Guest Day Stay: " + guest2.getDayStay() + " | Guest Need To Pay: " + guest2.getFee() + "\n";
        
        //assertEquals(output1 + output2, outputStream.toString());
    }
    
    @Test
    public void testDeluxeType() {
        RoomType roomType = new DeluxeType();
        assertEquals("Deluxe", roomType.getType());
        assertEquals(500.0, roomType.getPrice(), 0.001);
        
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("201", new DeluxeType()));
        
        guest1.setBooking("John", "ABC12345", LocalDate.of(2023, 5, 11), LocalDate.of(2023, 5, 14), LocalDate.of(2023, 5, 15), "1234567890", "201");
        guest2.setCheckInDirectly("Andy", "DEF12345", LocalDate.of(2023, 9, 6), LocalDate.of(2023, 9, 7), "0987654321", "201");
        roomType.addGuest(guest1);
        roomType.addGuest(guest2);
        ArrayList<Guest> guests = roomType.getGuests();
        assertEquals(2, guests.size());
        assertEquals("John", guests.get(0).getName());
        assertEquals("Andy", guests.get(1).getName());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roomType.listGuestsByRoomType();

        System.setOut(System.out);
        
        String output1 = "Guest Name: " + "John"+ " | Guest PassportID: " + "ABC12345" 
        + " | Guest PhoneNumber: " + "1234567890" + " | Guest Day Stay: " + guest1.getDayStay() + " | Guest Need To Pay: " + guest1.getFee() + "\n";
        
        String output2 = "Guest Name: " + "Andy"+ " | Guest PassportID: " + "DEF12345" 
        + " | Guest PhoneNumber: " + "0987654321" + " | Guest Day Stay: " + guest2.getDayStay() + " | Guest Need To Pay: " + guest2.getFee() + "\n";
        
        //assertEquals(output1 + output2, outputStream.toString()); 
    }
    
    @Test
    public void testBusinessType() {
        RoomType roomType = new BusinessType();
        assertEquals("Business", roomType.getType());
        assertEquals(150.0, roomType.getPrice(), 0.01);
        
        Guest guest1 = new Guest();
        Guest guest2 = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("601", new BusinessType()));
        
        guest1.setBooking("John", "ABC12345", LocalDate.of(2023, 10, 11), LocalDate.of(2023, 10, 22), LocalDate.of(2023, 10, 23), "1234567890", "601");
        guest2.setCheckInDirectly("Andy", "DEF12345", LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 17), "0987654321", "601");
        roomType.addGuest(guest1);
        roomType.addGuest(guest2);
        ArrayList<Guest> guests = roomType.getGuests();
        assertEquals(2, guests.size());
        assertEquals("John", guests.get(0).getName());
        assertEquals("Andy", guests.get(1).getName());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roomType.listGuestsByRoomType();

        System.setOut(System.out);
        
        String output1 = "Guest Name: " + "John"+ " | Guest PassportID: " + "ABC12345" 
        + " | Guest PhoneNumber: " + "1234567890" + " | Guest Day Stay: " + guest1.getDayStay() + " | Guest Need To Pay: " + guest1.getFee() + "\n";
        
        String output2 = "Guest Name: " + "Andy"+ " | Guest PassportID: " + "DEF12345" 
        + " | Guest PhoneNumber: " + "0987654321" + " | Guest Day Stay: " + guest2.getDayStay() + " | Guest Need To Pay: " + guest2.getFee() + "\n";
        
        //assertEquals(output1 + output2, outputStream.toString());
    }
}
