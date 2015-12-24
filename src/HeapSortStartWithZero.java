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
            exch(pq, 0, j--);
            sink(pq, 0, j);
        }
    }

    private static void sink(int[] pq, int i, int N) {
        /** there are N number in array and last index is N-1
         * we need to compare  2*i with 2*i+1 later, so 2*i<N-1
         */
        while (2 * i < N - 1) {
            // find index of larger child of pq[i]
            int j = 2 * i + 1;
            if (pq[j] < pq[j + 1] && j < N - 1) j++;

            // only exchange when pq[i] < its larger child
            if (pq[i] > pq[j]) break;
            exch(pq, i, j);

            // fix current index after swap
            i = j;
        }
    }

    private static void exch(int[] pq, int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
}
