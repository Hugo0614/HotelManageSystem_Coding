package project;

import java.util.ArrayList;

public interface RoomType {
    String getType();
    
    double getPrice();
    
    void addGuest(Guest guest);
    
    ArrayList<Guest> getGuests();
    
    void listGuestsByRoomType();
}
