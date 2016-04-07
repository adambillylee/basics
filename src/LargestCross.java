/**
 * Created by adamli on 4/5/16.
 */
public class LargestCross {
    public static int findCross(int[][] input) {
        int m = input.length;
        int n = input[0].length;

        /**
         * longest cross arm length centered at i,j
         */
        int[][] M1 = new int[m][n]; //l->r
        int[][] M2 = new int[m][n]; //r->l
        int[][] M3 = new int[m][n]; //t->d
        int[][] M4 = new int[m][n]; //d->t

        int max = 0;

        // left to right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    M1[i][j] = input[i][j];
                    continue;
                }

                if (input[i][j] == 1)
                    M1[i][j] = M1[i][j - 1] + input[i][j];
            }
        }

        // right to left
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    M2[i][j] = input[i][j];
                    continue;
                }

                if (input[i][j] == 1)
                    M2[i][j] = M2[i][j + 1] + input[i][j];
            }
        }

        // top to down
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    M3[i][j] = input[i][j];
                    continue;
                }

                if (input[i][j] == 1)
                    M3[i][j] = M3[i - 1][j] + input[i][j];
            }
        }

        // down to top
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (i == m - 1) {
                    M4[i][j] = input[i][j];
                    continue;
                }

                if (input[i][j] == 1)
                    M4[i][j] = M4[i + 1][j] + input[i][j];
            }
        }

        // find min in for matrices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M1[i][j] = Math.min(Math.min(M1[i][j], M2[i][j]), Math.min(M3[i][j], M4[i][j]));

                if (max < M1[i][j])
                    max = M1[i][j];
            }
        }

        return max;
    }
}
