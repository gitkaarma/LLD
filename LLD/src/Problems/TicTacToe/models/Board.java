package Problems.TicTacToe.models;

import Problems.TicTacToe.Enum.Symbol;

public class Board {
    private int rows;
    private int columns;
    private Symbol grid[][];

    public Board(int rows, int columns) {
        this.grid = new Symbol[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position position) {
        return position.row >= 0 && position.row < rows && position.column >= 0 && position.column < columns && grid[position.row][position.column] == Symbol.EMPTY;
    }
}
