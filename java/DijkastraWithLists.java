import java.util.*;

/**
 * Created by adamli on 7/26/16.
 */
public class DijkastraWithLists {
    List<Integer> shortestPath(List<DJNode> graph, int start, int end) {
        Comparator<DJNode> comparator = new Comparator<DJNode>() {
            @Override
            public int compare(DJNode o1, DJNode o2) {
                if (o1.path == Integer.MAX_VALUE && o2.path == Integer.MAX_VALUE)
                    return 0;

                return o1.path - o2.path;
            }
        };

        DJNode startNode = graph.get(start);
        startNode.path = 0;
        graph.set(start, startNode);

        PriorityQueue<DJNode> heap = new PriorityQueue<>(comparator);

        for (DJNode tmp : graph) {
            heap.offer(tmp);
        }
        Set<DJNode> selected = new HashSet<>();


        while (!heap.isEmpty()) {
            DJNode curr = heap.poll();

            for (DJEdge edge : curr.edges) {
                DJNode next = edge.to;
                selected.add(curr);

                if (!selected.contains(next) && curr.path + edge.weight < next.path) {
                    next.path = curr.path + edge.weight;
                    next.prev = curr;

                    // remember to remove and add it back
                    heap.remove(next);
                    heap.offer(next);
                }
            }
        }

        return getPath(graph.get(start), graph.get(end));
    }

    private List<Integer> getPath(DJNode start, DJNode end) {
        List<Integer> rst = new ArrayList<>();
        DJNode curr = end;

        while (curr != start) {
            if (curr == null)
                return null;

            rst.add(curr.val);
            curr = curr.prev;
        }

        rst.add(start.val);

        Collections.reverse(rst);

        return rst;
    }
}
