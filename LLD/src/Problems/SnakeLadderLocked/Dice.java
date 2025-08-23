package Problems.SnakeLadderLocked;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int totalDiceCount;
    private int totalDiceFace = 6;

    public Dice(int totalDiceCount) {
        this.totalDiceCount = totalDiceCount;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < totalDiceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(1, totalDiceFace + 1);
            diceUsed++;
        }

        return totalSum;
    }
}
