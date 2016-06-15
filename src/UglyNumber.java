/**
 * Created by adamli on 6/14/16.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num < 1)
            return false;

        int factors[] = {2,3,5};

        for (int factor : factors) {
            while (num % factor == 0) {
                num = num / factor;
            }
        }

        return num == 1;
    }
}
