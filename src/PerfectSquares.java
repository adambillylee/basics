/**
 * Created by adamli on 6/2/16.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        if (n < 0)
            return 0;

        if (n < 1)
            return n;

        // largest sqr which its square <= n
        int sqr[] = new int[n + 1];

        // min number of perfect square adds up to n
        int min[] = new int[n + 1];

        // for 0, max perfect square root is 0
        sqr[0] = 0;
        for (int i = 1; i <= n; i++) {
            // check the square of current sqr + 1
            int nextSq = (sqr[i - 1] + 1) * (sqr[i - 1] + 1);

            /**
             * if current number is still smaller than next perfect square
             */
            if (nextSq > i) {
                // max square root stays the same
                sqr[i] = sqr[i - 1];

                // initialize the minimum count with i (the number consists of all 1's)
                min[i] = i;

                /**
                 * loop through all valid square roots with square < current number
                 */
                for (int j = 1; j * j < i; j++) {
                    /**
                     * find the perfect square count with root = j
                     */
                    int tmp = min[i - j * j] + min[j * j];

                    // keep updating the min count
                    if (tmp < min[i])
                        min[i] = tmp;
                }
            } else {
                // if i = next perfect square, update the square root
                sqr[i] = sqr[i - 1] + 1;

                // current min perfect square count = 1 ( i = max valid square root ^ 2)
                min[i] = 1;
            }
        }

        return min[n];
    }
}
