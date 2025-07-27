package Problems.TicTacToe.GameStateHandler.GameStateImpl;

import Problems.TicTacToe.GameStateHandler.GameContext.GameContext;
import Problems.TicTacToe.GameStateHandler.GameState;
import Problems.TicTacToe.models.Player;

public class XTurnState implements GameState {

    @Override
    public void next(GameContext gameContext, Player player, boolean hasWon) {
        if(hasWon){
            gameContext.setCurrentGameState(new XWinState());
        }else{
            gameContext.setCurrentGameState(new OTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
