/**
 * Created by adamli on 4/7/16.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int counter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    counter++;
                }
            }
        }

        return counter;
    }

    static void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0)
            return;

        if (i >= grid.length || j >= grid[0].length)
            return;

        if (grid[i][j] == '$')
            return;

        if (grid[i][j] == '0')
            return;

        grid[i][j] = '$';

        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
    }
}
