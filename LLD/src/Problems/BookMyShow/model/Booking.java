package Problems.BookMyShow.model;

import Problems.BookMyShow.enums.BookingStatus;

import java.util.List;

public class Booking {
    public String id;
    public String userId;
    public Show show;
    public List<Seat> bookedSeats;
    public double totalAmount;
    public BookingStatus status;
}
