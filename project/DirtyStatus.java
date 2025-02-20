package project;

public class DirtyStatus implements HygieneStatus {
	private String status;
    
    public DirtyStatus() {
        this.status = "Dirty";
    }
    
    @Override
    public String getStatus() {
        return status;
    }
}
