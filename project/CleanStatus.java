package project;

public class CleanStatus implements HygieneStatus {

	private String status;
    
    public CleanStatus() {
        this.status = "Clean";
    }
    
    @Override
    public String getStatus() {
        return status;
    }

}
