import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by adamli on 7/21/16.
 */
public class findRightMostNumberLessThanCurrent {
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public int[] findArray(int[] nums) {
        int[] rst = new int[nums.length];

        int i = 0;
        while (i < nums.length) {
            cleanStack(nums, rst, i);
            stack.push(i++);
        }

        stack.clear();
        return rst;
    }

    private void cleanStack(int[] nums, int[] rst, int i) {
        while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            rst[i] = -1;
        } else {
            rst[i] = nums[stack.peek()];
        }
    }
}
