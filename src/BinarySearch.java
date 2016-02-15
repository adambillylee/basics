/**
 * Created by adamli on 2/15/16.
 */
public class BinarySearch {
    public static int search(int[] input, int target) {
        if (input.length == 0 || input == null)
            return -1;

        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == input[mid])
                return mid;
            else if (target < input[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}
