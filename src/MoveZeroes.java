/**
 * Created by adamli on 5/26/16.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums.length ==0)
            return;

        // j: first non-zero element
        int j = 0;
        for (int i=0; i<nums.length; i++) {
            // when met a non zero element, swap to to the front
            if (nums[i] != 0) {
                swap(nums, i, j);

                // move j forward
                j++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
