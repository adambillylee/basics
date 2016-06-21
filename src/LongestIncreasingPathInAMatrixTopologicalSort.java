import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 6/20/16.
 */
public class LongestIncreasingPathInAMatrixTopologicalSort {
    public int longestIncreasingPath(int[][] matrix) {
        class Pair {
            int i;
            int j;

            Pair(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int M = matrix.length;
        int N = matrix[0].length;
        int remaining = M * N;
        int rst = 0;


        while (remaining > 0) {
            List<Pair> remove = new ArrayList<>();
            System.out.format("round %d\n", rst);

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == Integer.MIN_VALUE)
                        continue;

                    boolean greaterThanTop = (i == 0 || matrix[i][j] >= matrix[i - 1][j]);
                    boolean greaterThanBottom = (i == M - 1 || matrix[i][j] >= matrix[i + 1][j]);
                    boolean greaterThanLeft = (j == 0 || matrix[i][j] >= matrix[i][j - 1]);
                    boolean greaterThanRight = (j == N - 1 || matrix[i][j] >= matrix[i][j + 1]);

                    if (greaterThanTop && greaterThanBottom && greaterThanLeft && greaterThanRight)
                        remove.add(new Pair(i, j));
                }
            }

            for (Pair pair : remove) {
                System.out.format("remove matrix[%d][%d] : %d\n", pair.i, pair.j, matrix[pair.i][pair.j]);
                matrix[pair.i][pair.j] = Integer.MIN_VALUE;
                remaining--;
            }

            rst++;
            System.out.println();
        }

        return rst;
    }
}
