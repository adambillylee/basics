import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 5/2/16.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort elements to make dedup work
        Arrays.sort(nums);

        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        /**
         * always move all cursors to last element of dup if possible
         */
        for (int left = 0; left < nums.length; left++) {
            /**
             * if this left is already handled, just skip it
             */
            if (left - 1 >= 0 && nums[left] == nums[left - 1])
                continue;

            int mid = left + 1;
            int right = nums.length - 1;

            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];

                if (sum == 0) {
                    rst.add(Arrays.asList(nums[left], nums[mid], nums[right]));

                    // if mid is on duplicate, move mid to as right as possible (<right)
                    while (mid + 1 < right && nums[mid] == nums[mid + 1])
                        mid++;

                    // if right is on duplicate, move right to as leff as possible (>left)
                    while (right - 1 > left && nums[right] == nums[right - 1])
                        right--;

                    mid++;
                    right--;
                } else if (sum < 0) {
                    mid++;
                } else {
                    right--;
                }
            }
        }

        return rst;
    }
}
