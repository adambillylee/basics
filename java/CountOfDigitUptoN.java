/**
 * Created by adamli on 7/24/16.
 */
public class CountOfDigitUptoN {
    int[] countOfDigits(int n) {
        int[] rst = new int[9];

//        for (int digit = 0; digit < 10; digit++) {
//            rst[digit] = getCount(digit, n);
//        }

        for (int i=0; i< 123; i++) {
            System.out.print(i + " ");
        }

        return rst;
    }

    private int getCount(int digit, int n) {
        int total = 0;
        int factor = 1;

        while (n > 0) {
            if (n % 10 >= digit) {
                total += factor;
            }

            factor *= 10;
            n /= 10;
        }

        return total;
    }
}
