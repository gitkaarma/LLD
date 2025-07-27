package Problems.BookMyShow.services;

import Problems.BookMyShow.enums.BookingStatus;
import Problems.BookMyShow.enums.SeatStatus;
import Problems.BookMyShow.model.*;
import Problems.BookMyShow.strategy.PaymentStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class TicketBookingService {
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
        }

        // Step 3: Process payment
        double totalAmount = calculatePrice(seatIdsToBook);
        boolean paymentSuccessful = paymentStrategy.pay(totalAmount);

        // Step 4: Confirm or revert booking
        Booking booking = new Booking();
        synchronized (show) {
            if (paymentSuccessful) {
                for (String seatId : seatIdsToBook) {
                    show.allSeatStatus.put(seatId, SeatStatus.BOOKED);
                }

                List<Seat> bookedSeatsList = show.screen.allSeats.stream()
                        .filter(seat -> seatIdsToBook.contains(seat.id))
                        .collect(Collectors.toList());

                booking.id = UUID.randomUUID().toString();
                booking.userId = user.userId;
                booking.show = show;
                booking.bookedSeats = bookedSeatsList;
                booking.totalAmount = totalAmount;
                booking.status = BookingStatus.CONFIRMED;

            } else {
                // Payment failed, release the locked seats
                for (String seatId : seatIdsToBook) {
                    show.allSeatStatus.put(seatId, SeatStatus.AVAILABLE);
                }
                throw new RuntimeException("Payment Failed! Your seats have been released.");
            }
        }
        return booking;
    }

    private double calculatePrice(List<String> seatIds) {
        // In a real system, price would depend on seat type, show time, etc.
        double pricePerSeat = 250.0;
        return pricePerSeat * seatIds.size();
    }
}
