package Problems.SnakeLadderLocked;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    private Cell[][] cells;
    int boardSize;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        this.boardSize = boardSize;
        initializeCells(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        int totalCells = boardSize * boardSize;
        int maxPosition = totalCells - 1;
        
        // Add snakes
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(2, maxPosition); // Start from position 2
            int snakeTail = ThreadLocalRandom.current().nextInt(1, snakeHead); // Tail must be less than head
            
            // Check if position already has a jump
            Cell cell = getCell(snakeHead);
            if (cell.jump != null) {
                continue;
            }

            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;
            cell.jump = snakeObj;

            numberOfSnakes--;
        }

        // Add ladders
        while (numberOfLadders > 0) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, maxPosition - 1); // Don't start at last position
            int ladderEnd = ThreadLocalRandom.current().nextInt(ladderStart + 1, maxPosition); // End must be greater than start
            
            // Check if position already has a jump
            Cell cell = getCell(ladderStart);
            if (cell.jump != null) {
                continue;
            }

            Jump ladderObj = new Jump();
            ladderObj.start = ladderStart;
            ladderObj.end = ladderEnd;
            cell.jump = ladderObj;

            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition) {
        int boardRow = playerPosition / boardSize;
        int boardColumn = playerPosition % boardSize;
        return cells[boardRow][boardColumn];
    }
}
