package Problems.TicTacToe.GameStateHandler.GameContext;

import Problems.TicTacToe.GameStateHandler.GameState;
import Problems.TicTacToe.GameStateHandler.GameStateImpl.XTurnState;
import Problems.TicTacToe.models.Player;

public class GameContext {
    private GameState currentGameState;

    public GameContext() {
        currentGameState = new XTurnState();
    }

    public void setCurrentGameState(GameState currentGameState) {
        this.currentGameState = currentGameState;
    }
    public void next(Player player, boolean hasWon) {
        currentGameState.next(this, player, hasWon);
    }

    public boolean isGameOver() {
        return currentGameState.isGameOver();
    }

    public GameState getCurrentState() {
        return currentGameState;
    }

}
