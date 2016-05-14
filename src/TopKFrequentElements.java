import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adamli on 5/14/16.
 */
public class TopKFrequentElements {
    /**
     * bucket sort to find top K
     * Example: {1, 1, 2, 2, 3, 3, 4, 5, 6, 1}, find top 3
     *
     * @param nums input numbers
     * @param k    number of top frequencies to return
     * @return list of number of top k frequency
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // build a frequency map, O(N)
        Map<Integer, Integer> countMap = new HashMap<>();

        // bucket[freq] = input number with frequency freq, use size = nums.length+1 to align length with index
        List<Integer> bucket[] = new List[nums.length + 1];

        // build frequency map
        for (int ele : nums) {
            if (!countMap.containsKey(ele)) {
                countMap.put(ele, 1);
            } else {
                countMap.put(ele, countMap.get(ele) + 1);
            }
        }

        /**
         * example frequency map
         | key | count |
         |-----|-------|
         | 1   | 3     |
         | 2   | 2     |
         | 3   | 2     |
         | 4   | 1     |
         | 5   | 1     |
         | 6   | 1     |
         *
         */

        /**
         * loop through count map
         * use available counts as bucket index, put all input number int buckets
         */
        for (int key : countMap.keySet()) {
            // get count for current number
            int count = countMap.get(key);

            // there are multiple number with same count, so each bucket is a integet list
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            // put input number into its count bucket
            bucket[count].add(key);
        }

        /**
         * example bucket list
         | bucket[count] | nums    |
         |---------------|---------|
         | 1             | 4, 5, 6 |
         | 2             | 2       |
         | 3             | 1       |
         */

        /**
         * loop through bucket list from the tail (from highest count to lowest) add all number from bucket into rst
         * until the bucket list is empty or rst size >= k
         */
        List<Integer> rst = new ArrayList<>();
        for (int count = bucket.length - 1; count >= 0 && rst.size() < k; count--) {
            // some count has no numbers, skip it
            if (bucket[count] != null)
                // if current count has number, add all numbers into result
                rst.addAll(bucket[count]);
        }

        return rst;
    }
}
