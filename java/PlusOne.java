import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;

        int carry = 1;

        int i = digits.length - 1;
        while (carry > 0 && i >= 0) {
            carry = (digits[i] + 1) / 10;
            digits[i] = (digits[i] + 1) % 10;
            i--;
        }

        if (carry == 1) {
            int[] rst = Arrays.copyOf(digits, digits.length + 1);
            rst[0] = 1;

            return rst;
        } else {
            return digits;
        }
    }
}