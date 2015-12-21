/**
 * Created by adamli on 12/15/15.
 */
public class MergeSort {
    public static void sort(int a[]) {
        if (a.length <0)
            return;

        /**
         * aux is a temp array to store "previous state before current merge"
         * during merge, the current min element from left half (aux[i]) and right half(aux[j]) of aux will be compared
         * and the min
         */
        int aux[] = new int[a.length];

        split(a, aux, 0, a.length - 1);
    }

    private static void split(int[] a, int[] aux, int lo, int hi) {
        /**1.base case of split
         * when hi==lo, there is only 1 number in a[lo~hi], which is already sorted
         * return out of split and start merge from here
         */
        if (hi == lo)
            return;

        int mid = (lo + hi) / 2;

        //2. divide
        split(a, aux, lo, mid);
        split(a, aux, mid + 1, hi);

        //3. conquer
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // to save time, only copy the current merge range (lo~hi)
        for (int k=lo; k<=hi; k++)
            aux[k] = a[k];

        // split aux into two halves, where both part should already be sorted in previous level of merge
        int i=lo, j=mid+1;

        // look through all element in aux[lo~hi], take smaller from both side of aux and put into a
        for (int k=lo; k<=hi; k++) {
            // nothing left on the right, take from right half ele into a
            if (i>mid)                  a[k] = aux[j++];
            // nothing left on the left, take from left half ele into a
            else if (j>hi)              a[k] = aux[i++];
            // both half have ele left, take the smaller into a
            else if (aux[j] < aux[i])   a[k] = aux[j++];
            else                        a[k] = aux[i++];
        }
    }
}
