/**
 * Created by adamli on 3/29/16.
 */
public class JumpGame {
    /**
     * starting from the end and check back, the number of check backs = input[i]
     * if any input[i-count] during check back is true, input[i] is reachable
     *
     * @param input game configuation
     * @return true or false
     */
    public static boolean jumpDPReverse(int[] input) {
        int len = input.length;

        // can input[i] reach the end?
        boolean[] m = new boolean[len];

        // initialization: the end can always reach itself
        m[len - 1] = true;

        // start from end-1 and check back
        for (int i = len - 2; i >= 0; i--) {
            // check all cells [count] steps back from input[i]
            for (int count = 1; count <= input[i]; count++) {
                // if not array out of bound
                if (i + count <= len - 1)
                    // input[i] can reach the end if input[i+count] can reach the end
                    m[i] = m[i + count];

                // if input[i] can reach the end in one of check backs, no need to check any further
                if (m[i] == true)
                    break;
            }
        }

        // can start reach the end?
        return m[0];
    }

    public static boolean jumpDP(int[] input) {
        int len = input.length;

        // can I jump from 0 to i?
        boolean[] m = new boolean[len];
        m[0] = true;

        // all ending position
        for (int i = 1; i < len; i++) {
            // all starting position to j
            for (int j = 0; j < i; j++) {
                /**
                 * two conditions for j to i is reachable
                 * 1. j is reachable
                 * 2. from input[0~i] there is a cell can jump to input[i]
                 */
                if (m[j] && (j + input[j] >= i)) {
                    m[i] = true;

                    // if one feasible solution is found, no need to check further
                    break;
                }
            }
        }

        // can I reach from 0 to end?
        return m[input.length - 1];
    }

    /**
     * Optimal solution
     * check for max reach at every single step
     *
     * @param input
     * @return
     */
    public static boolean jumpMaxReach(int[] input) {
        int maxReach = 0;
        for (int i = 0; i < input.length; i++) {
            // prev maxReach or current maxReach
            maxReach = Math.max(maxReach, i + input[i]);

            // if maxReach can reach the end, return true
            if (maxReach >= input.length - 1)
                return true;

            // if maxReach cannot go anyFurther than now, return false
            if (maxReach <= i)
                return false;
        }
        return true;
    }
}
