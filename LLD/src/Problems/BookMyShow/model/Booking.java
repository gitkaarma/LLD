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

    public Booking(Builder builder){
        this.id = java.util.UUID.randomUUID().toString(); // Generate unique ID
        this.show = builder.show;
        this.userId = builder.userId;
        this.bookedSeats = builder.bookedSeats;
        this.totalAmount = builder.totalAmount;
    }

    public static class Builder{
        public String id;
        public String userId;
        public Show show;
        public List<Seat> bookedSeats;
        public double totalAmount;
        public BookingStatus status;

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder userId(String userId){
            this.userId = userId;
            return this;
        }
        public Builder show(Show show){
            this.show = show;
            return this;
        }

        public Builder bookedSeats(List<Seat> bookedSeatsList) {
            this.bookedSeats = bookedSeatsList;
            return this;
        }

        public Builder status(BookingStatus status){
            this.status = status;
            return this;
        }
        public Booking build(){
            return new Booking(this);
        }
        public Builder totalAmount(double totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }


    }
}
