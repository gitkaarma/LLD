package Problems.Cricbuzz;

import Problems.Cricbuzz.ScoreUpdater.BattingScoreUpdater;
import Problems.Cricbuzz.ScoreUpdater.BowlingScoreUpdater;

import java.util.ArrayList;
import java.util.List;

public class OverDetails {
    Player bowledBy;
    int extraBallsCount;
    int overNumber;
    List<BallDetails> ballDetailsList;

    public OverDetails(int overNumber, Player bowledBy) {
        this.bowledBy = bowledBy;
        this.overNumber = overNumber;
        ballDetailsList = new ArrayList<>();
        extraBallsCount = 0;
    }

    public boolean startOver(Team battingTeam, Team bowlingTeam, int runsToWin) throws Exception{

        int ballCount = 1;
        while(ballCount<=6){

            BallDetails ball = new BallDetails(ballCount);
            ball.addObserver(new BowlingScoreUpdater());
            ball.addObserver(new BattingScoreUpdater());
            ball.startBallDelivery(battingTeam, bowlingTeam, this);
            if(ball.ballType == BallType.NORMAL) {
                ballDetailsList.add(ball);
                ballCount++;
                if(ball.wicket != null) {
                    battingTeam.chooseNextBatsMan();
                }

                if( runsToWin != -1 && battingTeam.getTotalRuns() >= runsToWin){
                    battingTeam.winner = true;
                    return true;
                }
            }
            else {
                extraBallsCount++;
            }
        }
        return false;
    }
}
