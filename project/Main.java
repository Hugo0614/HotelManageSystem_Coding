package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        System.out.print("Welcome to our hotel management system! Please input the pathname of your file, thank you: ");
        String filepathname = in.nextLine();

        Scanner inFile = new Scanner(new File(filepathname));

        while (inFile.hasNext()) {
            String cmdLine = inFile.nextLine().trim();

            if (cmdLine.equals("")) continue;

            System.out.println("\n> " + cmdLine);

            String[] cmdParts = cmdLine.split("\\|");

            switch (cmdParts[0]) {
                case "booking":
                    (new CmdBooking()).execute(cmdParts);
                    break;
                case "checkInDirectly":
                    (new CmdCheckIn()).execute(cmdParts);
                    break;
                case "checkOut":
                    (new CmdCheckOut()).execute(cmdParts);
                    break;
                case "cleanRequest":
                    (new CmdCleanRequest()).execute(cmdParts);
                    break;
                case "cleanResponse":
                    (new CmdCleanResponse()).execute(cmdParts);
                    break;
                case "repairRequest":
                    (new CmdRepairRequest()).execute(cmdParts);
                    break;
                case "repairResponse":
                    (new CmdRepairResponse()).execute(cmdParts);
                    break;
                case "addRoom":
                    (new CmdAddRoom()).execute(cmdParts);
                    break;
                case "listRooms":
                    (new CmdListRooms()).execute(cmdParts);
                    break;
                case "listGuests":
                    (new CmdListGuests()).execute(cmdParts);
                    break;
                default:
                    break;
            }
        }
        inFile.close();
        in.close();
    }
}