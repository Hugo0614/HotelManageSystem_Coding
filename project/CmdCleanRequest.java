package project;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CmdCleanRequest implements Command {
    private Room room;

    @Override
    public void execute(String[] cmdParts) {
        
        Hotel hotel = Hotel.getInstance();

        room = hotel.findRoom(cmdParts[1]);

        LocalDate startDate = LocalDate.parse(cmdParts[2]);

//        TimeRange timeRange = new TimeRange(startDate, LocalDate.MAX);
        
        simulateCheckingBeforeCleaningProcess();
        
		room.changeHygieneStatus(startDate,LocalDate.of(2023, 12, 31), new DirtyStatus());

        System.out.println("\n> Room " + room.getRoomNumber() + "'s hygiene situation has been thoroughly checked, and need to be cleaned later.");

		System.out.println("\n> Clean it now?(Y/N)");

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
            String argument1 = "cleanResponse|"+room.getRoomNumber();
            String argument2 = argument1 + "|";
            String arguments = argument2 + startDate.format(DateTimeFormatter.ISO_DATE);
			String[] cleanCommand = arguments.split("\\|");
			(new CmdCleanResponse()).execute(cleanCommand);
		} else if (choice == 'N' || choice == 'n') {
			System.out.println("\n> Then don't forget to clean Room " + room.getRoomNumber() + " later.");
		}

    }

    private void simulateCheckingBeforeCleaningProcess() {
        System.out.println("Initiating checking process...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking all items from the room...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking the floor...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking all surfaces...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Checking towels and toiletries...");
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}