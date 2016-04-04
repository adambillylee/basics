public class UniquePathsII {
    public static int uniquePathsWithObstacles2D(int[][] obstacleGrid) {
        // unique path # from origin to cell i,j
        int[][]M = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i=0; i<obstacleGrid.length; i++) {
            for (int j=0; j<obstacleGrid[0].length; j++) {
                // if this cell is an obstacle, 0 path from origin to here
                if (obstacleGrid[i][j] == 1) {
                    M[i][j] = 0;
                    continue;
                }

                // if origin is not an obstacle, there is one path from origin to itself
                if (i == 0 && j == 0) {
                    M[i][j] = 1;
                    continue;
                }

                int left = 0;
                int top = 0;

                // if left cell exist, all path from left = all path from left from left cell
                if (j-1>=0)
                    left = M[i][j-1];

                // if top cell exist, all path from top = all path from top from top cell
                if (i-1>=0)
                    top = M[i-1][j];

                // total unique path to i,j = path from left + path from top
                M[i][j] = left + top;
            }
        }

        return M[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    /**
     * As M is filled from top down, top of M[i+1][j] is always value from M[i][j]
     * Use M[j] from previous iteration to represent top value
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles1D(int[][] obstacleGrid) {
        int[]M = new int[obstacleGrid[0].length];

        for (int i=0; i<obstacleGrid.length; i++) {
            // if this cell is an obstacle, 0 path from origin to here
            for (int j=0; j<obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    M[j] = 0;
                    continue;
                }

                // if origin is not an obstacle, there is one path from origin to itself
                if (i == 0 && j == 0) {
                    M[j] = 1;
                    continue;
                }

                int left = 0;

                // carry top from previous iteration
                int top = M[j];

                // if left cell exist, all path from left = all path from left from left cell
                if (j-1>=0)
                    left = M[j-1];

                // total unique path to i,j = path from left + path from top
                M[j] = left + top;
            }
        }

        return M[obstacleGrid[0].length-1];
    }
}