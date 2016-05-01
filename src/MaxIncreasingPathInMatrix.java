/**
 * Created by adamli on 5/1/16.
 */
public class MaxIncreasingPathInMatrix {
    int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int maxPath[][] = new int[m][n];

        // loop though all possible start position
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                /**
                 * only start calculating when start pos is not visited before
                 */
                if (maxPath[i][j] == 0)
                    helper(matrix, maxPath, i, j, new boolean[m][n], 1, Integer.MIN_VALUE);
            }
        }

        return max;
    }

    int helper(int matrix[][], int maxPath[][], int i, int j, boolean visited[][], int path, int prev) {
        // if out of bound, no additional path length should be add to current path
        if (!valid(i, j, matrix))
            return 0;

        // if out of bound, no additional path length should be add to current path
        if (visited[i][j])
            return 0;

        // add current node to path only if current pos value > prev pos value
        if (matrix[i][j] > prev) {
            /**
             * if this node is been visited for the first time, add current node into path length
             * DFS to update max path length start from current node
             */
            if (maxPath[i][j] == 0) {
                maxPath[i][j]++;

                // before DFS, mark curr pos in curr path visited
                visited[i][j] = true;

                // DFS to 4 directions
                int left = helper(matrix, maxPath, i, j - 1, visited, path, matrix[i][j]);
                int right = helper(matrix, maxPath, i, j + 1, visited, path, matrix[i][j]);
                int up = helper(matrix, maxPath, i - 1, j, visited, path, matrix[i][j]);
                int down = helper(matrix, maxPath, i + 1, j, visited, path, matrix[i][j]);

                // all path after curr pos is calculated, mark it back to unvisited
                visited[i][j] = false;

                // select max path from 4 directions and add to path
                int maxLR = Math.max(left, right);
                int maxUD = Math.max(up, down);
                path += Math.max(maxLR, maxUD);
                maxPath[i][j] = Math.max(maxPath[i][j], path);

                // update global max
                if (maxPath[i][j] > max)
                    max = maxPath[i][j];
            }

            // if max path length for this node is calculated already, return directly
            return maxPath[i][j];
        }else {
            return 0;
        }
    }

    // check if curr pos is out of bound
    boolean valid(int i, int j, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (i < 0 || j < 0)
            return false;

        if (i >= m)
            return false;

        if (j >= n)
            return false;

        return true;
    }
}
