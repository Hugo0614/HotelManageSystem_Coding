package testCase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import project.Room;
import project.*;
import project.DeluxeType;
import project.CmdCleanRequest;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


class CmdRepairResponseTest {

	@Test
	void testY() {
		Room room = new Room("123", new DeluxeType());
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(room);
        
        CmdRepairRequest cmd = new CmdRepairRequest();
        String[] cmdParts = {"repairRequest", "123", "2023-01-01"};
        
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
	void testNotDirty() {
	    Room room = new Room("133", new DeluxeType()); 
	    Hotel hotel = Hotel.getInstance();
	    hotel.addRoom(room);
	    room.changeHygieneStatus(LocalDate.of(2023, 01, 01),LocalDate.of(2023, 01, 01), new CleanStatus());

	    CmdRepairRequest cmd = new CmdRepairRequest();
	    String[] cmdParts = {"repairRequest", "133", "2023-01-01"};

	    ByteArrayInputStream inputStream = new ByteArrayInputStream("Y".getBytes());
	    System.setIn(inputStream);

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(outputStream);
	    PrintStream originalOut = System.out;
	    System.setOut(printStream);

	    cmd.execute(cmdParts);

	    System.out.flush();
	    System.setOut(originalOut);

	    String expectedOutput = "Room 133 has been impeccably repaired.";
	    assertEquals(expectedOutput, getConsoleOutput(outputStream));
	}
	
	private String getConsoleOutput(ByteArrayOutputStream outputStream) {
	    String[] lines = outputStream.toString().split(System.lineSeparator());
	    return lines[lines.length - 1].trim();
	}

}
