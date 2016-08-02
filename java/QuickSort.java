/**
 * Created by adamli on 2/11/16.
 */
public class QuickSort {
    public static int[] QuickSort(int[] input) {
        if (input.length == 0)
            return input;

        int start = 0;
        int end = input.length-1;
        helper(input, start, end);

        return input;
    }

    public static void helper(int[] input, int start, int end) {
        // base case
        if (start >= end)
            return;

        int toCompare = start;
        int swapTo = end;
        int pivotInd = toCompare + (swapTo - toCompare) / 2;

        int pivotVal = input[pivotInd];

        // put pivot at the end
        swap(input, pivotInd, swapTo--);

        // remember, when toCompare = swapTo, input[toCompare=swapTo] is still unchecked
        // so condition has to be swapTo >= toCompare
        while (swapTo >= toCompare) {
            if (input[toCompare] >= pivotVal) {
                swap(input, toCompare, swapTo);
                swapTo--;
            }else {
                toCompare++;
            }
        }

        /**
         * after the while loop compared will be the last compared position +1
         * which is the final desired index of pivot element
         */
        swap(input, toCompare, end);

        helper(input, start, toCompare-1);
        helper(input, toCompare+1, end);
    }

    public static void swap(int[]input, int l, int r) {
        int tmp = input[l];
        input[l] = input[r];
        input[r] = tmp;
    }
}
