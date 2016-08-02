import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)
            return 0;

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        };
        Arrays.sort(envelopes, comparator);

        int dp[] = new int[envelopes.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }
}