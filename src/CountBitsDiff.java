/**
 * Created by adamli on 3/27/16.
 */
public class CountBitsDiff {
    /**
     * use XOR to put all matching bits to be 1 and all un-matching bits to 1, and than counts all 1 in result
     * @param a input a
     * @param b input b
     * @return number of matching bits
     */
    public static int count(int a, int b) {
        int counter = 0;
        for (int c = a ^ b; // XOR two inputs, matching bits will be 1 and diff bits will be 0
             c != 0;        // stop the loop when all c bits = 0
             c >>= 1) {     // shift c to the right for 1 bits each time
            counter += c & 1;   // if right most bits = 1, add counter by 1, if not, add counter by 0
        }


        /**
         * summary: count number of 1's in all bits:
         * shift number to right by 1, and add counter by number & 1
         */
        return counter;
    }
}
