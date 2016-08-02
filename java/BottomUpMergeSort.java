/**
 * Created by adamli on 12/16/15.
 */
public class BottomUpMergeSort {
    static int[] aux;

    public static void merge(int a[], int lo, int mid, int hi) {
        // if hi greater than a size, hi become last index in a
        if (hi >= a.length)
            hi = a.length-1;

        //1. copy merge range from a to aux
        for (int k=lo; k<=hi; k++)
            aux[k] = a[k];

        //2. initiate i on lo for left part of aux, j on mid+1 for right part of aux
        int i=lo, j=mid+1;

        // use k to loop from lo to hi
        for (int k=lo; k<=hi;k++) {
            // pick correct a[k] from a[i] and a[j]
            if (i>mid)                  a[k] = aux[j++];
            else if (j>hi)              a[k] = aux[i++];
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }

    public static void sort(int a[]) {
        int N = a.length;
        aux = new int[N];

        for (int n = 1; n < N; n+=n) {
            // in order to merge, aux at least has to have
            for (int lo = 0; lo+n<N; lo += 2*n) {
                // hi in an index, remember to -1
                int hi = lo+n+n-1;
                // Have to calculate mid in sort, since hi in merge may not be lo+n+n-1
                int mid = (lo+hi) / 2;
                merge(a, lo, mid, hi);
            }
        }
    }
}
