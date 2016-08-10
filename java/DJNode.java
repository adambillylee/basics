import java.util.HashSet;
import java.util.Set;

/**
 * Created by adamli on 7/26/16.
 */
public class DJNode {
    int val;
    int path;   // current path length from start to here
    DJNode prev;    // prev node on the path
    Set<DJEdge> edges;

    DJNode(int val) {
        this.val = val;
        this.path = Integer.MAX_VALUE;
        this.prev = null;
        this.edges = new HashSet<>();
    }

    @Override
    public String toString() {
        return String.format("val: %d, path: %d, prev:%d", val, path, prev == null ? null : prev.val);
    }
}
