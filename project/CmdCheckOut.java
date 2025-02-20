package project;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CmdCheckOut implements Command {
    private Guest guest;

    @Override
    public void execute(String[] cmdParts) {
        Hotel hotel = Hotel.getInstance();
        LocalDate actualDate = LocalDate.parse(cmdParts[3]);
        guest = hotel.findGuest(cmdParts[1]);
        if (guest != null) {
            checkOutGuest(guest, actualDate);
            hotel.removeGuest(guest);
//            System.out.println("/");
        } else {
            System.out.println("Sorry, this person does not exist.");
        }
    }

    private void checkOutGuest(Guest guest, LocalDate actualDate) {
        Room room = Hotel.getInstance().findRoom(guest.getRoomNumber());
        cleanRoom(room, actualDate);

        LocalDate checkOutDate = guest.getCheckOutDate();
        if (isEarlyCheckout(actualDate, checkOutDate)) {
            double refund = calculateRefund(room, actualDate, checkOutDate);
            System.out.println("Since you checked out early, we will give you a partial refund based on your actual check-out date. You will be refunded: " + refund + " dollars.");
        } else {
            System.out.println("Check out successfully!");
        }
        room.changeRoomStatus(actualDate, LocalDate.of(2023, 12, 31), new AvailableStatus());
    }

    private void cleanRoom(Room room, LocalDate actualDate) {
    	String argument1 = "cleanRequest|"+room.getRoomNumber();
        String argument2 = argument1 + "|";
        String arguments = argument2 + actualDate.format(DateTimeFormatter.ISO_DATE);
        String[] cleanCommand = arguments.split("\\|");
        (new CmdCleanRequest()).execute(cleanCommand);
    }

    private boolean isEarlyCheckout(LocalDate actualDate, LocalDate checkOutDate) {
        return ChronoUnit.DAYS.between(actualDate, checkOutDate) > 0;
    }

    private double calculateRefund(Room room, LocalDate actualDate, LocalDate checkOutDate) {
        int saturdayCount = 0;
        int sundayCount = 0;
        int weekdayCount = 0;
        LocalDate currentDate = actualDate;
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
        double refund = (room.getRoomType().getPrice() * 0.1 * weekdayCount) +
                (room.getRoomType().getPrice() * 0.3 * saturdayCount) +
                (room.getRoomType().getPrice() * sundayCount * 0.5);
        return refund;
    }
}