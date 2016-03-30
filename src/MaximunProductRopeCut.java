/**
 * Created by adamli on 3/28/16.
 */
public class MaximunProductRopeCut {
    public static int maxCutDP(int length) {
        // sanity check
        if (length <= 1)
            return length;

        /**
         * max product when cut in position i
         * from 0 to length
         */
        int m[] = new int[length+1];
        // pos 0 means no length, max = 0
        m[0] = 0;
        // pos 1 cannot be cut into two, max = 0
        m[1] = 0;

        /**
         * min rope length possible to cut in two is 2
         * 0~j left part
         * j~i length right part
         */
        for (int i = 2; i <= length; i++) {
            int local = 0;

            /**
             * optimization: j<= i/2, since left and right swaps value after half
             */
            for (int j = 1; j <= i / 2; j++) {
                /**
                 * left [0~j] two cases
                 * have cut in [0~j]: m[j]
                 * have no cut in [0~j]: j
                 */
                local = Math.max(m[j], j)
                        *
                        /**
                         * right [j~i] two case:
                         * have cut in [j~i]: m[i-j]
                         * no cut in [j~i]: i-j
                         */
                        Math.max(m[i - j], i - j);

                // update global max
                if (local > m[i]) {
                    m[i] = local;
                }
            }
        }

        return m[length];
    }

    public static int maxCutRecurrsive(int length) {
        // sanity check
        if (length <= 1)
            return length;

        return helper(length);
    }

    private static int helper(int currLen) {
        if (currLen == 1)
            return 0;

        int global = 0;
        for (int i = 1; i < currLen; i++) {
            /**
             * two cases for local max
             * 1. no cuts in (currLen - i) part, i * (currLen - i)
             * 2. at least one cut in (currLen - i) part, i * helper(currLen -i)
             */
            int local = i * Math.max(
                    currLen - i,
                    helper(currLen - i)
            );

            // update global max (or not)
            global = Math.max(global, local);
        }

        return global;
    }
}
