package testCase;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import project.*;

import static org.junit.Assert.assertEquals;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
public class CmdCheckOutTest{
		 @Test
		 public void testExecute1() {
			 CmdCheckOut situation = new CmdCheckOut();
			 Room room = new Room("101",new DeluxeType());
			 Hotel hotel = Hotel.getInstance();
			 hotel.addRoom(room);
			 String[] str= {"checkOut","asdasd","101","2023-12-15"};
	         situation.execute(str);
	       ByteArrayOutputStream message = new ByteArrayOutputStream();			     
	       System.setOut(new PrintStream(message));
	       (new CmdCheckOut()).execute(str);
	       Assert.assertEquals("Sorry, this person does not exist.\n", message.toString());
	
	       
		 }
		 @Test
		 public void testExecute2() {
			 CmdCheckOut situation = new CmdCheckOut();
			 Room room = new Room("102",new DeluxeType());
			 Hotel hotel = Hotel.getInstance();
			 hotel.addRoom(room);
			 Guest guest2 = new Guest();
			 hotel.addGuest(guest2);
			 guest2.setBooking("John", "abcd", LocalDate.of(2023, 12, 5), LocalDate.of(2023, 12, 8), LocalDate.of(2023, 12, 15), "104", "102");
			 String[] str= {"checkOut","abcd","104","2023-12-15"};
			 ByteArrayInputStream inputStream = new ByteArrayInputStream("Y".getBytes());
		     System.setIn(inputStream);
			 
	         situation.execute(str);
	       ByteArrayOutputStream message = new ByteArrayOutputStream();			     
	       System.setOut(new PrintStream(message));
	       (new CmdCheckOut()).execute(str);
	       System.out.println(message.toString());
	       Assert.assertEquals("Check out successfully!", message.toString());
	     
	       
		 }
		 @Test
		 public void testExecute3() {
			 CmdCheckOut situation = new CmdCheckOut();
			 Room room = new Room("103",new DeluxeType());
			 Hotel hotel = Hotel.getInstance();
			 hotel.addRoom(room);
			 Guest guest2 = new Guest();
			 hotel.addGuest(guest2);
			 guest2.setBooking("John", "abce", LocalDate.of(2023, 12, 5), LocalDate.of(2023, 12, 20), LocalDate.of(2023, 12, 29), "105", "103");
			 String[] str= {"checkOut","abce","105","2023-12-23"};
			 ByteArrayInputStream inputStream = new ByteArrayInputStream("Y".getBytes());
		     System.setIn(inputStream);
			 
			 situation.execute(str);
	       ByteArrayOutputStream message = new ByteArrayOutputStream();			     
	       System.setOut(new PrintStream(message));
	       (new CmdCheckOut()).execute(str);
	       Assert.assertEquals("Since you checked out early, we will give you a partial refund based on your actual check-out date. You will be refunded: 450.0 dollars. \n ", message.toString());
	       }

}


