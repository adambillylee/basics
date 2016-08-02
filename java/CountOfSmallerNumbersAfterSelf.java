import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 6/15/16.
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums.length == 0 || nums == null)
            return rst;

        List<Integer> tmp = new ArrayList<>();
        /**
         * starting from the end of the array
         * use binary search to find the insert position of nums[i] in a new rst array
         */
        for (int i = nums.length - 1; i >= 0; i--) {
            // the insert position is the smaller number count on left in original for nums[i]
            int ind = findInsertPos(nums[i], tmp);

            // use tmp list to keep the values of inserted nums to continue search
            tmp.add(ind, nums[i]);

            // add insert position (smaller number count on left in original array into result list)
            rst.add(0, ind);
        }

        return rst;
    }

    /**
     * binary search looking for insert position of num in list tmp
     *
     * @param num number to insert
     * @param tmp list of numbers to insert into
     * @return insert position
     */
    private int findInsertPos(int num, List<Integer> tmp) {
        int start = 0;
        int end = tmp.size() - 1;

        while (start <= end) {
            /**
             * when start == end
             * the insert position is at start +1
             * which is mid +1 in this case
             */
            int mid = start + (end - start) / 2;

            if (num > tmp.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
