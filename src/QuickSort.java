/**
 * Created by adamli on 12/17/15.
 */
public class QuickSort {
    private static int partition(int a[], int lo, int hi) {
        int pivot = (lo + hi) / 2;
        int i = lo, j = hi;

        while (i<j) {
            while (a[i] < a[pivot])
                i++;

            while (a[j] > a[pivot])
                j--;

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    private static void sort(int a[], int lo, int hi) {
        // base case
        if (lo>=hi)
            return;

        // return partition pivot of current [lo~lo] such that all ele before pivot < a[pivot]
        // and all ele after pivot > a[pivot]
        int pivot = partition(a, lo, hi);

        // recursively sort the part before and after pivot
        sort(a, lo, pivot-1);
        sort(a, pivot, hi);
    }

    public static int[] sort(int a[]) {
        sort(a, 0, a.length-1);

        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
