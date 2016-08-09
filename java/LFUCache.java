import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CacheNode {
    int val;
    int freq;

    public CacheNode(int val) {
        this.val = val;
        this.freq = 1;
    }

    public void addFreq() {
        this.freq++;
    }
}


public class LFUCache {
    CacheNode most;
    CacheNode least;
    Map<Integer, CacheNode> map;
    PriorityQueue<CacheNode> mostFreq;
    PriorityQueue<CacheNode> leastFreq;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        most = null;
        least = null;
        map = new HashMap<>();
        mostFreq = new PriorityQueue<>((n1, n2) -> (n1.freq - n2.freq));
        leastFreq = new PriorityQueue<>((n1, n2) -> (n2.freq - n1.freq));
        size = 0;
        this.capacity = capacity;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            mostFreq.remove(node);
            leastFreq.remove(node);

            node.addFreq();
            mostFreq.offer(node);
            leastFreq.offer(node);
            map.put(key, node);
        } else {
            CacheNode node = new CacheNode(val);
            mostFreq.offer(node);
            leastFreq.offer(node);
            map.put(key, node);
            size++;


            if (most == null && least == null) {
                most = node;
                least = node;
            }
        }

        if (map.get(key).freq > most.freq) {
            most = map.get(key);
        }

        if (map.get(key).freq < least.freq) {
            least = map.get(key);
        }

        if (size > capacity) {
            mostFreq.poll();
            leastFreq.poll();
            size--;
        }
    }

    // pop top min from max heap
    public int getMin() {
        if (mostFreq.isEmpty()) {
            return -1;
        } else {
            return least.val;
        }
    }

    // pop top max from min heap
    public int getMax() {
        if (leastFreq.isEmpty()) {
            return -1;
        } else {
            return most.val;
        }
    }
}
