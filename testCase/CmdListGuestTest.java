package testCase;  //need to change 

import org.junit.Assert;
import org.junit.Test;

import project.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class CmdListGuestTest {

    @Test
    public void casea() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void caseb() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "Business"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casec() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "Double"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void cased() {
    	// Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "Deluxe"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casee() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "Family"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casef() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "Standard"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void caseg() {
    	// Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "Queen"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void caseh() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        Hotel hotel = Hotel.getInstance();
        String[] cmdParts1 = {"addRoom", "101", "Business"};
        String[] cmdParts_ = {"cleanReponse", "101", "2023-11-04"};
        String[] cmdParts2 = {"booking", "asdasd1", "leon", "2023-11-05", "Business", "2023-12-15", "2023-12-20","12345678"};
        String[] cmdParts = {"listGuests", "Business"};
        // Act and Assert
        (new CmdAddRoom()).execute(cmdParts1);
        (new CmdCleanResponse()).execute(cmdParts_);
        (new CmdBooking()).execute(cmdParts2);
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casei() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        Hotel hotel = Hotel.getInstance();
        String[] cmdParts1 = {"addRoom", "102", "Double"};
        String[] cmdParts_ = {"cleanReponse", "102", "2023-11-04"};
        String[] cmdParts2 = {"booking", "asdasd2", "leon", "2023-11-05", "Double", "2023-12-15", "2023-12-20","12345678"};
        String[] cmdParts = {"listGuests", "Double"};
        // Act and Assert
        (new CmdAddRoom()).execute(cmdParts1);
        (new CmdCleanResponse()).execute(cmdParts_);
        (new CmdBooking()).execute(cmdParts2);
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casej() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        Hotel hotel = Hotel.getInstance();
        String[] cmdParts1 = {"addRoom", "103", "Deluxe"};
        String[] cmdParts_ = {"cleanReponse", "103", "2023-11-04"};
        String[] cmdParts2 = {"booking", "asdasd3", "leon", "2023-11-05", "Deluxe", "2023-12-15", "2023-12-20","12345678"};
        String[] cmdParts = {"listGuests", "Deluxe"};
        // Act and Assert
        (new CmdAddRoom()).execute(cmdParts1);
        (new CmdCleanResponse()).execute(cmdParts_);
        (new CmdBooking()).execute(cmdParts2);
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casek() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        Hotel hotel = Hotel.getInstance();
        String[] cmdParts1 = {"addRoom", "104", "Family"};
        String[] cmdParts_ = {"cleanReponse", "104", "2023-11-04"};
        String[] cmdParts2 = {"booking", "asdasd4", "leon", "2023-11-05", "Family", "2023-12-15", "2023-12-20","12345678"};
        String[] cmdParts = {"listGuests", "Family"};
        // Act and Assert
        (new CmdAddRoom()).execute(cmdParts1);
        (new CmdCleanResponse()).execute(cmdParts_);
        (new CmdBooking()).execute(cmdParts2);
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casel() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        Hotel hotel = Hotel.getInstance();
        String[] cmdParts1 = {"addRoom", "105", "Standard"};
        String[] cmdParts_ = {"cleanReponse", "105", "2023-11-04"};
        String[] cmdParts2 = {"booking", "asdasd5", "leon", "2023-11-05", "Standard", "2023-12-15", "2023-12-20","12345678"};
        String[] cmdParts = {"listGuests", "Standard"};
        // Act and Assert
        (new CmdAddRoom()).execute(cmdParts1);
        (new CmdCleanResponse()).execute(cmdParts_);
        (new CmdBooking()).execute(cmdParts2);
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casem() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        Hotel hotel = Hotel.getInstance();
        String[] cmdParts1 = {"addRoom", "106", "Queen"};
        String[] cmdParts_ = {"cleanReponse", "106", "2023-11-04"};
        String[] cmdParts2 = {"booking", "asdasd6", "leon", "2023-11-05", "Queen", "2023-12-15", "2023-12-20","12345678"};
        String[] cmdParts = {"listGuests", "Queen"};
        // Act and Assert
        (new CmdAddRoom()).execute(cmdParts1);
        (new CmdCleanResponse()).execute(cmdParts_);
        (new CmdBooking()).execute(cmdParts2);
        (new CmdListGuests()).execute(cmdParts);
    }
    
    @Test
    public void casen() {
        // Arrange
        CmdListGuests cmdListGuests = new CmdListGuests();
        String[] cmdParts = {"ListGuests", "asdas"};
        Hotel hotel = Hotel.getInstance();
        // Act and Assert
        (new CmdListGuests()).execute(cmdParts);
    }
}