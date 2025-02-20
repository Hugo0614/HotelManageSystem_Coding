package project;

public class OccupiedStatus implements RoomStatus {
	private String status;
    
    public OccupiedStatus() {
        this.status = "Occupied";
    }
    
    @Override
    public String getStatus() {
        return status;
    }
}
