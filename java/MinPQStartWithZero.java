import java.util.NoSuchElementException;

/**
 * Created by adamli on 12/23/15.
 */
public class MinPQStartWithZero {
    int pq[];
    int N;

    public MinPQStartWithZero(int size) {
        pq = new int[size];
        N = 0;
    }

    public void insert(int i) {
        assert isMinPQ();

        pq[N++] = i;
        swim(N - 1);

        assert isMinPQ();
    }

    public void delMin() {
        assert isMinPQ();

        if (N == 0)
            throw new NoSuchElementException("Priority Queue Underflow");

        System.out.println(pq[0]);
        exch(0, N - 1);
        pq[--N] = 0;
        sink(0);

        assert isMinPQ();
    }

    private void sink(int i) {
        while (2 * i < N - 1) {
            // j = index of left child
            int j = 2 * i + 1;
            // choose the smaller child node to swap with, but make sure right child exists
            if (pq[j] > pq[j + 1] && j < N - 1) j++;
            // if parent node already smaller, stop sinking
            if (pq[i] < pq[j]) break;
            exch(i, j);
            i = j;
        }
    }

    private void swim(int n) {
        int i = n;
        while (i > 0) {
            if (pq[(i - 1) / 2] > pq[i])
                exch((i - 1) / 2, i);

            i = (i - 1) / 2;
        }
    }

    private void exch(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private boolean isMinPQ() {
        for (int i = 0; i < N - 1 - 1; i++)
            if (pq[i] > pq[i + 1])
                return false;

        return true;
    }
}
