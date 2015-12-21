import java.util.NoSuchElementException;

/**
 * Created by adamli on 12/20/15.
 * pq[0] is 0, elements start with 1
 * max is at pq[1]
 * pq[1~N] should be decreasing
 * N = index of last number in pq = number of elements in pq
 */
public class MaxPQ {
    int pq[];
    int N;  // size of PQ

    public MaxPQ(int size) {
        pq = new int[size + 1];
        N = 0;
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    /**
     * reorder heap by move a node up toward the root, useful when adding new node to end of queue
     *
     * @param k index of node to swim up
     */
    void swim(int k) {
        // since we don't exchange pq[0] with pq[1], so k has to start with 1
        while (k > 1 && pq[k] > pq[k / 2]) {
            exch(pq, k, k / 2);
            k = k / 2;
        }
    }

    void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            // add j<N to avoid array out of bound
            if (j < N && pq[j] < pq[j+1])
                j++;

            if (pq[k] >= pq[j])
                break;

            exch(pq, k, j);

            k = j;
        }
    }

    void exch(int q[], int l, int r) {
        int tmp = q[l];
        q[l] = q[r];
        q[r] = tmp;
    }

    public int delMax() {
        if (isEmpty())
            throw new NoSuchElementException("Priority Queue Underflow");

        // max is at pq[1]
        int max = pq[1];

        //exchange the last with root
        exch(pq, 1, N--);

        // sink the new root to where it suppose to be
        sink(1);

        // fix N pointer
        pq[N + 1] = 0;

        return max;
    }

    public void insert(int newInt) {
        // insert new element at the end of pq
        pq[++N] = newInt;

        //swim up the new node
        swim(N);
    }

    /**
     * is pq[1~N] rooted at k a max heap?
     *
     * @param k index of heap root to exam
     * @return if its a max heap or not
     */
    public boolean isMaxHeap(int k) {
        if (k > N) return true;   // since heap start at N is empty

        int left = 2 * k;
        int right = 2 * k + 1;

        // if left node is not null and k node < left, false
        if (pq[k] < pq[left] && left < N)
            return false;

        // if left node is not null and k node < right, false
        if (pq[k] < pq[right] && right < N)
            return false;

        // both left and right has to be a max heap as well
        return isMaxHeap(left) && isMaxHeap(right);
    }
}
