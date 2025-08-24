package Problems.BookMyShow.services;

import Problems.BookMyShow.observer.Observer;
import Problems.BookMyShow.enums.BookingStatus;
import Problems.BookMyShow.enums.SeatStatus;
import Problems.BookMyShow.model.*;
import Problems.BookMyShow.strategy.PaymentStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class TicketBookingService{
    private List<Observer> observers = new ArrayList<>();
    public Booking createBooking(User user, Show show, List<String> seatIdsToBook, PaymentStrategy paymentStrategy) {
        // Step 1 & 2: Check availability and lock seats atomically
        synchronized (show) {
            for (String seatId : seatIdsToBook) {
                if (show.allSeatStatus.get(seatId) != SeatStatus.AVAILABLE) {
                    throw new IllegalStateException("Seat " + seatId + " is not available.");
                }
            }
            for (String seatId : seatIdsToBook) {
                show.allSeatStatus.put(seatId, SeatStatus.LOCKED);
            }
            // Notify observers about seat locking
            notifyObservers("Seats " + seatIdsToBook + " locked for user " + user.userName + " for movie " + show.movie.movieName);
        }

        // Step 3: Process payment
        double totalAmount = calculatePrice(seatIdsToBook);
        boolean paymentSuccessful = paymentStrategy.pay(totalAmount);

        // Step 4: Confirm or revert booking
        Booking booking;
        synchronized (show) {
            if (paymentSuccessful) {
                for (String seatId : seatIdsToBook) {
                    show.allSeatStatus.put(seatId, SeatStatus.BOOKED);
                }

                List<Seat> bookedSeatsList = show.screen.allSeats.stream()
                        .filter(seat -> seatIdsToBook.contains(seat.id))
                        .collect(Collectors.toList());
                booking = new Booking.Builder().show(show).bookedSeats(bookedSeatsList).status(BookingStatus.CONFIRMED).totalAmount(totalAmount).build();
                user.bookingHistory.add(booking);
                
                // Notify observers about successful booking
                notifyObservers("Booking confirmed for user " + user.userName + " - Movie: " + show.movie.movieName + 
                              ", Seats: " + seatIdsToBook + ", Amount: ₹" + totalAmount);
            } else {
                // Payment failed, release the locked seats
                for (String seatId : seatIdsToBook) {
                    show.allSeatStatus.put(seatId, SeatStatus.AVAILABLE);
                }
                
                // Notify observers about payment failure
                notifyObservers("Payment failed for user " + user.userName + " - Movie: " + show.movie.movieName + 
                              ", Seats: " + seatIdsToBook + " have been released");
                throw new RuntimeException("Payment Failed! Your seats have been released.");
            }
        }
        return booking;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    private double calculatePrice(List<String> seatIds) {
        // In a real system, price would depend on seat type, show time, etc.
        double pricePerSeat = 250.0;
        return pricePerSeat * seatIds.size();
    }
}
