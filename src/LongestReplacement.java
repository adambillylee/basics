/**
 * Created by adamli on 6/7/16.
 */
public class LongestReplacement {
    public int FindMax(int input) {
        int max = 0;
        int factor = 1;

        while (input / factor > 0) {
            int left = input / factor;
            int right = input % factor;

            int total = left / 10 * factor + right;

            System.out.println("left: " + left);
            System.out.println("right: " + right);
            System.out.println("total:" + total);
            System.out.println();

            max = Math.max(max, total);
            factor *= 10;
        }

        return  max;
    }
}
