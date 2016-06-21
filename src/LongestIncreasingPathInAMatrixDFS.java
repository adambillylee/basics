/**
 * Created by adamli on 6/20/16.
 */
public class LongestIncreasingPathInAMatrixDFS {
    int max = 0;
    int m = 0;
    int n = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null | matrix.length == 0 || matrix[0].length == 0)
            return 0;

        m = matrix.length;
        n = matrix[0].length;

        int path[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(matrix, path, i, j, Integer.MIN_VALUE);
                max = Math.max(path[i][j], max);
            }
        }
        return max;
    }

    private int helper(int[][] matrix, int[][] path, int i, int j, int prev) {
        if (i < 0 || j < 0)
            return 0;

        if (i >= m || j >= n)
            return 0;

        if (matrix[i][j] <= prev)
            return 0;

        if (path[i][j] > 0)
            return path[i][j];

        path[i][j] = 1;

        int up = helper(matrix, path, i - 1, j, matrix[i][j]);
        int down = helper(matrix, path, i + 1, j, matrix[i][j]);
        int left = helper(matrix, path, i, j - 1, matrix[i][j]);
        int right = helper(matrix, path, i, j + 1, matrix[i][j]);

        int maxUD = Math.max(up, down);
        int maxLR = Math.max(left, right);
        path[i][j] += Math.max(maxUD, maxLR);

        return path[i][j];
    }
}
