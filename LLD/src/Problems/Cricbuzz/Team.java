package Problems.Cricbuzz;

import java.util.List;
import java.util.Queue;

public class Team {

    public String name;
    public Queue<Player> playingEleven;
    public List<Player> bowlers;

    BattingController battingController;
    BowlingController bowlingController;

    boolean winner;

    public void chooseNextBatsMan(){
        battingController.chooseNextBatsman();
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        bowlingController.chooseNextBowler(maxOverCountPerBowler);
    }


    public Player getStriker() {
        return battingController.striker;
    }

    public Player getNonStriker() {
        return battingController.nonStriker;
    }

    public void setStriker(Player player) {
        battingController.striker = player;
    }

    public void setNonStriker(Player player) {
        battingController.nonStriker = player;
    }

    public Player getCurrentBowler() {
        return bowlingController.getCurrentBowler();
    }

    public int getTotalRuns(){
        int totalRun = 0;
        for (Player player :  playingEleven){
            totalRun += player.battingScorecard.runsScored;
        }
        return totalRun;
    }
}
