/**
 * Created by adamli on 5/19/16.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int afterFirst0 = 0;
        int beforeFirst2 = nums.length - 1;
        int cursor = 0;

        while (cursor <= beforeFirst2) {
            int curr = nums[cursor];

            if (curr == 0) {
                swap(nums, cursor, afterFirst0);
                afterFirst0++;
                cursor++;
            } else if (curr == 2) {
                swap(nums, cursor, beforeFirst2);
                beforeFirst2--;
            } else {
                cursor++;
            }
        }
    }

    private void swap(int nums[], int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}