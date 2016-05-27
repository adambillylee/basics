
/**
 * Created by adamli on 5/26/16.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;

        for (int num : nums) {
            diff ^= num;
        }

        /**
         * since we have two singled numbers, the two numbers must have some bits in diff
         * get the bit with the highest position
         */
        diff = Integer.highestOneBit(diff);
        int rst[] = {0, 0};


        /**
         * use this highest one bit to separate all nums in two groups
         * we know rst[0] have bit diff = 0 and rst[1] have bit diff = 1
         */
        for (int num : nums) {
            // bit operators have lower priority than equal sign, so use bracket here
            if ((num & diff) == 0) {
                /**
                 * this is group A, for all numbers with bit diff == 0
                 * all numbers should be in pair except for rst[0]
                 * use XOR to find rst[0] from this group
                 */
                rst[0] ^= num;
            }else{
                /**
                 * this is group B, for all numbers with bit diff == 1
                 * use XOR to find rst[1]
                 */
                rst[1] ^= num;
            }
        }

        return rst;
    }
}
