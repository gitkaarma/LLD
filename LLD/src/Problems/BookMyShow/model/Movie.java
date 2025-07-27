package Problems.BookMyShow.model;

public class Movie {

    public String movieId;
    public String movieName;

    public Movie(String movieId, String movieName, int durationInMinutes) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
    }

    public int durationInMinutes;


}
