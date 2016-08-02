import java.util.Arrays;

/**
 * Created by adamli on 4/14/16.
 */
public class DedupKeepTwoArray {
    public static int[] dedupIncludeSlow(int[] input) {
        int len = input.length;

        if (len < 2)
            return input;

        // everything left of slow including slow has been de-duped with 2 identical int left
        int slow = 1;

        // fast: curr index
        for (int fast = 2; fast < len; fast++) {
            if (input[slow - 1] != input[fast]) {
                slow++;
                input[slow] = input[fast];
            }
        }

        return Arrays.copyOfRange(input, 0, slow + 1);
    }

    public static int[] dedupNotIncludeSlow(int[] input) {
        int len = input.length;

        if (len < 2)
            return input;

        // everything left of slow NOT including slow has been de-duped with 2 identical int left
        int slow = 2;

        // fast: curr index
        for (int fast = 2; fast < len; fast++) {
            if (input[slow - 2] != input[fast]) {
                input[slow] = input[fast];
                slow++;
            }
        }

        return Arrays.copyOfRange(input, 0, slow - 1);
    }
}
