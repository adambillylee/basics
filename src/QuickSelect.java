public class QuickSelect {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int lo, int hi) {
        // put pivot at the right end
        int pivot = arr[hi];

        /**
         * everything on the left of (but not include) boundary should be < pivot
         */
        int boundary = lo;

        /**
         * from left to right - 1:
         * put all element < left to the boundary to move boundary forward
         */
        for (int i = lo; i < hi; i++) {
            /**
             * put all element < left to the boundary to move boundary forward
             */
            if (arr[i] < pivot) {
                swap(arr, i, boundary);
                boundary++;
            }
        }

        /**
         * move pivot to "first element >= pivot"
         */
        swap(arr, hi, boundary);

        return boundary;
    }

    public int quickSelect(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int j = partition(arr, lo, hi);
            if (j == k) {
                /**
                 * should be returning k-1, as k is one based and index is zero based
                 */
                return arr[k - 1];
            } else if (j < k) {
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }

        /**
         * should be returning k-1, as k is one based and index is zero based
         */
        return arr[k - 1];
    }
}