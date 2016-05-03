import java.util.HashMap;

/**
 * Created by adamli on 5/1/16.
 */
public class MaxSizeSubArraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        int len = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int missing = sum - k;

            if (missing == 0)
                len = i + 1;

            if (map.containsKey(missing)) {
                len = Math.max(len, i - map.get(missing));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }
}
