package Problems.BookMyShow.controllers;

import Problems.BookMyShow.enums.City;
import Problems.BookMyShow.model.Show;
import Problems.BookMyShow.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    // State of Theatre is also managed by this controller using in memory
    public Map<City, List<Theatre>> cityVsTheatre;

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
    }

    public void addTheatreInCity(Theatre theatre, City city) {

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    public void addShowInTheatre(Theatre theatre, Show show, City city) {

        List<Theatre> theatres = cityVsTheatre.get(city);
        if (theatres != null && theatres.contains(theatre)) {
            theatre.allShows.add(show);
        }
    }

    public Map<Theatre, List<Show>> getAllShowsVsTheatre(String movieName, City city) {

        //get all the theater of this city
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatre.get(city);
        //filter the theatres which run this movie
        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.allShows;

            for(Show show : shows) {
                if(show.movie.movieName == movieName) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }
        return theatreVsShows;
    }

}
