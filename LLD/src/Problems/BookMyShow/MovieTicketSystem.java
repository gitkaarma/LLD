package Problems.BookMyShow;

// ========== MAIN SYSTEM CONTROLLER ==========

import Problems.BookMyShow.controllers.MovieController;
import Problems.BookMyShow.controllers.TheatreController;
import Problems.BookMyShow.enums.City;
import Problems.BookMyShow.enums.SeatCategory;
import Problems.BookMyShow.enums.SeatStatus;
import Problems.BookMyShow.model.*;
import Problems.BookMyShow.services.TicketBookingService;
import Problems.BookMyShow.strategy.PaymentStrategy;

import java.util.*;

/**
 * Main class to manage all data and orchestrate operations.
 * This acts as our in-memory database and controller.
 */
class MovieTicketSystem {
    private final Map<String, Show> allShows;

    private final Map<String, City> cities;
    private final Map<String, User> users;
    private final TicketBookingService bookingService;
    private final TheatreController theatreController;

    public MovieTicketSystem() {
        this.theatreController = new TheatreController();
        cities = new HashMap<>();
        allShows = new HashMap<>();
        users = new HashMap<>();
        bookingService = new TicketBookingService();
        setupMockData();
    }

    // 1. List all cities where cinemas are present.
    public List<City> getCities() {
        return new ArrayList<>(cities.values());
    }

    // 2. For a given city, list all movie theatres.
    public List<Theatre> getTheatresByCity(City city) {
        return theatreController.cityVsTheatre.get(city);
    }

    // 3. For a given movie, list all theatres running it and the show timings.
    public Map<Theatre, List<Show>> getShowsForMovieInCity(String movieName, City city) {
        return theatreController.getAllShowsVsTheatre(movieName, city);
    }

    // 4. For a given show, display the seating arrangement.
    public void displaySeatLayout(String showId) {
        Show show = allShows.get(showId);
        System.out.println("Seating Layout for " + show.movie.movieName + " at " + show.startTime);
        for (Map.Entry<String, SeatStatus> entry : show.allSeatStatus.entrySet()) {
            System.out.println("Seat " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // 5 & 6. Select seats, calculate price, and create a booking.
    public Booking bookTickets(String userId, String showId, List<String> seatIds, PaymentStrategy paymentStrategy) {
        User user = users.get(userId);
        Show show = allShows.get(showId);
        if (user == null || show == null) {
            throw new IllegalArgumentException("Invalid User or Show ID.");
        }
        Booking booking = bookingService.createBooking(user, show, seatIds, paymentStrategy);
        user.addBooking(booking); // Add to user's history
        return booking;
    }

    // 7. Users can view their booking history.
    public List<Booking> getBookingHistory(String userId) {
        return users.get(userId).bookingHistory;
    }

    private void setupMockData() {

        // Create Theatres and Screens
        Theatre pvrForum = new Theatre("t1", "PVR Forum Mall");
        Screen pvrScreen1 = new Screen("s1");
        pvrScreen1.addSeat(new Seat("A1", 1, 1, SeatCategory.RECLINER));
        pvrScreen1.addSeat(new Seat("A2", 1, 2, SeatCategory.RECLINER));
        pvrForum.addScreen(pvrScreen1);
        theatreController.addTheatreInCity(pvrForum, City.MUMBAI);

        Theatre inoxGopalan = new Theatre("t2", "INOX Gopalan Mall");
        Screen inoxScreen1 = new Screen("s2");
        inoxScreen1.addSeat(new Seat("A1", 1, 1, SeatCategory.REGULAR));
        inoxScreen1.addSeat(new Seat("A2", 1, 2, SeatCategory.REGULAR));
        inoxGopalan.addScreen(inoxScreen1);
        theatreController.addTheatreInCity(inoxGopalan, City.BANGALORE);

        // Create Movies
        Movie movie1 = new Movie("mv1","Fighter", 160);

        // Create Shows
        Show show1 = new Show("sh1", movie1, pvrScreen1, new Date());
        allShows.put(show1.showId, show1);

        Show show2 = new Show("sh2", movie1, inoxScreen1, new Date());
        allShows.put(show2.showId, show2);

        // Create Users
        User user1 = new User("u1", "Aarav");
        users.put(user1.userId, user1);
    }
}
