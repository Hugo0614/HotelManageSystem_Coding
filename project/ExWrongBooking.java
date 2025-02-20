package project;

public class ExWrongBooking extends Exception{
	public ExWrongBooking() { super("Sorry, we do not accept reservations less than one day in advance"); }
//    public ExWrongBooking(String message) { super(message); }
}
