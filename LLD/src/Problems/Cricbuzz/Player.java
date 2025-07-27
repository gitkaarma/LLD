package Problems.Cricbuzz;

public class Player {
    String name;
    BattingScorecard battingScorecard;
    BowlingScorecard bowlingScorecard;
    PlayerType playerType;

    public void printBattingScoreCard(){

        System.out.println("PlayerName: " + this.name + " -- totalRuns: " + battingScorecard.runsScored
                + " -- totalBallsPlayed: " + battingScorecard.bowlsPlayed + " -- 4s: " + battingScorecard.fours
                + " -- 6s: " + battingScorecard.sixes + " -- outby: " +   ((battingScorecard.wicketDetails != null) ? battingScorecard.wicketDetails.takenBy.name : "notout"));
    }

    public void printBowlingScoreCard(){
        System.out.println("PlayerName: " + this.name + " -- totalOversThrown: " + bowlingScorecard.oversBowled
                + " -- totalRunsGiven: " + bowlingScorecard.runsGiven + " -- WicketsTaken: " + bowlingScorecard.wicketsTaken);
    }
}
