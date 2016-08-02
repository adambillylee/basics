/**
 * Created by adamli on 2/16/16.
 */
public class ClosestElement {
    /**
     * find closest element in array
     * @param input input array, sorted
     * @param target find its closet element in array
     * @return  value of closest element
     */
    public static int search(int input[], int target) {
        if(input == null && input.length == 0)
            return -1;

        int start = 0;
        int end = input.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) /2;

            if (input[mid] == target) {
                return input[mid];
            }else if (input[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        int deltaStart = Math.abs(input[start] - target);
        int deltaEnd = Math.abs(input[end] - target);

        if (deltaStart <= deltaEnd)
            return input[start];
        else
            return input[end];
    }
}
