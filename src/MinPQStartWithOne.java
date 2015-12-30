import java.util.NoSuchElementException;

/**
 * Created by adamli on 12/23/15.
 */
public class MinPQStartWithOne {
    int pq[];
    int N;

    public MinPQStartWithOne(int size) {
        this.pq = new int[size + 1];
        this.N = 0;
    }

    public void insert(int i) {
        pq[++N] = i;
        swim(N);
    }

    public int delMin() {
        if (N == 0)
            throw new NoSuchElementException("Priority Queue underflow");

        int min = pq[1];
        exch(1, N);
        pq[N--] = 0;
        sink(1);

        System.out.println(min);

        return min;
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (pq[j] > pq[j + 1] && j < N) j++;
            if (pq[i] < pq[j]) break;
            exch(i, j);
            i = j;
        }
    }

    private void swim(int n) {
        while (n > 0) {
            if (pq[n / 2] > pq[n])
                exch(n / 2, n);

            n = n / 2;
        }
    }

    private void exch(int i, int n) {
        int tmp = pq[i];
        pq[i] = pq[n];
        pq[n] = tmp;
    }

}
