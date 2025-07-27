package Problems.BookMyShow.model;

import Problems.BookMyShow.enums.SeatStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Show {
    public String showId;
    public Movie movie;
    public Screen screen;
    public Map<String, SeatStatus> allSeatStatus;
    public Date startTime;

    public Show(String id, Movie movie, Screen screen, Date startTime) {
        this.showId = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.allSeatStatus = new HashMap<>();
        // Initially, all seats in the screen are available for this show
        for (Seat seat : screen.allSeats) {
            allSeatStatus.put(seat.id, SeatStatus.AVAILABLE);
        }
    }
}
