package testCase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import project.*;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CmdListRoomsTest {
	@Test
	void test_01() {
		
        Hotel hotel = Hotel.getInstance();
       
        String str[]= {"ListRooms","2023-12-12"};
        
        CmdListRooms cmd = new CmdListRooms();
        
        
        ByteArrayOutputStream message = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(message));

        // 调用你的方法
        cmd.execute(str);
        System.setOut(originalOut); // 将System.out设置回原来的流
        String expected = "";
        String output = message.toString();
        
        System.out.println("Actual output: " +output);
        assertEquals(expected, output);
        
}
	@Test
	void test_02() {
		Room room = new Room("123", new DeluxeType());
        Hotel hotel = Hotel.getInstance();
        hotel.addRoom(room);
        String str[]= {"ListRooms","2023-12-12"};
        
        CmdListRooms cmd = new CmdListRooms();
        
        
        ByteArrayOutputStream message = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(message));

        // 调用你的方法
        cmd.execute(str);
        System.setOut(originalOut); // 将System.out设置回原来的流
        String expected = "Room Number: 123 | Room Type: Deluxe | Room Status: Available | Hygiene Status: Dirty | Device Status: Ordinary\n";
        String output = message.toString();
       
        System.out.println("Actual output: " +output);
        assertEquals(expected, output);
        
}
	
}
