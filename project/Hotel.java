package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Hotel{
	private ArrayList<Room> allRooms;
	private ArrayList<Guest> allGuests;
	private static Hotel instance = new Hotel();
	private Hotel() {
		allRooms = new ArrayList<Room>();
		allGuests = new ArrayList<Guest>();
	}
	public static Hotel getInstance() {return instance;}
	public void listRooms(LocalDate currentTime) {
		Room.list(allRooms,currentTime);
	}
	public void listGuests() {
		Guest.list(allGuests);
	}
	public Room findRoom(String roomNumber) {
		for (Room r: allRooms) {
			if (r.getRoomNumber().equals(roomNumber))
				return r;
		}
		return null;
	}

//	public Room findRoomByRoomType(String roomType, LocalDate checkInDate, LocalDate checkOutDate) {
//	    for (Room room : allRooms) {
//	        Map<LocalDate, RoomStatus> roomStatusMap = room.getRoomStatusMap();
//	        Map<LocalDate, HygieneStatus> hygieneStatusMap = room.getHygieneStatusMap();
//	        Map<LocalDate, DeviceStatus> deviceStatusMap = room.getDeviceStatusMap();
//	        
//	        boolean isRoomAvailable = true;
//	        boolean isRoomClean = true;
//	        boolean isRoomOrdinary = true;
//
//	        for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
//	            RoomStatus roomStatus = roomStatusMap.get(date);
//	            if (roomStatus == null || !roomStatus.getStatus().equals("Available")) {
//	                isRoomAvailable = false;
//	                break;
//	            }
//	        }
//
//	        for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
//	            HygieneStatus hygieneStatus = hygieneStatusMap.get(date);
//	            if (hygieneStatus == null || !hygieneStatus.getStatus().equals("Clean")) {
//	                isRoomClean = false;
//	                break;
//	            }
//	        }
//
//	        for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
//	            DeviceStatus deviceStatus = deviceStatusMap.get(date);
//	            if (deviceStatus == null || !deviceStatus.getStatus().equals("Ordinary")) {
//	                isRoomOrdinary = false;
//	                break;
//	            }
//	        }
//	        
//
//	        if (isRoomAvailable && isRoomClean && isRoomOrdinary && roomType.equals(room.getRoomType().getType())) {
//	            return room;
//	        }
//	    }
//
//	    return null;
//	}
	private boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
	    Map<LocalDate, RoomStatus> roomStatusMap = room.getRoomStatusMap();
	    for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
	        RoomStatus roomStatus = roomStatusMap.get(date);
	        if (roomStatus == null || !roomStatus.getStatus().equals("Available")) {
	            return false;
	        }
	    }
	    return true;
	}

	private boolean isRoomClean(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
	    Map<LocalDate, HygieneStatus> hygieneStatusMap = room.getHygieneStatusMap();
	    for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
	        HygieneStatus hygieneStatus = hygieneStatusMap.get(date);
	        if (hygieneStatus == null || !hygieneStatus.getStatus().equals("Clean")) {
	            return false;
	        }
	    }
	    return true;
	}

	private boolean isRoomOrdinary(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
	    Map<LocalDate, DeviceStatus> deviceStatusMap = room.getDeviceStatusMap();
	    for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
	        DeviceStatus deviceStatus = deviceStatusMap.get(date);
	        if (deviceStatus == null || !deviceStatus.getStatus().equals("Ordinary")) {
	            return false;
	        }
	    }
	    return true;
	}
	public Room findRoomByRoomType(String roomType, LocalDate checkInDate, LocalDate checkOutDate) {
	    for (Room room : allRooms) {
	        if (isRoomAvailable(room, checkInDate, checkOutDate) &&
	            isRoomClean(room, checkInDate, checkOutDate) &&
	            isRoomOrdinary(room, checkInDate, checkOutDate) &&
	            roomType.equals(room.getRoomType().getType())) {
	            return room;
	        }
	    }
	    return null;
	}
	public Guest findGuest(String passportID) {
		for (Guest g: allGuests) {
			if (g.getPassportID().equals(passportID))
				return g;
		}
		return null;
	}
	public void addRoom(Room r) {
		allRooms.add(r);
	}
	public void removeRoom(Room r) {
		allRooms.remove(r);
	}
	public void addGuest(Guest g) {
		allGuests.add(g);
	}
	public void removeGuest(Guest g) {
		allGuests.remove(g);
	}
	public ArrayList<Room> getAllRooms() {      //Hugo add
		// TODO Auto-generated method stub
		return allRooms;
	}
	public ArrayList<Guest> getAllGuests(){     //Hugo add
		return allGuests;
	}
	
}