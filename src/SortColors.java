/**
 * Created by adamli on 5/19/16.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;

        while (k <= j) {
            int curr = nums[k];

            if (curr == 0) {
                swap(nums, k, i);
                i++;
                k++;
            } else if (curr == 2) {
                swap(nums, k, j);
                j--;
            } else {
                k++;
            }
        }
    }

    private void swap(int nums[], int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}