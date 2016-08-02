import java.util.HashMap;
import java.util.Map;

/**
 * Created by adamli on 5/18/16.
 */

class LRUNode {
    int key;
    int value;
    LRUNode newer;
    LRUNode older;

    LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    LRUNode latest;
    LRUNode oldest;
    int currSize;
    Map<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        oldest = null;
        latest = null;
        currSize = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null)
            return -1;

        // refresh node for key to latest
        LRUNode tmp = map.get(key);
        int value = tmp.value;
        deleteNode(key);
        appendNode(key, value);

        return map.get(key).value;
    }

    public void set(int key, int value) {
        // if key already exist, refresh it to latest
        if (map.get(key) != null) {
            // delete and append
            deleteNode(key);
            appendNode(key, value);
        } else {
            // if this is a new key
            if (currSize < capacity) {
                // if cache is not full, append it directly
                appendNode(key, value);
            } else {
                // if cache is full, delete the latest and add the latest
                int oldestKey = oldest.key;
                deleteNode(oldestKey);
                appendNode(key, value);
            }
        }
    }

    private void appendNode(int key, int value) {
        LRUNode tmp = new LRUNode(key, value);

        // if cache is empty, this new nodes is both latest and oldest
        if (currSize == 0) {
            oldest = tmp;
            latest = tmp;
        } else {
            // if this node is new, add it as latest
            tmp.older = latest;
            latest.newer = tmp;
            latest = tmp;
        }

        // add into map and update size count
        map.put(key, tmp);
        currSize++;
    }

    private void deleteNode(int key) {
        LRUNode toDelete = map.get(key);

        // fix link on newer side
        if (toDelete.newer != null) {
            toDelete.newer.older = toDelete.older;
        }

        // fix link on older side
        if (toDelete.older != null) {
            toDelete.older.newer = toDelete.newer;
        }

        // fix case when its oldest
        if (toDelete == oldest)
            oldest = toDelete.newer;

        // fix case when its latest
        if (toDelete == latest)
            latest = toDelete.older;

        // remove from map and update size
        map.remove(key);
        currSize--;
    }
}
