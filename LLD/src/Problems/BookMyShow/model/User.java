package Problems.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String userId;
    public String userName;
    public List<Booking> bookingHistory;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        bookingHistory = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        this.bookingHistory.add(booking);
    }
}
