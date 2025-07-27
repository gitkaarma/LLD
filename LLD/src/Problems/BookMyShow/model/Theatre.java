package Problems.BookMyShow.model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    public String theatreId;

    public String theatreName;
    public List<Screen> allScreens;
    public List<Show> allShows;

    public Theatre(String theatreId, String theatreName) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        allScreens = new ArrayList<>();
        allShows = new ArrayList<>();
    }
    public void addScreen(Screen screen) {
        this.allScreens.add(screen);
    }
}
