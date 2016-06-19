import java.util.*;

/**
 * Created by adamli on 6/18/16.
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rst = new ArrayList<>();

        // stupid sanity check
        if (edges.length == 0) {
            rst.add(0);
            return rst;
        }

        // create graph from edges
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int edge[] : edges) {
            // update graph for both direction
            addToMap(graph, edge[0], edge[1]);
            addToMap(graph, edge[1], edge[0]);
        }

        // initialized leaf with nodes with degree = 1
        Queue<Integer> leaf = new LinkedList<>();
        if (graph.size() > 2) {
            for (int i = 0; i < n; i++) {
                if (graph.get(i).size() == 1)
                    leaf.add(i);
            }
        }

        // delete leaves level by level, until 2 or 1 node remains
        BFS(graph, leaf);

        // add remaining node to rst
        rst.addAll(graph.keySet());
        return rst;
    }

    private void BFS(Map<Integer, Set<Integer>> graph, Queue<Integer> leaf) {
        while (!leaf.isEmpty()) {
            int len = leaf.size();
            Queue<Integer> next = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                int curr = leaf.poll();

                next.addAll(removeLeaf(curr, graph));
            }

            if (graph.size() > 2)
                leaf = next;
        }
    }

    private Queue<Integer> removeLeaf(int curr, Map<Integer, Set<Integer>> graph) {
        Set<Integer> tos = graph.get(curr);
        Queue<Integer> next = new LinkedList<>();

        // update degrees of node that curr node connects to
        for (int to : tos) {
            graph.get(to).remove(curr);

            // if this new node is a leaf, put it into queue for next level bfs
            if (graph.get(to).size() == 1)
                next.add(to);
        }

        // remove node from graph
        graph.remove(curr);

        // remove next level nodes extended from current node
        return next;
    }

    private void addToMap(Map<Integer, Set<Integer>> map, int i, int j) {
        if (!map.containsKey(i)) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(j);
            map.put(i, tmp);
        } else {
            map.get(i).add(j);
        }
    }
}
