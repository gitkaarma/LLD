package Problems.BookMyShow;

import Problems.BookMyShow.enums.City;
import Problems.BookMyShow.model.*;
import Problems.BookMyShow.strategy.PaymentStrategy;
import Problems.BookMyShow.strategy.impl.CreditCardPayment;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MovieTicketSystem system = MovieTicketSystem.getInstance();

        System.out.println("## 1. List all cities where cinemas are present ##");
        system.getCities().forEach(city -> System.out.println("- " + city));
        System.out.println("----------------------------------------");

        System.out.println("\n## 2. For a given city (Bengaluru), list all movie theatres ##");
        system.getTheatresByCity(City.MUMBAI).forEach(theatre -> System.out.println("- " + theatre));
        System.out.println("----------------------------------------");

        System.out.println("\n## 3. For a movie (Fighter), list theatres and show timings in Bengaluru ##");
        Map<Theatre, List<Show>> showsByTheatre = system.getShowsForMovieInCity("m1", City.BANGALORE);
        showsByTheatre.forEach((theatre, showList) -> {
            System.out.println("- Theatre: " + theatre.theatreName);
            showList.forEach(show -> System.out.println("  -> Show Time: " + show.startTime));
        });
        System.out.println("----------------------------------------");

        System.out.println("\n## 4. For a given show, display the seating arrangement ##");
        system.displaySeatLayout("sh1");
        System.out.println("----------------------------------------");

        System.out.println("\n## 5 & 6. Book tickets for a show ##");
        try {
            List<String> seatsToBook = Collections.singletonList("A2");
            PaymentStrategy ccPayment = new CreditCardPayment("Aarav", "1234-5678-9876-5432");
            Booking booking = system.bookTickets("u1", "sh1", seatsToBook, ccPayment);
            System.out.println("✅ Booking successful!");
        } catch (Exception e) {
            System.err.println("Booking failed: " + e.getMessage());
        }
        System.out.println("----------------------------------------");

        System.out.println("\n## Seating arrangement after booking ##");
        system.displaySeatLayout("sh1");
        System.out.println("----------------------------------------");

        System.out.println("\n## 7. View user's booking history ##");
        List<Booking> history = system.getBookingHistory("u1");
        if (history.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            history.forEach(System.out::println);
        }
        System.out.println("----------------------------------------");
    }
}
