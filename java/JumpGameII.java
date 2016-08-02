/**
 * Created by adamli on 3/29/16.
 */

/**
 * minimum jump to reach the end
 */
public class JumpGameII {
    public static int jumpDPReverse(int[] input) {
        // min jump from input[i] to end
        int m[] = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            m[i] = Integer.MAX_VALUE;
        }

        m[input.length - 1] = 0;

        for (int i = input.length - 2; i >= 0; i--) {
            for (int count = input[i]; count > 0; count--) {
                if (i + count < input.length) {
                    m[i] = Math.min(m[i], m[i + count] + 1);
                }
            }
        }

        return m[0];
    }

    public static int jumpDP(int[] input) {
        // min jump from 0 to i
        int m[] = new int[input.length];
        m[0] = 0;

        for (int i = 1; i < input.length; i++) {
            // if not initialized yet, initialize min jump to INFINITY
            if (m[i] == 0 && i != 0)
                m[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                /**
                 * if i is reachable from j, try updating m[i] value
                 * two conditions:
                 * 1. m[j] is reachable from 0 (m[j] is not infinity)
                 * 2. somewhere in [0~j] can jump after i (j + input[j] >=i)
                 */
                if (m[j] != Integer.MAX_VALUE && j + input[j] >= i) {
                    m[i] = Math.min(m[i], m[j] + 1);
                }
            }
        }

        return m[input.length - 1];
    }

    public static int jumpGreedy(int[] input) {
        return 1;
    }
}
