package project;

public class CmdListGuests implements Command {
    @Override
    public void execute(String[] cmdParts) {
        Hotel hotel =  Hotel.getInstance();
        try{
            if(cmdParts.length == 1) {
                hotel.listGuests();
            } else {
                if(cmdParts[1].equals("Business")) {
                	RoomType rt = new BusinessType();
                	if(rt.getGuests().size()==0) {
                		throw new ExNoGuestsRecord();
                	} else {
                		rt.listGuestsByRoomType();
                	}
                } else if(cmdParts[1].equals("Double")) {
                	RoomType rt = new DoubleType();
                	if(rt.getGuests().size()==0) {
                		throw new ExNoGuestsRecord();
                	} else {
                		rt.listGuestsByRoomType();
                	}
                } else if(cmdParts[1].equals("Deluxe")) {
                	RoomType rt = new DeluxeType();
                	if(rt.getGuests().size()==0) {
                		throw new ExNoGuestsRecord();
                	} else {
                		rt.listGuestsByRoomType();
                	}
                } else if(cmdParts[1].equals("Family")) {
                	RoomType rt = new FamilyType();
                	if(rt.getGuests().size()==0) {
                		throw new ExNoGuestsRecord();
                	} else {
                		rt.listGuestsByRoomType();
                	}
                } else if(cmdParts[1].equals("Queen")) {
                	RoomType rt = new QueenType();
                	if(rt.getGuests().size()==0) {
                		throw new ExNoGuestsRecord();
                	} else {
                		rt.listGuestsByRoomType();
                	}
                } else if(cmdParts[1].equals("Standard")) {
                	RoomType rt = new StandardType();
                	if(rt.getGuests().size()==0) {
                		throw new ExNoGuestsRecord();
                	} else {
                		rt.listGuestsByRoomType();
                	}
                } else {
                	throw new ExUnknownRoomType();
                }
            }
        } catch (ExNoGuestsRecord e) {
            System.out.println("No guests checkIn record");
        } catch (ExUnknownRoomType e) {
        	System.out.println("Unknown Room Type");
        }
    }
}