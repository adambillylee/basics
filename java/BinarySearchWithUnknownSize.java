/**
 * Created by adamli on 2/16/16.
 */
public class BinarySearchWithUnknownSize {
    static int size;

    public static int searchWithUnknownSize(int input[], int target) {
        if(input == null)
            return -1;

        // find its size first
        int start = 0;
        int end = findSize(input) - 1;

        while (start <= end) {
            int mid = start + (end - start) /2;

            if (input[mid] == target) {
                return mid;
            }else if (input[mid] > target) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int findSize(int[] input) {
        int size = 1;
        int prev = 0;

        while (checkSize(size) != 0) {
            if (checkSize(size) == 1) {
                size = prev + (size - prev) / 2;
            }else if (checkSize(size) == -1) {
                prev = size;
                size = size * 2;
            }
        }

        return size;
    }

    public static void setSize(int size) {BinarySearchWithUnknownSize.size = size;}

    public static int checkSize(int guess) {
        if (guess == size) {
            return 0;
        }else if(guess > size) {
            return 1;
        }else {
            return -1;
        }
    }
}
