/**
 * Created by adamli on 2/13/16.
 */
public class MoveZerosToRight {
    /**
     * Similar to partition
     * @param input array with some 0
     * @return partitioned input array
     */
    public static int[] move(int[] input) {
        // sanity check
        if (input.length == 0)
            return null;

        // anything left of left is checked, will not be zero
        int left = 0;

        // [left~right]

        // anything right of 0 is zero
        int right = input.length-1;


        // make sure while condition is left = right, since we still need to
        // compare when left == right
        while (left <= right) {
            if (input[left] == 0) {
                swap(input, left, right);
                right--;
            }else{
                left++;
            }
        }

        return input;
    }

    public static void swap(int[] input, int left, int right) {
        int tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }
}
