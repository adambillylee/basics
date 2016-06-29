import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 6/29/16.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return rst;

        if (nums.length == 1) {
            rst.add(String.valueOf(nums[0]));
            return rst;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                addResult(rst, start, end);
                start = nums[i];
                end = nums[i];
            }
        }

        addResult(rst, start, end);

        return rst;
    }

    private void addResult(List<String> rst, int start, int end) {
        if (start == end) {
            rst.add(String.valueOf(start));
        } else {
            rst.add(start + "->" + end);
        }
    }
}