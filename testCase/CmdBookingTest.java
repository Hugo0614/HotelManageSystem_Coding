package testCase;
import project.*;
import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CmdBookingTest{

	@Test
	public void testBooking1() {
		 CmdCheckOut situation = new CmdCheckOut();
		 Room room = new Room("101",new DeluxeType());
		 Hotel hotel = Hotel.getInstance();
		 hotel.addRoom(room);
		 ByteArrayOutputStream message = new ByteArrayOutputStream();
         System.setOut(new PrintStream(message));
		 String[] str = {"booking" , "asdasd" , "leon", "2023-11-05","Queen","2023-12-15","2023-12-20","12345678"}; 

	 }
	@Test
	public void testBooking2() {
		 CmdCheckOut situation = new CmdCheckOut();
		 Room room = new Room("102",new DeluxeType());
		 Hotel hotel = Hotel.getInstance();
		 hotel.addRoom(room);
		 room.changeHygieneStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new CleanStatus());

		 String[] str = {"booking" , "asdasd1" , "leon", "2023-11-05","Deluxe","2023-12-15","2023-12-20","12345678"};

		 (new CmdBooking()).execute(str);


	 }
	@Test
	public void testBooking3() {
		 CmdCheckOut situation = new CmdCheckOut();
		 Room room = new Room("103",new DeluxeType());
		 Hotel hotel = Hotel.getInstance();
		 hotel.addRoom(room);
		 
		 room.changeHygieneStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new CleanStatus());

		 String[] str = {"booking" , "asdasd2" , "leon", "2023-11-05","Deluxe","2023-12-15","2023-12-20","12345678"};
		 String[] str2 = {"booking" , "asdasd2" , "leon", "2023-11-05","Deluxe","2023-12-15","2023-12-20","12345678"};

		 (new CmdBooking()).execute(str);
		 (new CmdBooking()).execute(str2);
		 Assert.assertEquals("", 0);

	 }
	@Test
	public void testBooking4() {
		 CmdCheckOut situation = new CmdCheckOut();
		 Room room = new Room("104",new DeluxeType());
		 Hotel hotel = Hotel.getInstance();
		 hotel.addRoom(room);
		 
		 room.changeHygieneStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new CleanStatus());

		 String[] str = {"booking" , "asdasd3" , "leon", "2023-12-15","Deluxe","2023-12-15","2023-12-20","12345678"};


		 (new CmdBooking()).execute(str);

	 }
	@Test
	public void testBooking5() {
		 CmdCheckOut situation = new CmdCheckOut();
		 Room room = new Room("105",new DeluxeType());
		 Hotel hotel = Hotel.getInstance();
		 hotel.addRoom(room);
		 
		 room.changeRoomStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , null);
		 room.changeHygieneStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new DirtyStatus());
		 room.changeDeviceStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new HarmedStatus());
		 String[] str = {"booking" , "asdasd4" , "leon", "2023-11-05","Deluxe","2023-12-11","2023-12-30","12345678"};

		 (new CmdBooking()).execute(str);


	 }
	
	@Test
	public void testBooking6() {
		 CmdCheckOut situation = new CmdCheckOut();
		 Room room = new Room("106",new DeluxeType());
		 Hotel hotel = Hotel.getInstance();
		 hotel.addRoom(room);
		 
		 room.changeRoomStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , null);
//		 room.changeHygieneStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new DirtyStatus());
		 room.changeDeviceStatus(LocalDate.of(2023, 12, 10),LocalDate.of(2023, 12, 30) , new HarmedStatus());
		 String[] str = {"booking" , "asdasd5" , "leon", "2023-11-05","Deluxe","2023-12-11","2023-12-30","12345678"};

		 (new CmdBooking()).execute(str);


	 }
	




	
	
	
	
	
	
	
	
	
	
	


}
