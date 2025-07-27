package Problems.TicTacToe.GameStateHandler.GameStateImpl;

import Problems.TicTacToe.GameStateHandler.GameContext.GameContext;
import Problems.TicTacToe.GameStateHandler.GameState;
import Problems.TicTacToe.models.Player;

public class XWinState implements GameState {
    @Override
    public void next(GameContext gameContext, Player player, boolean hasWon) {
        // Won, so no next state
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
