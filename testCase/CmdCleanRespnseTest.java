package testCase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import project.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CmdCleanResponseTest {

	@Test
	void test01() {
		Room room = new Room("123", new DeluxeType());
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(room);
        
        CmdCleanResponse cmd = new CmdCleanResponse();
        String[] cmdParts = {"cleanResponse", "123", "2023-01-01"};
        

        
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
	private String getConsoleOutput(ByteArrayOutputStream outputStream) {
	    String[] lines = outputStream.toString().split(System.lineSeparator());
	    return lines[lines.length -1].trim();
	}

	
}

