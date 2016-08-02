/**
 * Created by adamli on 7/6/16.
 */
public class heapSortZeroBased {

    public int[] heapSort(int nums[]) {
        if (nums.length == 0 || nums == null)
            return nums;

        int len = nums.length;

        /**
         * because we are looking for the last "father", so we must be swifting down
         */
        int lastFather = (len - 2) / 2;

        /**
         * BUG POINT 1: define a last index instead of current size
         * making swiftDown easier
         */
        int lastInd = len - 1;
        for (int i = lastFather; i >= 0; i--) {
            swiftDown(nums, i, lastInd);
        }

        int rst[] = new int[len];
        for (int i = 0; i < len; i++) {
            rst[i] = nums[0];
            swap(nums, 0, lastInd);
            lastInd--;
            swiftDown(nums, 0, lastInd);
        }

        return rst;
    }

    private void swiftDown(int[] nums, int i, int lastInd) {
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        /**
         * BUG POINT 2:
         * compare min with left or right, not i with left or right
         * make sure num[min] is the smallest between i, left and right
         */
        if (left <= lastInd && nums[min] > nums[left]) {
            min = left;
        }

        if (right <= lastInd && nums[min] > nums[right]) {
            min = right;
        }

        if (min != i) {
            swap(nums, i, min);
            swiftDown(nums, min, lastInd);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
