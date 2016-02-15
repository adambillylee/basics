/**
 * Created by adamli on 2/15/16.
 */
public class AtoThePowerOfB {
    public static int a_pow_b(int a, int b) {
        int rst = helper(a, b, a);

        return rst;
    }

    public static int helper(int a, int b, int curr) {
        if (b == 0)
            return curr;

        if (b % 2 == 0)
            curr = curr * curr;
        else
            curr = curr * a;

        return helper(a, b / 2, curr);
    }

}
