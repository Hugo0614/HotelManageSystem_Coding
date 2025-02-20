package project;

public class OrdinaryStatus implements DeviceStatus {

	private String status;
    
    public OrdinaryStatus() {
        this.status = "Ordinary";
    }
    
    @Override
    public String getStatus() {
        return status;
    }

}
