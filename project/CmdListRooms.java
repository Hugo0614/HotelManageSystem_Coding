package project;

import java.time.LocalDate;

public class CmdListRooms implements Command {
    @Override
    public void execute(String[] cmdParts) {
        Hotel hotel =  Hotel.getInstance();
        LocalDate currentTime = LocalDate.parse(cmdParts[1]);
        hotel.listRooms(currentTime);
    }
}