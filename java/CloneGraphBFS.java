import java.util.*;

/**
 * Created by adamli on 6/19/16.
 */
public class CloneGraphBFS {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        /**
         * create a queue of node with HAS NEIGHBOURS NOT COPIES YET
         * because BFS copies the neighbours only, we have to copy the first
         * node first in initialization
         */
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        queue.offer(node);

        // copy first node and initialize queue and visited
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        visited.put(node, head);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();

            /**
             * loop through all neighbors of curr node
             * copy the neighbor, not current node
             */
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                /**
                 * if current neighbor is not copied yet, add it into the queue TO COPY ITS NEIGHBORS
                 */
                if (!visited.containsKey(neighbor)) {
                    // add it into the queue TO COPY ITS NEIGHBORS
                    queue.add(neighbor);

                    // copy CURRENT NEIGHBOUR
                    UndirectedGraphNode tmp = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor, tmp);
                }

                /**
                 * fix the relationship between copied current node and copied current neighbour
                 */
                visited.get(curr)
                        .neighbors
                        .add(visited.get(neighbor));
            }
        }

        return head;
    }
}
