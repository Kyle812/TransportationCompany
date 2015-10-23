public class Passenger {
	
	public static final String CANCELED = "Canceled";
	public static final String WAITLIST = "Waitlist";
	public static final String CONFIRMED = "Confirmed";
    private String name;
    private Route route;
    private String bookingStatus;

    public Passenger (String name, Route route) {
        this.name = name;
        this.route = route;
        bookingStatus = WAITLIST;
    }

    public void confirm() {
        if (!bookingStatus.equals(CANCELED)) {
            bookingStatus = CONFIRMED;
        }
    }

    public void cancel() {
        if (!bookingStatus.equals(CONFIRMED)) {
            bookingStatus = CANCELED;
        }
    }

    public String getPassengerName() {
        return name;
    }

    public Route getRoute() {
        return route;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }
}
