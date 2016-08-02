public class ClimbStairs {
    public static int climbStairs(int n) {
        // ways to top to stair n
        int M[] = new int[n+1];

        for (int i=0; i<=n; i++) {
            // one way to climb to stair 1, period
            if (i<=1) {
                M[i] = 1;
                continue;
            }

            // ways to get to i-1
            int minus1 = M[i-1];
            // ways to get to i-2
            int minus2 = M[i-2];

            // total ways to get to i from i-1 and i-2
            M[i] = minus1 + minus2;
        }

        return M[n];
    }
}