package Problems.Cricbuzz;

import java.util.Queue;

public class BattingController {
    public Player striker;
    public Player nonStriker;
    public Queue<Player> yetToPlay;

    public void chooseNextBatsman(){

        if (striker == null) {
            striker = yetToPlay.poll();
        }

        if (nonStriker == null) {
            nonStriker = yetToPlay.poll();
        }
    }
}
