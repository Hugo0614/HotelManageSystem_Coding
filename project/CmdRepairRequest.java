package project;

import java.util.concurrent.TimeUnit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CmdRepairRequest implements Command {
	private Room room;
	@Override
	public void execute(String[] cmdParts) {
		Hotel hotel = Hotel.getInstance();

		room = hotel.findRoom(cmdParts[1]);

        LocalDate startDate = LocalDate.parse(cmdParts[2]);

//        TimeRange timeRange = new TimeRange(startDate, LocalDate.MAX);

		simulateCheckingBeforeMaintainingProcess();

		room.changeDeviceStatus(startDate, LocalDate.of(2023, 12, 31), new HarmedStatus());
		
		System.out.println("Room " + room.getRoomNumber() + "'s device situation has been thoroughly checked, and need to be maintained and repaired later.");

		System.out.println("\n> Maintain it now?(Y/N)");

		Scanner scanner = new Scanner(System.in);

		char choice = scanner.next().charAt(0);
		
		System.out.println("\n> "+choice);
		
		while (choice !='Y' && choice !='y' && choice !='N' && choice !='n'){
			System.out.println("\n> Wrong Input! Please Try Again!");
			try {
                choice = scanner.next().charAt(0);
                System.out.println("\n> "+choice);
            } catch (Exception e) {
                scanner.nextLine(); 
            }
		}

		if(choice == 'Y' || choice == 'y') {
            String argument1 = "repairResponse|"+room.getRoomNumber();
            String argument2 = argument1 + "|";
            String arguments = argument2 + startDate.format(DateTimeFormatter.ISO_DATE);
			String[] repairCommand = arguments.split("\\|");
			(new CmdRepairResponse()).execute(repairCommand);
		} else if (choice == 'N' || choice == 'n') {
			System.out.println("\n> Then don't forget to maintain Room " + room.getRoomNumber() + " later.");
		}
	}

	private void simulateCheckingBeforeMaintainingProcess() {
        System.out.println("Initiating checking process...");
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking all furniture from the room...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking the floor tile...");
        
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking all electrical appliances...");
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking sanitary ware...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
