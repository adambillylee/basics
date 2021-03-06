/**
 * Created by adamli on 3/23/16.
 */
public class LongestAscendingSubArray {
    public static int getLength(int[] input) {
        if (input.length == 0)
            return 0;

        /**
         * check back all input upto now, whats the max inc. subarray length
         */
        int global = 1;

        /**
         * within this iteration and prev iteration, whats the max length
         */
        int local = 1;
        /**
         * recursive relation
         */
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[i - 1]) {
                local++;
                global = Math.max(global, local);
            } else {
                local = 1;
            }
        }

        return global;
    }
}
