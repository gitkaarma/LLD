package Problems.SnakeLadderLocked;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    private Board board;
    private Dice dice;
    private Deque<Player> playersList = new LinkedList<>();
    private Player winner;
    private int boardSize;
    private int winningPosition;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        boardSize = 10;
        board = new Board(boardSize, 5, 4);
        dice = new Dice(1);
        winner = null;
        winningPosition = boardSize * boardSize - 1;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playersList.add(player1);
        playersList.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            // Check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is: " + playerTurn.id + " current position is: " + playerTurn.currentPosition);

            // Roll the dice
            int diceNumbers = dice.rollDice();

            // Get the new position
            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("player turn is: " + playerTurn.id + " new Position is: " + playerNewPosition);
            
            // Check for winning condition
            if (playerNewPosition >= winningPosition) {
                winner = playerTurn;
            }
        }

        System.out.println("WINNER IS: " + winner.id);
    }


    private Player findPlayerTurn() {
        Player playerTurn = playersList.removeFirst();
        playersList.addLast(playerTurn);
        return playerTurn;
    }

    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > winningPosition) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if (cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.jump.end;
        }
        return playerNewPosition;
    }
}
