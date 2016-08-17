/**
 * Created by adamli on 8/15/16.
 */
public class CoinsInALine {
    public int calculate(int[] values) {
        int len = values.length;

        if (len == 1)
            return values[0];

        int dp[][] = new int[len][len];
        int sum[][] = new int[len][len];

        // calculate sum
        calculateSum(values, len, sum);

        for (int start = len - 1; start >= 0; start--) {
            for (int end = start; end < len; end++) {
                if (start == end) {
                    dp[start][end] = values[end];
                } else {
                    int opponentMax = Math.min(dp[start + 1][end], dp[start][end - 1]);
                    dp[start][end] = sum[start][end] - opponentMax;
                }
            }
        }

        return dp[0][len - 1];
    }

    private void calculateSum(int[] values, int len, int[][] sum) {
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    sum[i][j] = values[j];
                } else {
                    sum[i][j] = sum[i][j - 1] + values[j];
                }
            }
        }
    }
}
