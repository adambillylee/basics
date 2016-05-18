import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MFUNode {
    int key;
    int value;
    int count;
    MFUNode more;
    MFUNode less;

    MFUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }
}

/**
 * Created by adamli on 5/17/16.
 */
public class MostFrequentlyUsedCache {
    /**
     * key: key
     * value : node of key
     */
    Map<Integer, MFUNode> map;
    MFUNode most;
    MFUNode least;
    int capacity;
    Set<Integer> counts;

    public MostFrequentlyUsedCache(int capacity) {
        map = new HashMap<>();
        most = null;
        least = null;
        this.capacity = capacity;
        this.counts = new HashSet<>();
    }

    public int get(int key) {
        if (map.get(key) == null)
            return -1;

        return map.get(key).value;
    }

    public void set(int key, int value) {
        // if key already in cache
        if (map.get(key) != null) {
            // update count
            map.get(key).count++;
            counts.add(map.get(key).count);

            // adjust key order in double linked list
            updateOrder(key);

            // clean up the cache if there are too many
            cleanUpCache();
        } else {
            // unless cache is full and least count > 1, add new pair
            if (!(counts.size() == capacity && least.count > 1))
                addNewPair(key, value);
        }
    }

    private void cleanUpCache() {
        if (counts.size() > capacity) {
            int leastCount = least.count;

            // start with least
            MFUNode curr = least;

            // find first node with count > leastCount and remove all nodes on the way
            while (curr != null && curr.count == leastCount) {
                map.remove(curr.key);
                curr = curr.more;
            }

            // update least
            least = curr;

            // update current count
            counts.remove(leastCount);
        }
    }

    private void addNewPair(int key, int value) {
        MFUNode tmp = new MFUNode(key, value);
        tmp.more = least;
        tmp.less = null;

        // number of different counts in the map
        counts.add(1);

        // update least to tmp
        if (least != null) {
            least.less = tmp;
        }
        least = tmp;

        // if cache is empty this is most as well
        if (map.size() == 0)
            most = tmp;

        // update map
        map.put(key, tmp);
    }

    public void updateOrder(int key) {
        // node 1, count =3
        MFUNode orig = map.get(key);

        // node 1, count =3
        MFUNode curr = map.get(key);

        // find the last "more" node with count < new curr count
        // 3 at this case
        while (curr.more != null && curr.more.count < orig.count) {
            curr = curr.more;
        }

        // if order needs update
        if (curr != orig) {
            // if most was 3, new most must be 1
            if (most == curr)
                most = orig;

            // if least was 1, then 2 has to be new least
            if (least == orig)
                least = orig.more;

            // 2.less = null
            orig.more.less = orig.less;

            // 1.more = 3.more = null
            orig.more = curr.more;
            // 1.less = 3
            orig.less = curr;
            // 3.more = 1
            curr.more = orig;
        }
    }
}
