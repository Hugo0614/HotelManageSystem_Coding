package project;

import java.util.ArrayList;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Guest {

	private String name;
	private String passportID;
	private LocalDate bookingDate;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private long dayStay;
	private String phone;
	private String roomNumber;
	private double fee;
	
	public Guest() {
		
	}
	
	private void calculateDatesAndFee(Room room) {
	    int saturdayCount = 0;
	    int sundayCount = 0;
	    int weekdayCount = 0;
	    LocalDate currentDate = checkInDate;

	    while (!currentDate.isAfter(checkOutDate)) {
	        if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
	            saturdayCount++;
	        } else if (currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
	            sundayCount++;
	        } else {
	            weekdayCount++;
	        }
	        currentDate = currentDate.plusDays(1);
	    }

	    double weekdayPrice = room.getRoomType().getPrice() * 0.7;
	    double saturdayPrice = room.getRoomType().getPrice() * 0.85;
	    double sundayPrice = room.getRoomType().getPrice();

	    fee = (weekdayPrice * weekdayCount) + (saturdayPrice * saturdayCount) + (sundayPrice * sundayCount);
	    dayStay = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
	}
	
	public void setBooking(String n, String pID, LocalDate bdate, LocalDate cidate, LocalDate codate, String ph, String roomNum) {
	    name = n;
	    passportID = pID;
	    bookingDate = bdate;
	    checkInDate = cidate;
	    checkOutDate = codate;
	    roomNumber = roomNum;
	    phone = ph;

	    Hotel hotel = Hotel.getInstance();
	    Room r = hotel.findRoom(roomNumber);
	    calculateDatesAndFee(r);
	}
	
	public void setCheckInDirectly(String n, String pID, LocalDate cidate, LocalDate codate, String ph, String roomNum) {
		name = n;
		passportID = pID;
		bookingDate = null;
		checkInDate = cidate;
		checkOutDate = codate;
		roomNumber = roomNum;
		phone = ph;
		Hotel hotel = Hotel.getInstance();
		dayStay = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
		Room r;
        r = hotel.findRoom(roomNum);
        fee = r.getRoomType().getPrice()*dayStay;
	}
			
	public double getFee() {             //Hugo Change
		return fee;
	}
	public long getDayStay() {            //Hugo Change
		return dayStay;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassportID() {
		return passportID;
	}
	
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public static void list(ArrayList<Guest> allGuests)
    {
        for (Guest g : allGuests)
            System.out.println("Guest Name: " + g.name+ " | Guest PassportID: " + g.passportID + " | Guest PhoneNumber: " + g.phone + " | Guest Day Stay: " + g.dayStay + " | Guest Need To Pay: " + g.fee); 
    }
	
	public void selfDcl() {
		System.out.println("Guest Name: " + this.name+ " | Guest PassportID: " + this.passportID + " | Guest PhoneNumber: " + this.phone + " | Guest Day Stay: " + this.dayStay + " | Guest Need To Pay: " + this.fee); 
	}
}
