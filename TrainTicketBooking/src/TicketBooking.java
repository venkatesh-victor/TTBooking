import com.venkatesh.ticketbooking.separateuser.SeparateUserView;

public class TicketBooking {
    public static String appName = "Indian Railways";
    public static String version = "0.0.1";
    public static TicketBooking ticketBooking;

    private TicketBooking() {}

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    private void initApp() {
        SeparateUserView separateUserView = new SeparateUserView();
        separateUserView.init();
    }

    public static TicketBooking getInstance() {
        if (ticketBooking == null) {
            ticketBooking = new TicketBooking();
        }
        return ticketBooking;
    }


    public static void main(String[] args) {
        TicketBooking.getInstance().initApp();
    }
}