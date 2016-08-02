/**
 * Created by adamli on 2/16/16.
 */
public class FirstOccurrence {
    public static int FirstOccurrence(int input[], int target) {
        if (input == null || input.length == 0)
            return -1;

        int start = 0;
        int end = input.length - 1;

        // stop when start = end -1
        while(start+1 < end) {
            int mid = start + (end-start) / 2;
            if (input[mid] == target) {
                end = mid;
            }else if (input[mid] > target) {
                end = mid;
            }else{
                start = mid;
            }
        }

        if (input[start] == target)
            return start;

        if (input[end] == target)
            return end;

        return -1;
    }
}
