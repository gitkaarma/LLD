package Problems.Cricbuzz;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class BowlingController {

    Player currentBowler;
    Map<Player, Integer> oversBowled;
    Deque<Player> bowlersQueue;

    public BowlingController(List<Player> bowlersList) {

        this.bowlersQueue = new LinkedList<>();
        oversBowled = new HashMap<>();
        for (Player bowler : bowlersList) {
            this.bowlersQueue.addLast(bowler);
            oversBowled.put(bowler, 0);
        }
    }

    public void chooseNextBowler(int maxOverCountPerBowler){
        Player playerDetails = bowlersQueue.poll();
        currentBowler = playerDetails;

        // Increment the over count since this bowler is bowling this over
        int currentOverCount = oversBowled.get(playerDetails) + 1;
        oversBowled.put(playerDetails, currentOverCount);

        // Only add back to queue if they haven't reached maximum overs
        if (currentOverCount < maxOverCountPerBowler) {
            bowlersQueue.addLast(playerDetails);
        }
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }

}
