package Problems.Cricbuzz;

public class OneDay implements MatchType{

    @Override
    public int getTotalOvers() {
        return 50;
    }

    @Override
    public int getMaxOverPerBowler() {
        return 10;
    }
}
