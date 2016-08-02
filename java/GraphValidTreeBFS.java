import java.util.*;

/**
 * Created by adamli on 6/18/16.
 */
public class GraphValidTreeBFS {
    public boolean validTree(int n, int[][] edges) {
        // sanity check
        if (edges == null || edges.length == 0 || edges[0].length == 0)
            return n == 1;

        // make graph from all edges
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        makeGraph(edges, graph);

        // use a map to keep track to depth of visited node
        // key = node, value = depth
        Map<Integer, Integer> visited = new HashMap<>();

        // start from an arbitrary node
        int startNode = edges[0][0];
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        // BFS
        while (!queue.isEmpty()) {
            int len = queue.size();
            Queue<Integer> next = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                int curr = queue.poll();

                if (!visited.containsKey(curr)) {
                    visited.put(curr, depth);
                } else {
                    /**
                     * if we have visited this node and the depth difference from last time is 2
                     * that means its like 0->1->0, which is OK
                     * if this path goes any further it becomes a cycle
                     */
                    if (depth - visited.get(curr) == 2)
                        // we don't need to put visited node back to queue again, just skip it
                        continue;
                    else
                        return false;
                }

                next.addAll(graph.get(curr));
            }
            queue = next;
            depth++;
        }

        /**
         * there is a chance that all nodes are not connected, make sure BFS goes through all n nodes
         */
        return visited.size() == n;
    }

    private void makeGraph(int[][] edges, Map<Integer, Set<Integer>> graph) {
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(b);
                graph.put(a, tmp);
            }

            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                Set<Integer> tmp = new HashSet<>();
                tmp.add(a);
                graph.put(b, tmp);
            }
        }
    }
}
