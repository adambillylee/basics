/**
 * Created by adamli on 12/22/15.
 */
public class HeapSortStartWithZero {
    public static void sort(int pq[]) {
        // first pass: sink all non-leaf nodes
        int N = pq.length;

        // first pass: sink all non-leaf nodes
        for (int i = N / 2 - 1; i >= 0; i--)
            sink(pq, i, N);

        // 2nd pass: sort
        int j = N - 1;
        while (j >= 0) {
            System.out.println(pq[0]);
            exch(pq, 0, j);
            sink(pq, 0, j--);
        }
    }

    private static void sink(int[] pq, int root, int N) {
        int min = root;

        /** there are N number in array and last index is N-1
         * we need to compare  2*i with 2*i+1 later, so 2*i<N-1
         */
        while (2 * root < N) {
            // find left and right
            int left = 2 * root + 1;
            int right = 2 * root + 2;

            // if left exist and is min, point min to left
            if (left < N && pq[left] < pq[min])
                min = left;

            // if right exists and is min, point min to right
            if (right < N && pq[right] < pq[min])
                min = right;

            // if min is not root, swap, else stop the loop
            if (min != root) {
                exch(pq, root, min);
            }else{
                break;
            }

            // after swap root = min, put root into original index
            root = min;
        }
    }

    private static void exch(int[] pq, int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}
