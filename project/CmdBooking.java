package project;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class CmdBooking implements Command {
	private Guest guest;

	@Override
	public void execute(String[] cmdParts) {
		bookingProcess(cmdParts);
	}

	private void bookingProcess(String[] cmdParts) {
		Hotel hotel = Hotel.getInstance();
		LocalDate bookingDate = LocalDate.parse(cmdParts[3]);
		LocalDate checkInDate = LocalDate.parse(cmdParts[5]);
		LocalDate checkOutDate = LocalDate.parse(cmdParts[6]);
		Room room = hotel.findRoomByRoomType(cmdParts[4], checkInDate, checkOutDate);
		
		try {
			if (isBookingValid(bookingDate, checkInDate)) {
				if (isGuestAvailable(cmdParts[1], hotel)) {
					if (isRoomAvailable(room,checkInDate, checkOutDate)) {
						bookRoom(room, cmdParts[1], bookingDate, checkInDate, checkOutDate, cmdParts[7], hotel, cmdParts[2]);
						System.out.println("Done.");
					} else {
						throw new ExUnknownRoomType();
					}
				} else {
					throw new ExMultiRegistered();
				}
			} else {
				throw new ExWrongBooking();
			}
			
		} catch(ExUnknownRoomType e){
			System.out.println("Sorry, we don't have this type of rooms at all");
		} catch(ExMultiRegistered e) {
			System.out.println("Sorry, every guest can only register once");
		} catch(ExWrongBooking e) {
			System.out.println("Sorry, we do not accept reservations less than one day in advance");
		}
	}

	private boolean isBookingValid(LocalDate bookingDate, LocalDate checkInDate) {
		return ChronoUnit.DAYS.between(bookingDate, checkInDate) >= 1;
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
        System.out.println(isRoomAvailable);

        if (isRoomAvailable && isRoomClean && isRoomOrdinary) {
            return true;
        }
        
        return false;

	}

	private void bookRoom(Room room, String passportID, LocalDate bookingDate, LocalDate checkInDate,
			LocalDate checkOutDate, String additionalInfo, Hotel hotel, String guestName) {
//		TimeRange timeRange = new TimeRange(checkInDate,checkOutDate);
		room.changeRoomStatus(checkInDate, checkOutDate, new BookedStatus());
		room.changeHygieneStatus(checkInDate, LocalDate.of(2023, 12, 31), new DirtyStatus());
		guest = new Guest();
		guest.setBooking(guestName, passportID, bookingDate, checkInDate, checkOutDate, additionalInfo,
				room.getRoomNumber());
		hotel.addGuest(guest);
		room.getRoomType().addGuest(guest);	
	}
}