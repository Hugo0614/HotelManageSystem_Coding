package testCase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import project.Room;
import project.Hotel;
import project.DeluxeType;
import project.CmdCleanRequest;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CmdCleanRequestTest {

	@Test
	void testN() {
		Room room = new Room("123", new DeluxeType());
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(room);
        
        CmdCleanRequest cmd = new CmdCleanRequest();
        String[] cmdParts = {"cleanRequest", "123", "2023-01-01"};
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream("N".getBytes());
        System.setIn(inputStream);

        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        
        cmd.execute(cmdParts);
        
        System.out.flush();
        System.setOut(originalOut);
        
        String expectedNotMaintaining = "> Then don't forget to clean Room 123 later.";
        assertEquals(expectedNotMaintaining, getConsoleOutput(outputStream));
        
	}
	
	@Test
	void testY() {
		Room room = new Room("123", new DeluxeType());
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(room);
        
        CmdCleanRequest cmd = new CmdCleanRequest();
        String[] cmdParts = {"cleanRequest", "123", "2023-01-01"};
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Y".getBytes());
        System.setIn(inputStream);

        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        
        cmd.execute(cmdParts);
        
        System.out.flush();
        System.setOut(originalOut);
        
        String expectedMaintaining = "Room 123 has been impeccably cleaned.";
        assertEquals(expectedMaintaining, getConsoleOutput(outputStream));
        
	}
	
	@Test
	void testG() {
		Room room = new Room("123", new DeluxeType());
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(room);
        
        CmdCleanRequest cmd = new CmdCleanRequest();
        String[] cmdParts = {"cleanRequest", "123", "2023-01-01"};
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream("A N".getBytes());
        System.setIn(inputStream);

        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        
        cmd.execute(cmdParts);
        
        System.out.flush();
        System.setOut(originalOut);
        String actualOutput = getGConsoleOutput(outputStream);
        //System.out.println("Actual output: " + actualOutput);
        System.out.println(outputStream.toString());
        String expectedOutput = "> Wrong Input! Please Try Again!";
        assertEquals(expectedOutput, getGConsoleOutput(outputStream));
        
	}
	
	private String getConsoleOutput(ByteArrayOutputStream outputStream) {
	    String[] lines = outputStream.toString().split(System.lineSeparator());
	    return lines[lines.length - 1].trim();
	}
	
	private String getGConsoleOutput(ByteArrayOutputStream outputStream) {
	    String[] lines = outputStream.toString().split(System.lineSeparator());
	    return lines[lines.length - 5].trim();
	}

}
