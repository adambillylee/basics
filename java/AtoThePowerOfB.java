/**
 * Created by adamli on 2/15/16.
 */
public class AtoThePowerOfB {
    public static int a_pow_b(int a, int b) {
        int rst = helper(a, b, a);

        return rst;
    }

    public static int helper(int a, int b, int curr) {
        if (b == 0) {
            System.out.format("base: helper(a=%s, b=%s, return 1)%n", a, b);
            return 1;
        }

        curr = helper(a, b / 2, curr);

        if (b % 2 == 0) {
            System.out.format("helper(a=%s, b=%s, curr=%s)%n", a, b, curr);
            return curr * curr;
        }else{
            System.out.format("helper(a=%s, b=%s, curr=%s)%n", a, b, curr);
            return curr * curr * a;
        }

    }

}
