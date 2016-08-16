/**
 * Created by adamli on 8/13/16.
 */
public class MatrixSpiralPrint {
    public void printSpiralMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int M = matrix.length;
        int N = matrix[0].length;

        int rs = 0;
        int re = M - 1;
        int cs = 0;
        int ce = N - 1;


        while (true) {
            // upper
            for (int i = cs; i <= ce; i++) {
                System.out.print(matrix[rs][i] + " ");
            }
            rs++;

            if (rs > re)
                return;

            // right
            for (int i = rs; i <= re; i++) {
                System.out.print(matrix[i][ce] + " ");
            }
            ce--;

            if (cs > ce)
                return;

            // bottom
            for (int i = ce; i >= cs; i--) {
                System.out.print(matrix[re][i] + " ");
            }
            re--;

            if (rs > re)
                return;

            // left
            for (int i = re; i >= rs; i--) {
                System.out.print(matrix[i][cs] + " ");
            }
            cs++;

            if (cs > cs)
                return;
        }
    }
}
