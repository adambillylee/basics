import java.util.*;

/**
 * Created by adamli on 7/26/16.
 */
public class DijkastraWithLists {
    List<Integer> shortestPath(List<DJNode> graph, int start, int end) {
        DJNode startNode = graph.get(start);
        startNode.path = 0;
        graph.set(start, startNode);

        PriorityQueue<DJNode> heap = new PriorityQueue<>((o1, o2) -> (o1.path - o2.path));

        // put all nodes into heap, the start node with be having path length = 0
        for (DJNode tmp : graph) {
            heap.offer(tmp);
        }

        // set of nodes selected on shortest path
        Set<DJNode> selected = new HashSet<>();


        while (!heap.isEmpty()) {
            // pull min path node from heap
            DJNode curr = heap.poll();

            // check all the edges
            for (DJEdge edge : curr.edges) {
                DJNode next = edge.to;
                selected.add(curr);

                /**
                 * if next node is not selected in shortest path
                 * and going though current path is faster, update path of next node
                 */
                if (!selected.contains(next) && curr.path + edge.weight < next.path) {
                    // update path of next
                    next.path = curr.path + edge.weight;

                    // set prev of next to curr
                    next.prev = curr;

                    // remember to remove and add it back to re-heapify
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

        // starting fron end, trace through prev all the way to start
        while (curr != start) {
            // if curr is already null, there is no way from end to start, return null
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
