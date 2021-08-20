package machinecoding.TikTackToeGameDesign.model;

import machinecoding.TikTackToeGameDesign.exception.WrongMoveException;

public class GameBoard {
    int[][] grid;
    int n;
    int boardSize;
    int filledSlots;

    public GameBoard(int n) {
        grid = new int[n][n];
        this.n = n;
        boardSize = n * n;
        filledSlots = 0;
    }

    public void markSlot(int row, int col, int sign) throws WrongMoveException {
        if (row >= n || col >= n || row < 0 || col < 0) {
            throw new WrongMoveException("row / col value should be between 0 and " + (n - 1));
        }
        if (grid[row][col] != 0) {
            throw new WrongMoveException("The " + row + ", " + col + " is already filled, please choose another slot");
        }
        grid[row][col] = sign;
        filledSlots++;
    }

    public void printGameState() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        return boardSize <= filledSlots;
    }
}
