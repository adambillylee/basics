import java.util.HashMap;

/**
 * Created by adamli on 3/8/16.
 */
public class FindMissingNumberInUnsortedArray {
    public static int findMissing(int[] input) {
        int actualSum = 0;
        for (int ele : input) {
            actualSum += ele;
        }

        int n = input.length + 1;
        int expectedSum = (1+n) * n / 2;

        return expectedSum - actualSum;
    }

    public static int findMissingHashMap(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = input.length + 1;

        for (int ele: input) {
            map.put(ele, 1);
        }

        for (int i=1; i<=n; i++) {
            if (map.get(i) == null)
                return i;
        }

        return -1;
    }
}
