/**
 * Created by adamli on 6/7/16.
 */
public class FindLargestDuplicateOnePass {
    public int FindLargestDup(int nums) {
        int max = 0;
        int factor = 1;

        while (nums / factor >= 1) {
            int mid = nums / factor % 10;
            int left = nums / factor;
            int right = nums % factor;

            int total = left * factor * 10 + mid * factor + right;
            max = Math.max(max, total);

            System.out.println("factor: " + factor);
            System.out.println("left:" + left);
            System.out.println("mid:" + mid);
            System.out.println("right:" + right);
            System.out.println("total:" + total);
            System.out.println();

            factor *= 10;
        }

        return max;
    }
}
