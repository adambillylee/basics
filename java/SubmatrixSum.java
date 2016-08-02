/**
 * Created by adamli on 7/19/16.
 */
public class SubmatrixSum {
    /**
     * @param matrix
     * @return
     */
    public int submatrixSum(int[][] matrix, int left, int top, int right, int bottom) {
        if (matrix.length == 0 || matrix == null)
            return 0;
        if (matrix[0].length == 0)
            return 0;

        int M = matrix.length;
        int N = matrix[0].length;

        int sum[][] = new int[M+1][N+1];

        for (int j = 0; j <= N; j++) {
            sum[0][j] = 0;
        }

        for (int i = 0; i <= M; i++) {
            sum[i][0] = 0;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sum[i+1][j+1] = matrix[i][j] + sum[i+1][j] + sum[i][j+1] - sum[i][j];
            }
        }

        return sum[right+1][bottom+1] - sum[top][right+1] - sum[left][bottom+1] + sum[top][left];
    }
}
