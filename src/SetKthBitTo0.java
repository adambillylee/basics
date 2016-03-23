/**
 * Created by adamli on 3/23/16.
 */
public class SetKthBitTo0 {
    public static int set(int input, int k) {
        // get 0000 ... 1 0*k
        int tmp = 1 << k-1;

        // get 1111 ... 0 1*k
        // 0 on kth bit, all other bits are 1
        tmp = ~tmp;

        return input & tmp;
    }
}
