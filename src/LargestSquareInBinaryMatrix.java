/**
 * Created by adamli on 4/7/16.
 */
public class LargestSquareInBinaryMatrix {
    public int findLargestMatrix(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] M = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    M[i][j] = input[i][j];
                    continue;
                }

                if (input[i][j] == 1) {

                } else {
                    M[i][j] = 0;
                }
            }
        }

        return max;
    }
}
