import java.util.PriorityQueue;

/**
 * Created by adamli on 4/17/16.
 */
public class KthLargestElementInAnArray {
    /**
     * method 1: pq
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargestPQ(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return -1;

        // defualt priority queue is min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }

        return pq.peek();
    }

    /**
     * method 2: quick select
     *
     * @param nums
     * @param k
     * @return
     */

    public static int findKthLargestQuickSelect(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }

        /**
         * look for 2nd largest in 6 elements
         * its index in sorted array is 4
         */
        int targetInd = (nums.length - 1) - k + 1;
        return helper(nums, 0, nums.length - 1, targetInd);
    }

    // recursively passing down l and r limit until we hit target index
    private static int helper(int[] nums, int l, int r, int targetInd) {
        int index = partition(nums, l, r);

        // if we limit our range to target index, return
        if (index == targetInd)
            return nums[index];
        else if (index < targetInd)
            // if return index < target index, cut the left range to index + 1
            return helper(nums, index + 1, r, targetInd);
        else
            // if return index > target index, cut the right range to index - 1
            return helper(nums, l, index - 1, targetInd);

    }

    private static int partition(int nums[], int l, int r) {
        /**
         * if left bound = right bound, return current pos
         */
        if (l == r)
            return l;

        int pivot = nums[l];

        while (l < r) {
            // start from right and find first element < pivot
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            // put the first "smaller element in right" to left
            nums[l] = nums[r];

            // find the first ele > pivot from left
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            // put the first smaller element to the right
            nums[r] = nums[l];
        }

        nums[l] = pivot;
        return l;
    }
}
