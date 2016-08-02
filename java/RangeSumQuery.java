/**
 * Created by adamli on 5/25/16.
 */
public class RangeSumQuery {
    int sum[];

    public RangeSumQuery(int[] nums) {
        if (nums.length >0)
            sum = new int[nums.length];
        else
            return;

        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return sum[j];

        return sum[j] - sum[i-1];
    }
}
