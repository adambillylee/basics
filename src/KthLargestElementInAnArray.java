import java.util.PriorityQueue;

/**
 * Created by adamli on 4/17/16.
 */
public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
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
}
