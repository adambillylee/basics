import java.util.Arrays;

/**
 * Created by adamli on 8/20/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        boolean nums[] = new boolean[9];

        // check each rows
        for (int i = 0; i < 9; i++) {
            Arrays.fill(nums, false);
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if (c != '.') {
                    if (nums[c - '1']) {
                        return false;
                    } else {
                        nums[c - '1'] = true;
                    }
                }
            }
        }

        // check each columns
        for (int j = 0; j < 9; j++) {
            Arrays.fill(nums, false);
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];

                if (c != '.') {
                    if (nums[c - '1']) {
                        return false;
                    } else {
                        nums[c - '1'] = true;
                    }
                }
            }
        }

        // check cube
        // use i and j to loop across each cube
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(nums, false);

                // use x and y to loop inside each cube
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        char c = board[i + x][j + y];
                        if (c != '.') {
                            if (nums[c - '1']) {
                                return false;
                            } else {
                                nums[c - '1'] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}