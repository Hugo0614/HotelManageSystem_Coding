package project;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;

public class CmdRepairResponse implements Command {
	private Room room;
	@Override
	public void execute(String[] cmdParts) {

		Hotel hotel = Hotel.getInstance();

		room = hotel.findRoom(cmdParts[1]);

        LocalDate startDate = LocalDate.parse(cmdParts[2]);

//        TimeRange timeRange = new TimeRange(startDate, LocalDate.MAX);
		
		simulateRepairingProcess(startDate);
		
		room.changeDeviceStatus(startDate, LocalDate.of(2023, 12, 31), new OrdinaryStatus());

//		System.out.println("Room " + room.getRoomNumber() + " has been impeccably cleaned.");
	}

	private void simulateRepairingProcess(LocalDate startDate) {
        System.out.println("Initiating advanced repairing process...");
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Removing all items from the room...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Place a layer of dustproof paper on the walls and floors of the room...");
        
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Maintenance in progress...");
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		if(room.getHygieneStatus(startDate).getStatus().equals("Dirty")) {
			System.out.println("Completed, start clean mission now...");
			String argument1 = "cleanResponse|"+room.getRoomNumber();
            String argument2 = argument1 + "|";
            String arguments = argument2 + startDate.format(DateTimeFormatter.ISO_DATE);
			String[] cleanCommand = arguments.split("\\|");
			(new CmdCleanResponse()).execute(cleanCommand);
		} else {
			System.out.println("Room " + room.getRoomNumber() + " has been impeccably repaired.");
		}
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
