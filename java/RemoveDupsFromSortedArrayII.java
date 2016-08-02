/**
 * Created by adamli on 7/18/16.
 */
public class RemoveDupsFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        /**
         * count represent number of dup elements before (not including l)
         */
        int count = 1;
        int l = 1, r = 1;
        while (r < nums.length) {
            /**
             * use r to explore forward
             * 2 cases to rewrite left with right and move left forward
             */
            if (nums[r] == nums[r - 1]) {
                if (count < 2) {
                    /**
                     * case one, there are already enough dups before left
                     */
                    nums[l++] = nums[r];
                    count++;
                }
            } else {
                /**
                 * case two: nums[r] is a new element, we always need to bring new element back
                 */
                nums[l++] = nums[r];
                count = 1;
            }

            r++;
        }

        return l;
    }
}
