import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by adamli on 7/25/16.
 */
public class DijkstrasMatrix {
    List<Character> minPath(int[][] graph, char[] labels, char start, char end) {
        int V = graph.length;

        // "is this node selected in shortes path"
        boolean sptSet[] = new boolean[V];

        // whole path
        int prev[] = new int[V];

        // find start and end index
        int startInd = 0;
        for (int i = 0; i < V; i++) {
            if (start == labels[i]) {
                startInd = i;
                break;
            }
        }

        int endInd = 0;
        for (int i = 0; i < V; i++) {
            if (end == labels[i]) {
                endInd = i;
                break;
            }
        }

        int distance[] = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startInd] = 0;

        for (int i = 1; i < V; i++) {
            int min = getMin(distance, sptSet);
            sptSet[min] = true;

            for (int neighbor = 0; neighbor < V; neighbor++) {
                if (!sptSet[neighbor] && graph[min][neighbor] > 0 &&
                        distance[min] + graph[min][neighbor] < distance[neighbor]) {
                    distance[neighbor] = distance[min] + graph[min][neighbor];
                    prev[neighbor] = min;
                }
            }
        }

        return getShortestPath(startInd, endInd, labels, prev);
    }

    private List<Character> getShortestPath(int startInd, int endInd, char[] labels, int[] prev) {
        List<Character> rst = new ArrayList<>();
        int curr = endInd;

        while (curr != startInd) {
            rst.add(labels[curr]);
            curr = prev[curr];
        }

        rst.add(labels[startInd]);

        Collections.reverse(rst);

        return rst;
    }

    private int getMin(int[] distance, boolean[] selected) {
        int rst = -1;
        int min = Integer.MAX_VALUE;
        int V = distance.length;

        for (int i = 0; i < V; i++) {
            if (distance[i] < min && !selected[i]) {
                min = distance[i];
                rst = i;
            }
        }

        return rst;
    }
}
