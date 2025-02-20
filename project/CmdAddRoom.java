package project;

public class CmdAddRoom implements Command {
	private Room room;
    @Override
	public void execute(String[] cmdParts) {
		createRoom(cmdParts);
		Hotel hotel = Hotel.getInstance();
		if(room!=null) {
			hotel.addRoom(room);
		}
		System.out.println("Done.");
	}

	private void createRoom(String[] cmdParts) {
		String roomType = cmdParts[2];
		try {
		    switch (roomType) {
		        case "Business":
		            room = new Room(cmdParts[1], new BusinessType());
		            break;
		        case "Deluxe":
		            room = new Room(cmdParts[1], new DeluxeType());
		            break;
		        case "Double":
		            room = new Room(cmdParts[1], new DoubleType());
		            break;
		        case "Family":
		            room = new Room(cmdParts[1], new FamilyType());
		            break;
		        case "Queen":
		            room = new Room(cmdParts[1], new QueenType());
		            break;
		        case "Standard":
		            room = new Room(cmdParts[1], new StandardType());
		            break;
		        default:
		            throw new IllegalArgumentException("Invalid room type: " + roomType);
		    }
		} catch (IllegalArgumentException e) {
		    System.out.println(e.getMessage());
		}
	}
}