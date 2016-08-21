/**
 * Created by adamli on 8/20/16.
 */
public class SudokuSolver {
    // horizontal[i][j] = is number j exist in row i
    private boolean[][] horizontal = new boolean[9][9];

    // vertical[i][j] = is number j exist in col i
    private boolean[][] vertical = new boolean[9][9];

    // square[i][j] = is number j exist in position i
    private boolean[][] square = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        isValidSudoku(board);
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        // entire matrix finished, return true
        if (i >= 9)
            return true;

        // entire row finished, change row
        if (j >= 9)
            return dfs(board, i + 1, 0);

        // start trying numbers when char = '.'
        if (board[i][j] == '.') {
            boolean[] current = new boolean[9];

            // flatten out 2D position to 1D array
            int index = (i / 3) * 3 + (j / 3);

            // use k to loop through numbers to try
            for (int k = 0; k < 9; k++) {
                // check if k is valid in current cell
                current[k] = horizontal[i][k] || vertical[j][k] || square[index][k];

                // dfs
                if (!current[k]) {
                    // set cell i, j value to be k
                    board[i][j] = (char) ('1' + k);
                    horizontal[i][k] = vertical[j][k] = square[index][k] = true;

                    if (dfs(board, i, j + 1))
                        return true;

                    // unset
                    board[i][j] = '.';
                    horizontal[i][k] = vertical[j][k] = square[index][k] = false;
                }
            }

            return false;
        } else {
            return dfs(board, i, j + 1);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int index = (i / 3) * 3 + (j / 3);
                int num = board[i][j] - '1';

                if (horizontal[i][num] || vertical[j][num] || square[index][num])
                    return false;

                horizontal[i][num] = vertical[j][num] = square[index][num] = true;
            }
        }

        return true;
    }
}
