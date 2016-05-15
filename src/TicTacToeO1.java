/**
 * Created by adamli on 5/14/16.
 */
public class TicTacToeO1 {
    int row[];
    int col[];
    int diag;
    int antiDiag;

    /**
     * Initialize your data structure here.
     */
    public TicTacToeO1(int n) {
        row = new int[n];
        col = new int[n];
        diag = 0;
        antiDiag = 0;
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
        int n = this.row.length;

        // add col, row, diag or antiDiag count by 1 if player 1, if player2, add -1
        // if one player occupied the row, col, diag or antiDiag, the corresponding count will be n or -n
        int toAdd = player == 1 ? 1 : -1;


        // from row and count, update corresponding counter, the value depends on player
        this.row[row] += toAdd;
        if (Math.abs(this.row[row]) == n)
            return player;

        this.col[col] += toAdd;
        if (Math.abs(this.col[col]) == n)
            return player;

        if (row == col) {
            this.diag += toAdd;

            if (Math.abs(this.diag) == n)
                return player;
        }

        if (row + col == n - 1) {
            this.antiDiag += toAdd;

            if (Math.abs(this.antiDiag) == n)
                return player;
        }

        return 0;
    }
}
