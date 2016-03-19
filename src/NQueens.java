import java.util.ArrayList;

/**
 * Created by adamli on 3/19/16.
 */
public class NQueens {
    public static ArrayList<int[]> NQueens(int n) {
        if (n < 2) {
            System.out.println("n<2");
        }

        int[] board = new int[n];

        ArrayList<int[]> rst = new ArrayList<>();
        helper(rst, board, 0, n);

        return rst;
    }

    static void helper(ArrayList<int[]> rst, int[] board, int currRow, int n) {
        /**
         * base case:
         * based on currRow
         */
        if (currRow == n) {
            drawBoard(board);
            rst.add(board.clone());
            return;
        }

        /**
         * each layer has n choices (each row has n columns)
         * recursion call in loop for n-branch recursion tree
         */
        for (int currCol = 0; currCol < n; currCol++) {
            boolean isAttacked = false;
            /**
             * check all existing column on board to validate current queen position
             */
            for (int existingRow = 0; existingRow < currRow; existingRow++) {
                isAttacked = isAttacked(existingRow, board[existingRow], currRow, currCol);

                if (isAttacked)
                    break;
            }

            if (!isAttacked) {
                // if not attacked, add current queen onto board
                board[currRow] = currCol;
                // go to next recursion level
                helper(rst, board, currRow + 1, n);

                /**
                 * base case is based on currRow but currRow+1 on next level doesn't change currRow value
                 * on this level after return, no operation needed to "put it back to previous state" after returning
                 * from next level
                 */
            }
        }
    }

    static boolean isAttacked(int r1, int c1, int r2, int c2) {
        // if two queen on same col, they are attacking each other
        if (c1 == c2)
            return true;

        // if slope = 1, attacking each other
        if (Math.abs(r1 - r2) == Math.abs(c1 - c2))
            return true;

        return false;
    }

    static void drawBoard(int[] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[i] != j) {
                    System.out.print("i ");
                }else{
                    System.out.print("Q ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
