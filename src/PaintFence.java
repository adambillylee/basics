/**
 * Created by adamli on 6/23/16.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        int[] same2 = new int[n + 1];
        int[] diff2 = new int[n + 1];

        same2[2] = k;
        diff2[2] = k * (k - 1);

        for (int i = 3; i <= n; i++) {
            same2[i] = diff2[i - 1];
            diff2[i] = (diff2[i - 1] + same2[i - 1]) * (k - 1);
        }

        return same2[n] + diff2[n];
    }
}
