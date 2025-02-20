package project;

import java.time.*;
import java.util.Map;

public class CmdCheckIn implements Command{
    private Guest guest;

    @Override
    public void execute(String[] cmdParts) {
        checkInProcess(cmdParts);
    }

    private void checkInProcess(String[] cmdParts){
        Hotel hotel = Hotel.getInstance();
        LocalDate checkInDate = LocalDate.parse(cmdParts[4]);
        LocalDate checkOutDate = LocalDate.parse(cmdParts[5]);
        Room room = hotel.findRoomByRoomType(cmdParts[3], checkInDate, checkOutDate);

        try{
            if (isGuestAvailable(cmdParts[1], hotel)) {
                if (isRoomAvailable(room,checkInDate, checkOutDate)) {
                    bookRoom(room, cmdParts[2], cmdParts[1], checkInDate, checkOutDate, cmdParts[6], room.getRoomType().getType(), hotel);
                    System.out.println("Done.");
                } else {
                    throw new ExUnknownRoomType();
                }
            } else {
                throw new ExMultiRegistered();
            }
        } catch(ExUnknownRoomType e){
			System.out.println("Sorry, we don't have this type of rooms at all");
		} catch(ExMultiRegistered e) {
			System.out.println("Sorry, every guest can only register once");
        }
    }

    private boolean isGuestAvailable(String guestName, Hotel hotel) {
		return hotel.findGuest(guestName) == null;
	}

    private boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
		if (room == null)
			return false;

        Map<LocalDate, RoomStatus> roomStatusMap = room.getRoomStatusMap();
        Map<LocalDate, HygieneStatus> hygieneStatusMap = room.getHygieneStatusMap();
        Map<LocalDate, DeviceStatus> deviceStatusMap = room.getDeviceStatusMap();
        
        boolean isRoomAvailable = true;
        boolean isRoomClean = true;
        boolean isRoomOrdinary = true;

        for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
            RoomStatus roomStatus = roomStatusMap.get(date);
//            if (roomStatus == null || !roomStatus.getStatus().equals("Available")) {
//                isRoomAvailable = false;
//                break;
//            }
        }

        for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
            HygieneStatus hygieneStatus = hygieneStatusMap.get(date);
//            if (hygieneStatus == null || !hygieneStatus.getStatus().equals("Clean")) {
//                isRoomClean = false;
//                break;
//            }
        }

        for (LocalDate date = checkInDate; date.isBefore(checkOutDate.plusDays(1)); date = date.plusDays(1)) {
            DeviceStatus deviceStatus = deviceStatusMap.get(date);
//            if (deviceStatus == null || !deviceStatus.getStatus().equals("Ordinary")) {
//                isRoomOrdinary = false;
//                break;
//            }
        }

        if (isRoomAvailable && isRoomClean && isRoomOrdinary) {
            return true;
        }
        
        return false;

	}

    private void bookRoom(Room room, String guestName, String passportID, LocalDate checkInDate, LocalDate checkOutDate, String phoneNumber, String roomType, Hotel hotel) {
		room.changeRoomStatus(checkInDate,checkOutDate,new OccupiedStatus());
		room.changeHygieneStatus(checkInDate,LocalDate.of(2023, 12, 31),new DirtyStatus());
        guest = new Guest();
        guest.setCheckInDirectly(guestName, passportID, checkInDate, checkOutDate, phoneNumber, room.getRoomNumber());
        hotel.addGuest(guest);
        room.getRoomType().addGuest(guest);
        System.out.println("Done.");
    }
}