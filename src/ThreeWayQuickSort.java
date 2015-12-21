/**
 * Created by adamli on 12/19/15.
 */
public class ThreeWayQuickSort {
    public static int[] sort(int a[], int lo, int hi) {
        // base case
        if (hi<=lo)
            return a;

        // define partitioning element
        int v = a[lo];
        int lb=lo, gb=hi, i = lo;

        /**
         * don get confused, its always comparison between a[i] and v
         * lb will always point to the first occurrence of partition element
         */
        while (i<=gb) {
            // when i ele > lower bound, swap lt and i ele and increase both curr (since new a[i] is an old value)
            if (a[i] < v){
                swap(a, i++, lb++);
            }else if (a[i] > v)
                // after swap a[i] will be a new value coming from previous a[gb], so don't increase i
                swap(a, i, gb--);
            else
                i++;
        }

        /** lb will point at first occurrence of partition element and gb will be the last
         * un-partitioned left start with lb -1
         * un-partitioned right start with gb + 1
         */
        sort(a, lo, lb-1);
        sort(a, gb+1, hi);

        return a;
    }

    private static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
