package Problems.BookMyShow.model;

import java.util.*;

public class Screen {
    public String id;
    public List<Seat> allSeats;

    public Screen(String id) {
        this.id = id;
        this.allSeats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        this.allSeats.add(seat);
    }
}
