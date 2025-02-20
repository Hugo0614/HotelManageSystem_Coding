package project;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class CmdCleanResponse implements Command {
    private Room room;

    @Override
    public void execute(String[] cmdParts) {

        Hotel hotel = Hotel.getInstance();

        room = hotel.findRoom(cmdParts[1]);

        LocalDate startDate = LocalDate.parse(cmdParts[2]);

//        TimeRange timeRange = new TimeRange(startDate, LocalDate.MAX);
        
        simulateCleaningProcess();
        
        HygieneStatus hs = new CleanStatus();
        
		room.changeHygieneStatus(startDate, LocalDate.of(2023, 12, 31), hs);
		
		LocalDate mod = startDate.plusDays(1);
		
		System.out.println(room.getHygieneStatus(mod).getStatus());
		
        System.out.println("Room " + room.getRoomNumber() + " has been impeccably cleaned.");
    }

    private void simulateCleaningProcess() {
        System.out.println("Initiating advanced cleaning process...");
        
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("Removing all items from the room...");
//        
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("Using high-tech cleaning tools and solutions...");
//        
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("Disinfecting all surfaces with hospital-grade disinfectants...");
//        
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        System.out.println("Replacing fresh towels and restocking toiletries...");
//        
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}