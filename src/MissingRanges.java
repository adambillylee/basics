import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 6/29/16.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> rst = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            /**
             * BUG POINT:
             * if input is end, lower -> upper bound will be missing range
             */
            addResult(rst, lower, upper);
            return rst;
        }

        if (nums[0] > lower) {
            int start = lower;
            int end = nums[0] - 1;

            addResult(rst, start, end);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                int start = nums[i - 1] + 1;
                int end = nums[i] - 1;
                addResult(rst, start, end);
            }
        }

        if (nums[nums.length - 1] < upper) {
            int start = nums[nums.length - 1] + 1;
            int end = upper;
            addResult(rst, start, end);
        }

        return rst;
    }

    private void addResult(List<String> rst, int start, int end) {
        if (start == end)
            rst.add(String.valueOf(start));
        else {
            rst.add(start + "->" + end);
        }
    }
}