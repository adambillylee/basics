public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0  || board[0].length == 0 || word.length() == 0)
            return false;

        char[] chars = word.toCharArray();

        // generate starting point
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (helper(board, chars, 0, i, j))
                    return true;
            }
        }

        return false;
    }

    public boolean helper(char[][] board, char[] chars, int index, int row, int col) {
        int[] cord = {row, col};

        if (index == chars.length)
            return true;

        if (row<0 || col<0)
            return false;

        if (row>=board.length || col >= board[0].length)
            return false;

        if (chars[index] != board[row][col])
            return false;

        if (board[row][col] == '$')
            return false;

        char origin = board[row][col];
        board[row][col] = '$';

        // can we go up?
        if (helper(board, chars, index+1, row-1, col))
            return true;

        // can we go down?
        if (helper(board, chars, index+1, row+1, col))
            return true;

        // can we go left?
        if (helper(board, chars, index+1, row, col-1))
            return true;

        // can we go right?
        if (helper(board, chars, index+1, row, col+1))
            return true;

        board[row][col] = origin;
        return false;
    }
}