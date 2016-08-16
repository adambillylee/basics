import java.util.Collections;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by adamli on 5/21/16.
 */
public class HeapByTreeMap {
    public void heap(int input[]) {
        SortedMap<Integer, Integer> heap = new TreeMap<>(Collections.reverseOrder());

        for (int ele : input) {
            heap.put(ele, ele);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.lastKey());
            heap.remove(heap.lastKey());
        }
    }

    public void heapByPQ(int input[]) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int ele:input) {
            heap.offer(ele);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
