public class ClimbStairs {
    public static int climbStairs(int n) {
        // ways to top to stair n
        int M[] = new int[n+1];

        for (int i=0; i<=n; i++) {
            if (i<=1) {
                M[i] = 1;
                continue;
            }

            int minus1 = M[i-1];
            int minus2 = M[i-2];

            M[i] = minus1 + minus2;
        }

        return M[n];
    }
}