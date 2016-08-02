/**
 * Created by adamli on 4/29/16.
 */
public class PatchingArray {
    public static int minPatches(int[] nums, int N) {
        int patches = 0;
        int numsInd = 0;

        // use long to deal with integer overflow
        Long maxBuild = 0L;

        // start with 1
        Long n = 1L;

        // loop through [1 ~ N]
        while (n <= N) {
            /**
             * if curr number < next number in nums[numsInd]
             * add nums[numsInd] into list
             * max build range will extend to nums[numsInd] + maxBuild
             * since [1 + maxBuild ... nums[numsInd] + maxBuild] are all buildable one by one
             */
            if (numsInd < nums.length && nums[numsInd] <= n) {
                maxBuild += nums[numsInd++];
            } else {
                /**
                 * if current number is not buildable and not in nums
                 * add current number as a patch
                 * extend maxBuild to maxBuild + n
                 */
                maxBuild += n;

                // add patch count by 1
                patches++;
            }

            // all numbers <= maxBuild is buildable
            // start next check from maxBuild + 1
            n = maxBuild + 1;
        }

        return patches;
    }
}
