/**
 * Created by adamli on 5/31/16.
 */
public class GameOfLife {
    int m;
    int n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        if (m == 0 || n == 0)
            return;

        /**
         * state machine, first bit from left represent 1st state, 2nd from left is 2nd state
         * 00 = 0,  from dead to dead
         * 01 = 1, from alive to dead
         * 10 = 2, from dead to alife
         * 11 = 3, from alife to alive
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = calculate(board, i, j);
//                System.out.print(board[i][j] + " ");
            }
//            System.out.println();
        }

//        System.out.println();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int calculate(int[][] board, int i, int j) {
        int total = 0;

        total = addValue(board, i - 1, j - 1) + addValue(board, i - 1, j) + addValue(board, i, j - 1)
                + addValue(board, i + 1, j + 1) + +addValue(board, i, j + 1) + addValue(board, i + 1, j)
                + addValue(board, i + 1, j - 1) + addValue(board, i - 1, j + 1);

        /**
         * use &1 to pick 1st bit (1st state) from board only
         */
        if ((board[i][j] & 1) == 0) {
            if (total == 3)
                /**
                 * if 1st state is dead but surrounded by 3 live cells
                 * dead to alive is state code 2
                 */
                return 2;
            else
                /**
                 * else, stay dead
                 */
                return 0;
        } else {
            if (total < 2 || total > 3)
                /**
                 * alive but over / under populated
                 * alive to dead is state code 1
                 */
                return 1;
            else
                /**
                 * else, stay alive
                 */
                return 3;
        }
    }

    private int addValue(int[][] board, int i, int j) {
        if (i < 0 || j < 0)
            return 0;

        if (i >= m || j >= n)
            return 0;

        // when calculate total value, return 1st state only
        return board[i][j] & 1;
    }
}
