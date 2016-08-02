import java.util.Arrays;

/**
 * Created by adamli on 4/14/16.
 */
public class DedupSortedKeepOneArray {
    public static int[] dedup(int[] input) {
        /**
         * 0~slow deduped part, include slow
         * slow~fast dupe part, exclude slow include  fast
         * fast~end unknown
         */
        int slow = 0;
        int fast = 1;
        int len = input.length;

        while (fast < len) {
            if (input[slow] == input[fast]) {
                fast++;
            } else {
                slow++;
                input[slow] = input[fast];
                fast++;
            }
        }

        return Arrays.copyOfRange(input, 0, slow + 1);
    }
}
