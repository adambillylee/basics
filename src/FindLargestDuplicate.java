import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 6/6/16.
 */
public class FindLargestDuplicate {
    public int FindLargestDup(int nums) {
        int max = 0;
        List<Integer> list = new ArrayList<>();

        // break each digit from numbers in to list, reverse order (12345 -> {5,4,3,2,1})
        while (nums > 0) {
            list.add(nums % 10);
            nums /= 10;
        }

        for (int i = 0; i < list.size(); i++) {
            // copy an tmp arraylist for duplicate
            List<Integer> tmp = new ArrayList<>(list);

            // loop through each number in list, stick into an duplicate in tmp
            int num = list.get(i);
            tmp.add(i, num);

            // build an integer from tmp, and compare it with max
            max = Math.max(buildInt(tmp), max);
        }

        return max;
    }

    /**
     * build up integer from reversed integer list ({5,5,4,3,2,1} -> 123455)
     * since factor grows from right to left (from 1 to 10000000), its easier to keep it reversed
     *
     * @param tmp
     * @return integer
     */
    private int buildInt(List<Integer> tmp) {
        int factor = 1;
        int rst = 0;

        /**
         * num * factor =
         * 5 * 1 +
         * 5 * 10 +
         * 4 * 100 +
         * 4 * 1000 +
         * 3 * 10000 +
         * 2 * 100000 +
         * 1 * 10000000
         */
        for (int num : tmp) {
            rst += factor * num;
            factor *= 10;
        }

        return rst;
    }

    public static void main(String[] args) {
        FindLargestDuplicate sol = new FindLargestDuplicate();
        System.out.println(sol.FindLargestDup(12345));
    }
}