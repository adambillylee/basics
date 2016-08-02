public class MinSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int i=0;
        int j=0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (i < nums.length) {
            /**
             * i loop: explore forward
             * sum >= s is not true at initialization
             * put status (min) update into j lop
             */
            while (i < nums.length && sum < s) {
                sum += nums[i];
                i++;
            }
            // i after first num that makes sum >=s

            /**
             * j loop: shrink from start
             */
            while (j < i && sum >=s) {
                min = Math.min(min, i-j);

                sum -= nums[j];
                j++;
            }
            // j after first num that makes sum < s
        }

        return min == Integer.MAX_VALUE? 0 : min;
    }
}