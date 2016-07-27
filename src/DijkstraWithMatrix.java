import java.util.*;

/**
 * Created by adamli on 7/26/16.
 */
public class DijkstraWithMatrix {
    List<Integer> shortestPath(int edges[][], int start, int end) {
        int N = edges.length;
        int dist[] = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean selected[] = new boolean[N];
        int prev[] = new int[N];
        Arrays.fill(prev, -1);

        for (int i = 1; i < N; i++) {
            int min = findMin(dist, N, selected);
            selected[min] = true;

            for (int j = 0; j < N; j++) {
                if (!selected[j] && edges[min][j] > 0 && dist[min] + edges[min][j] < dist[j]) {
                    dist[j] = dist[min] + edges[min][j];
                    prev[j] = min;
                }
            }
        }

        return getPath(prev, start, end);
    }

    private List<Integer> getPath(int[] prev, int start, int end) {
        int curr = end;
        List<Integer> rst = new ArrayList<>();

        while (curr != start) {
            if (curr == -1)
                return new ArrayList<>();

            rst.add(curr);
            curr = prev[curr];
        }

        rst.add(start);

        Collections.reverse(rst);
        return rst;
    }

    int findMin(int[] dist, int N, boolean[] selected) {
        int ind = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (dist[i] < min && !selected[i]) {
                min = dist[i];
                ind = i;
            }
        }

        return ind;
    }
}
