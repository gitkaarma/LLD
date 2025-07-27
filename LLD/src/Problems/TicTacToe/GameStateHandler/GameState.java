package Problems.TicTacToe.GameStateHandler;

import Problems.TicTacToe.GameStateHandler.GameContext.GameContext;
import Problems.TicTacToe.models.Player;

public interface GameState {
    void next(GameContext gameContext, Player player, boolean hasWon);

    boolean isGameOver();
}
