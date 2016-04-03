import java.util.Arrays;

/**
 * Created by adamli on 4/2/16.
 */
public class LargestSumOfSubArray {
    public static int[] LargestSumOfSubArray(int[] input) {
        if (input == null || input.length == 0)
            return input;

        // mark curr max sum in this iteration
        int curr = input[0];
        // mark prev max sum
        int prev = curr;
        // global max sum from 0 to i
        int max = 0;

        // mark start and end pos of input
        int start = 0;
        int end = 0;

        for (int i = 1; i < input.length; i++) {
            int currStart = start;
            int currEnd = end;

            /**
             * two cases:
             * 1. if prev doesn't bring positive contribution to curr, start with input[i]
             * 2. if prev > 0 and bring positive contribution to curr, bring prev into curr (prev + input[i])
             */
            if (prev < 0) {
                curr = input[i];
                currStart = i;
            } else {
                curr = input[i] + prev;
            }

            currEnd = i;

            if (curr > max) {
                max = curr;
                start = currStart;
                end = currEnd;
            }
        }

        // copyOfRange(input, start, end+1), to index is exclusive
        return Arrays.copyOfRange(input, start, end + 1);
    }
}
