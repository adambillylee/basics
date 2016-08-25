import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 8/24/16.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
