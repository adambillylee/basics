/**
 * Created by adamli on 4/27/16.
 */
public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        int small = nums[0];
        int mid = Integer.MAX_VALUE;

        for (int n : nums) {
            /**
             * bug point:
             * if condition has to include equal case
             * cannot let equal case return true
             */
            if (n <= small) {
                // if new number < small, update small
                // but mid and previous small relationship still hold, don't update mid
                small = n;
            }else if(n <= mid) {
                // if new number can stick into curr small and mid
                // then previous mid is no longer mid, update its value to n
                mid = n;
            }else{
                // there is always a small < mid, so if we find a number > mid, that will be the "large" of the three
                // return true
                return true;
            }
        }

        return false;
    }
}
