import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by adamli on 8/10/16.
 */
public class findDupsInArray {
    List<Integer> findDups(int[] input) {
        // sort array
        Arrays.sort(input);
        List<Integer> rst = new ArrayList<>();

        int i = 0;
        while (i < input.length - 1) {
            if (input[i] == input[i + 1]) {
                rst.add(input[i]);
                int lastIndex = binarySearch(input[i], i, input.length - 1, input);
                i = lastIndex + 1;
            } else {
                i++;
            }
        }

        return rst;
    }

    private int binarySearch(int target, int lo, int hi, int input[]) {
        int start = lo;
        int end = hi;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= input[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (input[end] == target) {
            return end;
        }

        return start;
    }
}
