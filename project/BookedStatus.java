package project;

public class BookedStatus implements RoomStatus {

	private String status;
    
    public BookedStatus() {
        this.status = "Booked";
    }
    
    @Override
    public String getStatus() {
        return status;
    }

}
