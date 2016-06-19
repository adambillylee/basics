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
        // number of edges connected to node i
        int degree[] = new int[n];

        createGraph(edges, graph, degree);

        // initialized leaf with nodes with degree = 1
        Queue<Integer> leaf = new LinkedList<>();
        if (graph.size() > 2) {
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1)
                    leaf.add(i);
            }
        }

        // delete leaves level by level, until 2 or 1 node remains
        BFS(graph, degree, leaf);

        // add remaining node to rst
        rst.addAll(graph.keySet());
        return rst;
    }

    private void BFS(Map<Integer, Set<Integer>> graph, int[] degree, Queue<Integer> leaf) {
        while (!leaf.isEmpty()) {
            int len = leaf.size();
            Queue<Integer> next = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                int curr = leaf.poll();

                next.addAll(removeLeaf(curr, graph, degree));
            }

            if (graph.size() > 2)
                leaf = next;
        }
    }

    private void createGraph(int[][] edges, Map<Integer, Set<Integer>> graph, int[] degree) {
        for (int edge[] : edges) {
            int first = edge[0];
            int second = edge[1];

            // update degrees
            degree[first]++;
            degree[second]++;

            // update graph for both direction
            addToMap(graph, first, second);
            addToMap(graph, second, first);
        }
    }

    private Queue<Integer> removeLeaf(int curr, Map<Integer, Set<Integer>> graph, int[] degree) {
        Set<Integer> tos = graph.get(curr);
        Queue<Integer> next = new LinkedList<>();

        // update degrees of node that curr node connects to
        for (int to : tos) {
            graph.get(to).remove(curr);
            degree[to]--;

            // if this new node is a leaf, put it into queue for next level bfs
            if (degree[to] == 1)
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
