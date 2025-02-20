package project;

public class AvailableStatus implements RoomStatus {
	private String status;
    
    public AvailableStatus() {
        this.status = "Available";
    }
    
    @Override
    public String getStatus() {
        return status;
    }
}
