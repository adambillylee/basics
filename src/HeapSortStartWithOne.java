/**
 * Created by adamli on 12/21/15.
 */
public class HeapSortStartWithOne {
    /**
     * @param pq 0 based input array
     */
    public static void sort(int pq[]) {
        int N = pq.length;

        int tmp[] = new int[pq.length + 1];

        for (int i = 0; i < pq.length; i++)
            tmp[i + 1] = pq[i];

        pq = tmp;

        // first pass: heapify
        for (int k = N / 2; k >= 1; k--) {
            sink(pq, k, N);
        }

        // 2nd pass: sort
        while (N >=1) {
            System.out.println(pq[1]);
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    private static void sink(int[] pq, int k, int N) {
        while (2 * k < N) {
            int j = 2 * k;
            if (pq[j] < pq[j+1]) j++;
            if (pq[k] > pq[j])  break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static void exch(int[] pq, int k, int j) {
        int tmp = pq[k];
        pq[k] = pq[j];
        pq[j] = tmp;
    }
}
