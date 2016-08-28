/**
 * Created by adamli on 8/27/16.
 */
public class SearchInRotatedArray {
    public int found(int[] input, int target) {
        int start = 0;
        int end = input.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            /**
             * 1. check mid in first interval or second: compare mid with input[start]
             */
            if (input[start] < input[mid]) {
                /**
                 * in first interval, only narrow down when target in first half
                 * (start < target < mid)
                 */
                if (input[start] <= target && target <= input[mid]) {
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                /**
                 * in second interval, only narrow down when target in second half
                 * (mid < target < end)
                 */
                if (target >= input[mid] && target <= input[end]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if (input[start] == target) {
            return start;
        }else if (input[end] == target) {
            return end;
        }else{
            return -1;
        }
    }
}
