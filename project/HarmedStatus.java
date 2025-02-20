package project;

public class HarmedStatus implements DeviceStatus {
	private String status;
    
    public HarmedStatus() {
        this.status = "Harmed";
    }
    
    @Override
    public String getStatus() {
        return status;
    }
}
