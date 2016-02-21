/**
 * Created by adamli on 2/16/16.
 */
public class BinarySearchIn2D {
    public static boolean BinarySearch(int[][] input, int target) {
        if (input.length == 0 || input[0].length == 0 && input == null)
            return false;

        int start = 0;
        int end = input.length * input[0].length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int r = mid / input.length;
            int c = mid % input.length;

            if (input[r][c] == target) {
                System.out.format("find target: %d", target);
                return true;
            }else if (input[r][c] > target) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println("cannot find it :(");
        return false;
    }
}
