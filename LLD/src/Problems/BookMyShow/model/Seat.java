package Problems.BookMyShow.model;

import Problems.BookMyShow.enums.SeatCategory;

public class Seat {
    public String id;
    public int rowNum;
    public int colNum;
    public SeatCategory seatCategory;

    public Seat(String id, int rowNum, int colNum, SeatCategory type) {
        this.id = id;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.seatCategory = type;
    }

    @Override
    public String toString() {
        return "Seat[" + id + "]";
    }
}
