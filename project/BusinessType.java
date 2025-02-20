package project;
import java.util.ArrayList;

public class BusinessType implements RoomType {
    private static ArrayList<Guest> guests; 
    
    static {
        guests = new ArrayList<>();
    }
    
    private String type;
    private double price;
    
    public BusinessType() {
        this.type = "Business";
        this.price = 150.0;
    }
    
    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    public void addGuest(Guest guest) {
        guests.add(guest);
    }
    
    public ArrayList<Guest> getGuests() {
        return guests;
    }
    
    public void listGuestsByRoomType() {
    	for (Guest g : guests) {
    		g.selfDcl();
    	}  
    }
}