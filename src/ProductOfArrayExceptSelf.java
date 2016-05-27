/**
 * Created by adamli on 5/27/16.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;

        int rst[] = new int[nums.length];

        /**
         * First scan from the left:
         * rst = prod of all numbers on the left (exclusive up to i)
         * +---------+---+---+---+---+
         | nums[i] | 1 | 2 | 3 | 4 |
         +---------+---+---+---+---+
         | rst     | 1 | 1 | 2 | 6 |
         +---------+---+---+---+---+
         */
        rst[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            rst[i] = rst[i - 1] * nums[i - 1];
        }

        /**
         * Second scan from the right:
         * prod = prod of all numbers on the right (exclusive down to i)
         * rst = previous rst * prod
         * +------+------+-----+-----+---------+
         | 1    | 2    | 3   | 4   | nums[i] |
         +------+------+-----+-----+---------+
         | 24   | 12   | 4   | 1   | prod    |
         +------+------+-----+-----+---------+
         | 24*1 | 12*1 | 4*2 | 6*1 | rst[i]  |
         +------+------+-----+-----+---------+
         *
         */
        int prod = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rst[i] *= prod;
            prod *= nums[i];
        }

        return rst;
    }
}
