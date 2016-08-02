import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 6/10/16.
 */
public class FourElementSum {
    private class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    boolean findPairs(int nums[]) {
        if (nums.length == 0)
            return false;

        for (int i : nums)
            System.out.print(i + " ");
        System.out.println();

        boolean rst = false;

        /**
         * use a map to record all sums
         * key: sum of nums[i] + nums[j]
         * value: pair of i and j
         */
        Map<Integer, Pair> map = new HashMap<>();
        int len = nums.length;

        /**
         * loop through all pairs in nums with j>i
         */
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];

                // if sum of nums[i] + num[j] already stored in map
                if (map.containsKey(sum)) {
                    // get the candidate from map
                    Pair candidate = map.get(sum);

                    /**
                     * if the sum already exist in in hashmap, check if the candidate is valid
                     * a valid candidate should have both candidate i and j < current i (since j < i)
                     * (the two index on the left of equal sign must be < two index on the right)
                     */
                    if (candidate.i < i && candidate.j < i) {
                        rst = true;
                        printEquation(map.get(sum), i, j, nums);
                    }

                    /**
                     * for all the sum in hashmap, always make sure the j index the smallest possible
                     * which ensures we are not missing pairs later
                     */
                    if (j < candidate.j)
                        map.put(sum, new Pair(i, j));
                } else {
                    Pair tmp = new Pair(i, j);
                    map.put(sum, tmp);
                }
            }
        }

        return rst;
    }

    private void printEquation(Pair pair, int i, int j, int nums[]) {
        System.out.format("nums[%d] + nums[%d] = nums[%d] + nums[%d] \n", pair.i, pair.j, i, j);
        System.out.format("%d + %d = %d + %d \n\n", nums[pair.i], nums[pair.j], nums[i], nums[j]);
    }
}
