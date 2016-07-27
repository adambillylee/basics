import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by adamli on 7/26/16.
 */
public class DijkastraWithListsTest {
    DijkastraWithLists sol = new DijkastraWithLists();

    @Test
    public void testShortestPath() throws Exception {
        List<DJNode> graph = new ArrayList<>();
        DJNode zero = new DJNode(0);
        DJNode one = new DJNode(1);
        DJNode two = new DJNode(2);
        DJNode three = new DJNode(3);
        DJNode four = new DJNode(4);
        DJNode five = new DJNode(5);
        DJNode six = new DJNode(6);
        DJNode seven = new DJNode(7);
        DJNode eight = new DJNode(8);

        zero.edges.add(new DJEdge(zero, one, 4));
        zero.edges.add(new DJEdge(zero, seven, 8));
        one.edges.add(new DJEdge(one, two, 8));
        one.edges.add(new DJEdge(one, seven, 11));
        two.edges.add(new DJEdge(two, three, 7));
        two.edges.add(new DJEdge(two, eight, 2));
        two.edges.add(new DJEdge(two, five, 4));
        three.edges.add(new DJEdge(three, four, 9));
        three.edges.add(new DJEdge(three, five, 14));
        four.edges.add(new DJEdge(four, five, 10));
        five.edges.add(new DJEdge(five, six, 2));
        six.edges.add(new DJEdge(six, seven, 1));
        six.edges.add(new DJEdge(six, eight, 6));
        seven.edges.add(new DJEdge(seven, eight, 7));

        graph.add(zero);
        graph.add(one);
        graph.add(two);
        graph.add(three);
        graph.add(four);
        graph.add(five);
        graph.add(six);
        graph.add(seven);
        graph.add(eight);

        List<Integer> rst = sol.shortestPath(graph, 0, 3);
        System.out.println(rst);
    }

    @Test
    public void testShortestPath2() throws Exception {
        int test[] = {Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 3};
        Comparator<DJNode> comparator = new Comparator<DJNode>() {
            @Override
            public int compare(DJNode o1, DJNode o2) {
                if (o1.path == Integer.MAX_VALUE && o2.path == Integer.MAX_VALUE)
                    return 0;

                return o1.path - o2.path;
            }
        };
        PriorityQueue<DJNode> heap = new PriorityQueue<>(comparator);
        DJNode zero = new DJNode(0);
        DJNode one = new DJNode(1);
        one.path = 6;
        DJNode two = new DJNode(2);
        two.path = 3;

        heap.offer(zero);
        heap.offer(one);
        heap.offer(two);

        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }


}