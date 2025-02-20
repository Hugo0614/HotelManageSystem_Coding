package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private String roomNumber;
    private RoomType roomType;
    private Map<LocalDate, RoomStatus> roomStatusMap;
    private Map<LocalDate, HygieneStatus> hygieneStatusMap;
    private Map<LocalDate, DeviceStatus> deviceStatusMap;

    public Room(String rN, RoomType rT) {
        roomNumber = rN;
        roomType = rT;
        roomStatusMap = new HashMap<>();
        hygieneStatusMap = new HashMap<>();
        deviceStatusMap = new HashMap<>();

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        // Initialize room status as available for each date in 2023
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            roomStatusMap.put(date, new AvailableStatus());
            hygieneStatusMap.put(date, new DirtyStatus());   // Hugo change Clean Status
            deviceStatusMap.put(date, new OrdinaryStatus());
            date = date.plusDays(1);
        }
    }

    public Map<LocalDate, RoomStatus> getRoomStatusMap() {
        return roomStatusMap;
    }

    public Map<LocalDate, HygieneStatus> getHygieneStatusMap() {
        return hygieneStatusMap;
    }

    public Map<LocalDate, DeviceStatus> getDeviceStatusMap() {
        return deviceStatusMap;
    }

    public void changeRoomStatus(LocalDate checkInDate, LocalDate checkOutDate, RoomStatus rS) {
        LocalDate date = checkInDate;
        while (!date.isAfter(checkOutDate)) {
            roomStatusMap.put(date, rS);
            date = date.plusDays(1);
        }
    }

    public void changeHygieneStatus(LocalDate startDate, LocalDate endDate, HygieneStatus hS) {
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            hygieneStatusMap.put(date, hS);
            date = date.plusDays(1);
        }
    }

    public void changeDeviceStatus(LocalDate startDate, LocalDate endDate, DeviceStatus dS) {
        LocalDate date = startDate;
        while (!date.isAfter(endDate)) {
            deviceStatusMap.put(date, dS);
            date = date.plusDays(1);
        }
    }

    public RoomStatus getRoomStatus(LocalDate time) {
        return roomStatusMap.get(time);
    }

    public HygieneStatus getHygieneStatus(LocalDate time) {
        return hygieneStatusMap.get(time);
    }

    public DeviceStatus getDeviceStatus(LocalDate time) {
        return deviceStatusMap.get(time);
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public static void list(ArrayList<Room> allRooms, LocalDate currentTime) {
        for (Room r : allRooms) {
            RoomStatus roomStatus = r.getRoomStatus(currentTime);
            HygieneStatus hygieneStatus = r.getHygieneStatus(currentTime);
            DeviceStatus deviceStatus = r.getDeviceStatus(currentTime);
            System.out.println("Room Number: " + r.getRoomNumber() + " | Room Type: " +
                    r.getRoomType().getType() + " | Room Status: " + roomStatus.getStatus() +
                    " | Hygiene Status: " + hygieneStatus.getStatus() + " | Device Status: " +
                    deviceStatus.getStatus());
        }
    }
}