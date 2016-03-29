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
    public static boolean jump(int[] input) {
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
}
