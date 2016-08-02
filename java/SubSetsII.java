import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 6/5/16.
 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        Arrays.sort(nums);
        if (nums.length == 0)
            return rst;

        helper(rst, new ArrayList<>(), nums, 0);

        return rst;
    }

    private void helper(List<List<Integer>> rst, ArrayList<Integer> list, int[] nums, int index) {
        rst.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            list.add(nums[i]);
            helper(rst, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
