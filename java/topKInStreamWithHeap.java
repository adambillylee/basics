import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by adamli on 8/5/16.
 */
public class topKInStreamWithHeap {
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int topK(int next, int k) {
        heap.offer(next);

        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }

    public int getNext(Iterator<Integer> iterator) {
        return iterator.next();
    }
}
