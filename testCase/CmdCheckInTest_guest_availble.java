package testCase;

import org.junit.Assert;
import org.junit.Test;

import project.AvailableStatus;
import project.CleanStatus;
import project.CmdAddRoom;
import project.CmdCheckIn;
import project.Hotel;
import project.OrdinaryStatus;
import project.Room;
import project.Guest;
import project.DirtyStatus;
import project.ExMultiRegistered;
import  project.HarmedStatus;
import  project.OccupiedStatus;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;

public class CmdCheckInTest_guest_availble {

    CmdAddRoom cmdAddRoom = new CmdAddRoom();
    CmdCheckIn cmdCheckIn = new CmdCheckIn();
    String guestName ="John";
    String guestPassportID = "A123456";
    String guestPhoneNumber = "12345678";
    LocalDate checkInDate = LocalDate.of(2023, 10, 10);
    LocalDate checkOutDate = LocalDate.of(2023, 10, 12);
    Hotel hotel = Hotel.getInstance();

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);

    //Test Where Room and Guest are both availble
    @Test
    public void CmdCheckIn_testExecute_checkedInSuccessfully() {
        String[] cmdParts_1 = {"addRoom", "301", "Queen"};
        cmdAddRoom.execute(cmdParts_1);
        Room roomInstance = hotel.findRoom("301");
        roomInstance.changeDeviceStatus(checkInDate, checkOutDate, new OrdinaryStatus());
        roomInstance.changeHygieneStatus(checkInDate, checkOutDate, new CleanStatus());
        roomInstance.changeRoomStatus(checkInDate,checkOutDate, new AvailableStatus());
        String[] cmdParts_2 = {"checkin",guestPassportID,guestName,"Queen","2023-10-10","2023-10-12",guestPhoneNumber};
        this.cmdCheckIn.execute(cmdParts_2);
        Guest guest = hotel.findGuest(guestPassportID);
        assertNotNull(guest);
        assertEquals(guestName,guest.getName());
        assertEquals(guestPassportID,guest.getPassportID());
        assertEquals(checkOutDate,guest.getCheckOutDate());
        assertEquals("301",guest.getRoomNumber());
    }

    @Test
    //Test where room are not availble()
    public void CmdCheckIn_testExecute_roomNotAvailble_roomDirty(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String[] cmdParts_1 = {"addRoom", "301", "Queen"};
        cmdAddRoom.execute(cmdParts_1);
        Room roomInstance = hotel.findRoom("301");
        roomInstance.changeDeviceStatus(checkInDate, checkOutDate, new OrdinaryStatus());
        roomInstance.changeHygieneStatus(checkInDate, checkOutDate, new DirtyStatus());
        roomInstance.changeRoomStatus(checkInDate,checkOutDate, new AvailableStatus());
        String[] cmdParts_2 = {"checkin",guestPassportID,guestName,"Queen","2023-10-10","2023-10-12",guestPhoneNumber};
        this.cmdCheckIn.execute(cmdParts_2);
        Guest guest = hotel.findGuest(guestPassportID);
        assertNull(guest);
        String expectedOutput = "Sorry, we don't have this type of rooms at all";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    //Test where room are not availble()
    public void CmdCheckIn_testExecute_roomNotAvailble_roomHarmed(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String[] cmdParts_1 = {"addRoom", "301", "Queen"};
        cmdAddRoom.execute(cmdParts_1);
        Room roomInstance = hotel.findRoom("301");
        roomInstance.changeDeviceStatus(checkInDate, checkOutDate, new HarmedStatus());
        roomInstance.changeHygieneStatus(checkInDate, checkOutDate, new CleanStatus());
        roomInstance.changeRoomStatus(checkInDate,checkOutDate, new AvailableStatus());
        String[] cmdParts_2 = {"checkin",guestPassportID,guestName,"Queen","2023-10-10","2023-10-12",guestPhoneNumber};
        this.cmdCheckIn.execute(cmdParts_2);
        Guest guest = hotel.findGuest(guestPassportID);
        assertNull(guest);
        String expectedOutput = "Sorry, we don't have this type of rooms at all";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    //Test where room are not availble()
    public void CmdCheckIn_testExecute_roomNotAvailble_roomOccupied(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String[] cmdParts_1 = {"addRoom", "301", "Queen"};
        cmdAddRoom.execute(cmdParts_1);
        Room roomInstance = hotel.findRoom("301");
        roomInstance.changeDeviceStatus(checkInDate, checkOutDate, new OrdinaryStatus());
        roomInstance.changeHygieneStatus(checkInDate, checkOutDate, new CleanStatus());
        roomInstance.changeRoomStatus(checkInDate,checkOutDate, new OccupiedStatus());
        String[] cmdParts_2 = {"checkin",guestPassportID,guestName,"Queen","2023-10-10","2023-10-12",guestPhoneNumber};
        this.cmdCheckIn.execute(cmdParts_2);
        Guest guest = hotel.findGuest(guestPassportID);
        assertNull(guest);
        String expectedOutput = "Sorry, we don't have this type of rooms at all";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
        //Test where the room is not availble but guest is availble
        


        
        public void CmdCheckIn_testExecute_guestNotAvailble(){

            String[] cmdParts_1 = {"addRoom", "301", "Queen"};
            cmdAddRoom.execute(cmdParts_1);

            String[] cmdParts_2 = {"addRoom", "404", "Queen"};
            cmdAddRoom.execute(cmdParts_2);
            String[] cmdParts_3 = {"checkin",guestPassportID,guestName,"Queen","2023-10-10","2023-10-12",guestPhoneNumber};
            this.cmdCheckIn.execute(cmdParts_3);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);
            String[] cmdParts_4 = {"checkin",guestPassportID,guestName,"Queen","2023-10-10","2023-10-12",guestPhoneNumber};
            this.cmdCheckIn.execute(cmdParts_4);
            Guest guest = hotel.findGuest(guestPassportID);

            String expectedOutput = "Sorry, every guest can only register once";
            assertEquals(expectedOutput, outputStream.toString().trim());
        }

        
        
    
}