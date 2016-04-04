public class UniquePaths {
    public static int uniquePaths2D(int m, int n) {
        /**
         * unique path # from 0,0 to m,n
         */
        int M[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /**
                 * initialization:
                 * first row and first col both have only 1 path
                 */
                if (i == 0 || j == 0) {
                    M[i][j] = 1;
                    continue;
                }


                int left = 0;
                int top = 0;

                /**
                 * if j-1<0 out of bound, nothing can come from left and left = 0
                 */
                if (j - 1 >= 0)
                    // all unique paths coming from left
                    left = M[i][j - 1];

                /**
                 * if i-1<0 out of bound, nothing can come from top and top=0
                 */
                if (i - 1 >= 0)
                    // all unique pathes coming from top
                    top = M[i - 1][j];

                // current unique path some = path from left + path from top    
                M[i][j] = left + top;
            }
        }

        return M[m - 1][n - 1];
    }

    public static int uniquePaths1D(int m, int n) {
        // only has one row
        int M[] = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    M[j] = 1;
                }

                // carry top unique path from top
                int top = M[j];
                int left = 0;

                /**
                 * if left is not out of bound (j-1 >= 0)
                 * unique path from left = unique path # from left at left
                 */
                if (j - 1 >= 0)
                    left = M[j-1];

                M[j] = left + top;
            }
        }

        return M[n-1];
    }
}