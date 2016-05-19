/**
 * Created by adamli on 5/19/16.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty())
            return 0;

        /**
         * way to decode first ith char from s
         */
        int dp[] = new int[s.length() + 1];

        // empty string has 1 way of decoding
        dp[0] = 1;

        // for all string ends at ith char in s
        for (int i = 1; i <= s.length(); i++) {
            // for all previous location before ith char in s
            for (int j = i - 1; j >= i - 2; j--) {
                // if this previous position is out of bound, skip
                if (j < 0)
                    continue;

                /**
                 * get string from ith char to jth char
                 * which is index j-1+1(inclusive) ~ i-1+1 (exclusive)
                 */
                String curr = s.substring(j, i);

                // if string up to jth char in S is decode-able and curr string is valid
                if (dp[j] > 0 && valid(curr)) {
                    /**
                     * for each of the decode way of j, there is a corresponding decode way of i
                     * there could be many valid j's, so add dp[i] by dp[j]
                     */
                    dp[i] += dp[j];
                }
            }
        }

        return dp[s.length()];
    }

    boolean valid(String curr) {
        /**
         * empty string not decode-able
         */
        if (curr.isEmpty())
            return false;

        // number with leading 0 is not valid
        if (curr.charAt(0) == '0')
            return false;

        int number = Integer.parseInt(curr);

        // number is valid between 1~26
        if (number < 0 || number > 26)
            return false;

        return true;
    }
}
