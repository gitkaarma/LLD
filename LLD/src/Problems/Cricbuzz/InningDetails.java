package Problems.Cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class InningDetails {

    Team battingTeam;
    Team bowlingTeam;
    List<OverDetails> overDetailsList;
    MatchType matchType;

    public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        overDetailsList = new ArrayList<>();
    }

    public void startInnings(int runsToWin) {
        battingTeam.chooseNextBatsMan();

        for(int overNumber = 1; overNumber <= matchType.getTotalOvers(); overNumber++){
            bowlingTeam.chooseNextBowler(matchType.getMaxOverPerBowler());

            OverDetails over = new OverDetails(overNumber, bowlingTeam.getCurrentBowler());
            overDetailsList.add(over);
            try {
                boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
                if(won == true) {
                    break;
                }
            }catch (Exception e) {
                break;
            }

            //swap striket and non striker
            Player temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
    }

}
