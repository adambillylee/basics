import java.util.Arrays;

/**
 * Created by adamli on 5/3/16.
 */
public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        // sort first
        Arrays.sort(nums);

        int count=0;

        for (int one = 0; one<nums.length; one++) {
            int two = one + 1;
            int three = nums.length - 1;

            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];

                if (sum < target) {
                    /**
                     * because nums[one] + nums[two] + nums[three] < target
                     * so if we replace three with any two between (two, three), it will work
                     * there are total of (three -two) such threes can satisfy this condition
                     */
                    count += three - two;
                    two++;
                }else{
                    three--;
                }
            }
        }

        return count;
    }
}
