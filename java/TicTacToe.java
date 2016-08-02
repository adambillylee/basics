/**
 * Created by adamli on 5/14/16.
 */
public class TicTacToe {
    int board[][];

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        board = new int[n][n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player;

        int checkRow = checkRow(row, col);
        if (checkRow > 0)
            return checkRow;

        int checkCol = checkCol(row, col);
        if (checkCol > 0)
            return checkCol;

        if (row == col) {
            int checkDiag = checkDiag(row, col);
            if (checkDiag > 0)
                return checkDiag;

        }

        if (row + col == board.length - 1) {
            int checkAntiDiag = checkAntiDiag(row, col);
            if (checkAntiDiag > 0)
                return checkAntiDiag;
        }

        return 0;
    }

    public int checkRow(int row, int col) {
        int n = board.length;
        int curr = board[row][col];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (board[row][i] == 0) {
                return 0;
            } else {
                if (board[row][i] == curr) {
                    count++;
                } else {
                    count = 0;
                }
            }
        }

        if (count == n) {
            return board[row][0];
        } else {
            return 0;
        }
    }

    public int checkCol(int row, int col) {
        int n = board.length;
        int curr = board[row][col];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 0) {
                return 0;
            } else {
                if (board[i][col] == curr) {
                    count++;
                } else {
                    count = 0;
                }
            }
        }

        if (count == n) {
            return board[0][col];
        } else {
            return 0;
        }
    }

    public int checkDiag(int row, int col) {
        int curr = board[row][col];
        int n = board.length;

        int currRow = row;
        int currCol = col;
        while (currRow >= 0 && currCol >= 0) {
            if (board[currRow][currCol] != curr)
                return 0;

            currRow--;
            currCol--;
        }

        currRow = row;
        currCol = col;
        while (currRow < n && currCol < n) {
            if (board[currRow][currCol] != curr)
                return 0;

            currRow++;
            currCol++;
        }

        return curr;
    }

    public int checkAntiDiag(int row, int col) {
        int curr = board[row][col];
        int n = board.length;

        int currRow = row;
        int currCol = col;
        while (currRow >= 0 && currCol < n) {
            if (board[currRow][currCol] != curr)
                return 0;

            currRow--;
            currCol++;
        }

        currRow = row;
        currCol = col;
        while (currRow < n && currCol >= 0) {
            if (board[currRow][currCol] != curr)
                return 0;

            currRow++;
            currCol--;
        }

        return curr;
    }
}
