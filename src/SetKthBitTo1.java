/**
 * Created by adamli on 3/23/16.
 */
public class SetKthBitTo1 {
    public static int set(int input, int k) {
        return input | 1 << k-1;
    }
}
