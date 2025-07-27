package Problems.TicTacToe.GameStateHandler.GameStateImpl;

import Problems.TicTacToe.GameStateHandler.GameContext.GameContext;
import Problems.TicTacToe.GameStateHandler.GameState;
import Problems.TicTacToe.models.Player;

public class OTurnState implements GameState {
    @Override
    public void next(GameContext gameContext, Player player, boolean hasWon) {
        if(hasWon){
            gameContext.setCurrentGameState(new OWinState());
        }else{
            gameContext.setCurrentGameState(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
