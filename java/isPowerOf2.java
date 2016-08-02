/**
 * Created by adamli on 3/23/16.
 */
public class isPowerOf2 {
    public static boolean isPowerOf2(int input) {
        /**
         * 00001000 - 1 = 00000111 & input = 0
         * if there are more than one 1 in input, 00010100 - 1 = 00010011, first 1 will not be 0
         * bit and operation will not return 0
         *
         * corner case: 00 -1 = 11 (-1 in dec), input cannot = 0
         */
        return ((input & input-1) == 0) && (input != 0);
    }
}
