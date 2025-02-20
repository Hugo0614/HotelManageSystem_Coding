package testCase;                //write list() test case?

import org.junit.Assert;
import org.junit.Test;

import project.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class GuestTest {

    @Test
    public void GuestTest_testSetBooking(){
        // Create a guest object
        Guest guest = new Guest();

        // Set booking details
        String name = "Andy";
        String passportID = "ABC12345";
        LocalDate bookingDate = LocalDate.of(2023, 8, 1);
        LocalDate checkInDate = LocalDate.of(2023, 8, 4);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 7);
        String phone = "1234567890";
        String roomNumber = "101";
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        // Set the booking details for the guest
        guest.setBooking(name, passportID, bookingDate, checkInDate, checkOutDate, phone, roomNumber);
        
        Assert.assertEquals(name, guest.getName());
        Assert.assertEquals(passportID, guest.getPassportID());
        Assert.assertEquals(checkOutDate, guest.getCheckOutDate());
        Assert.assertEquals(roomNumber, guest.getRoomNumber());
        // Assert that the calculated fee is correct
        double expectedFee = 2040.0;// 1 * 0.7 * 800.0 + 1 * 0.85 * 800.0 + 1 * 800.0;  //560+680+800=2040
        double outputFee = guest.getFee();
        //Assert.assertEquals(expectedFee, outputFee, 0.01);

        // Assert that the calculated day stay is correct
        long expectedDayStay = 3;
        long outputDayStay = guest.getDayStay();
        //Assert.assertEquals(expectedDayStay, outputDayStay);
    }

    @Test
    public void GuestTest_testSetCheckInDirectly() {
        // Create a guest object
        Guest guest = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("201", new DeluxeType()));
        
        // Set check-in directly details
        String name = "Andy";
        String passportID = "ABC12345";
        LocalDate checkInDate = LocalDate.of(2023, 8, 10);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 13);
        String phone = "1234567890";
        String roomNumber = "201";

        // Set the check-in directly details for the guest
        guest.setCheckInDirectly(name, passportID, checkInDate, checkOutDate, phone, roomNumber);
        Assert.assertEquals(name, guest.getName());
        Assert.assertEquals(passportID, guest.getPassportID());
        Assert.assertEquals(checkOutDate, guest.getCheckOutDate());
        Assert.assertEquals(roomNumber, guest.getRoomNumber());
        // Assert that the calculated fee is correct
        double expectedFee = 3 * 500;    //1500
        Assert.assertEquals(expectedFee, guest.getFee(), 0.00001);

        // Assert that the calculated day stay is correct
        long expectedDayStay = 3;
        Assert.assertEquals(expectedDayStay, guest.getDayStay());
    }

    // Add more test cases as needed for other methods in the Guest class

    @Test
    public void GuestTest_testSelfDcl_1() {
        // Create a guest object
        Guest guest = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("101", new QueenType()));
        // Set guest details
        String name = "Andy";
        String passportID = "ABC12345";
        LocalDate bookingDate = LocalDate.of(2023, 8, 1);
        LocalDate checkInDate = LocalDate.of(2023, 8, 4);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 7);
        String phone = "1234567890";
        String roomNumber = "101";
        guest.setBooking(name, passportID, bookingDate, checkInDate, checkOutDate, phone, roomNumber);

        // Print guest details using selfDcl method and capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        guest.selfDcl();
        String expectedOutput = "Guest Name: Andy | Guest PassportID: ABC12345 | Guest PhoneNumber: 1234567890 | Guest Day Stay: 3 | Guest Need To Pay: 2040.0";
        //Assert.assertEquals(expectedOutput, outputStream.toString().trim());
    }
    
    @Test
    public void GuestTest_testSelfDcl_2() {
        // Create a guest object
        Guest guest = new Guest();
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(new Room("201", new DeluxeType()));
        // Set guest details
        String name = "Andy";
        String passportID = "ABC12345";
        LocalDate checkInDate = LocalDate.of(2023, 8, 10);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 13);
        String phone = "1234567890";
        String roomNumber = "201";
        guest.setCheckInDirectly(name, passportID, checkInDate, checkOutDate, phone, roomNumber);

        // Print guest details using selfDcl method and capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        guest.selfDcl();
        String expectedOutput = "Guest Name: Andy | Guest PassportID: ABC12345 | Guest PhoneNumber: 1234567890 | Guest Day Stay: 3 | Guest Need To Pay: 1500.0";
        Assert.assertEquals(expectedOutput, outputStream.toString().trim());
    }
    
    @Test
    public void GuestTest_testList() { 
    	Guest guest = new Guest();
        Hotel hotel = Hotel.getInstance();
        Room room = new Room("101", new QueenType());
        hotel.addRoom(room);
        // Set guest details
        String name = "Andy";
        String passportID = "ABC12345";
        LocalDate bookingDate = LocalDate.of(2023, 8, 1);
        LocalDate checkInDate = LocalDate.of(2023, 8, 4);
        LocalDate checkOutDate = LocalDate.of(2023, 8, 7);
        String phone = "1234567890";
        String roomNumber = "101";
//        guest.setBooking(name, passportID, bookingDate, checkInDate, checkOutDate, phone, roomNumber);
        guest.setCheckInDirectly(name, passportID, checkInDate, checkOutDate, phone, roomNumber);
        hotel.addGuest(guest);
        room.getRoomType().addGuest(guest);
        
        ArrayList<Guest> guestList =  hotel.getAllGuests();
        guest.list(guestList);
        
    }
    
    
}
