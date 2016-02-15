/**
 * Created by adamli on 2/13/16.
 */
public class MergeSortAlphabet {
    public static char[] MergeSort(char[] input) {
        char rst[] = new char[input.length];

        if (input.length == 0)
            return rst;

        split(input, new char[input.length], 0, input.length-1);

        return input;
    }

    public static void split(char[] input, char[] tmp, int start, int end) {
        if (start == end)
            return;

        int mid = start + (end - start) / 2;

        // divide and conquer
        split(input, tmp, start, mid);
        split(input, tmp, mid+1, end);

        // merge
        merge(input, tmp, start, mid, end);
    }

    private static void merge(char[] input, char[] tmp, int start, int mid, int end) {
        //copy input[start] ~ input[end] to tmp
        for (int i=start; i<=end; i++)
            tmp[i] = input[i];

        int leftCur = start;
        int rightCur = mid+1;

        // loop through start ~ end in tmp array
        for (int mergedCur=start; mergedCur<=end; mergedCur++) {
            // if nothing left in left half, merge in current right element
            if (leftCur > mid) {
                input[mergedCur] = tmp[rightCur];
                rightCur++;
            // if nothing left in right half, merge in current left element
            }else if (rightCur > end) {
                input[mergedCur] = tmp[leftCur];
                leftCur++;
            // if right greater than left, merge in left
            }else if (greater(tmp[rightCur], tmp[leftCur])) {
                input[mergedCur] = tmp[leftCur];
                leftCur++;
            }else{
                input[mergedCur] = tmp[rightCur];
                rightCur++;
            }
        }
    }

    private static boolean greater(char left, char right) {
        if (Character.isDigit(left) && !Character.isDigit(right))
            return true;
        else if (Character.isDigit(right) && !Character.isDigit(left))
            return false;
        else
            return left > right;
    }
}
