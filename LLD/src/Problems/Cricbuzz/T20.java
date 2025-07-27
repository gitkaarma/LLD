package Problems.Cricbuzz;

public class T20 implements MatchType{

    @Override
    public int getTotalOvers() {
        return 20;
    }

    @Override
    public int getMaxOverPerBowler() {
        return 4;
    }
}
