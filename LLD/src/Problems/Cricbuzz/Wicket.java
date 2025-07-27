package Problems.Cricbuzz;

public class Wicket {

    public WicketType wicketType;
    public Player takenBy;

    public Wicket(WicketType wicketType, Player takenBy){

        this.wicketType = wicketType;
        this.takenBy = takenBy;
    }
}