/**
 * Created by adamli on 6/23/16.
 */
public class PaintFence {
    public int numWaysON(int n, int k) {
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

    public int numWays(int n, int k) {
        // if there is no fence or color, there is 0 ways to paint
        if (n == 0 || k == 0)
            return 0;

        // if there is only one fence, there are k ways to paint
        if (n == 1)
            return k;

        int same2 = k;
        int diff2 = k * (k - 1);

        for (int i = 2; i < n; i++) {
            int tmp = same2;
            same2 = diff2;
            diff2 = tmp * (k-1) + diff2 * (k-1);
        }

        return same2 + diff2;
    }
}
