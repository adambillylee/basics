import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adamli on 6/9/16.
 */
public class WallAndGatesBFS {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0)
            return;

        if (rooms[0].length == 0)
            return;

        int m = rooms.length;
        int n = rooms[0].length;

        boolean visited[][] = new boolean[m][n];

        int dist = 1;
        Queue<Pair> curr = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    visited[i][j] = true;
                    curr.offer(new Pair(i, j));
                }
            }
        }

        calDistance(rooms, curr, dist, visited);
    }

    private void calDistance(int[][] rooms, Queue<Pair> curr, int dist, boolean visited[][]) {
        while (!curr.isEmpty()) {
            Queue<Pair> next = new LinkedList<>();
            int len = curr.size();

            for (int i = 0; i < len; i++) {
                Pair tmp = curr.poll();

                List<Pair> neighbours = extend(rooms, tmp, dist, visited);

                next.addAll(neighbours);
            }
            curr = next;
            dist++;
        }
    }

    private List<Pair> extend(int[][] rooms, Pair tmp, int dist, boolean visited[][]) {
        List<Pair> rst = new ArrayList<>();

        int i = tmp.i;
        int j = tmp.j;

        if (validate(rooms, i, j + 1, dist, visited))
            rst.add(new Pair(i, j + 1));

        if (validate(rooms, i + 1, j, dist, visited))
            rst.add(new Pair(i + 1, j));

        if (validate(rooms, i, j - 1, dist, visited))
            rst.add(new Pair(i, j - 1));

        if (validate(rooms, i - 1, j, dist, visited))
            rst.add(new Pair(i - 1, j));

        return rst;
    }

    private boolean validate(int[][] rooms, int i, int j, int dist, boolean visited[][]) {
        if (i < 0 || j < 0)
            return false;

        if (i >= rooms.length || j >= rooms[0].length)
            return false;

        if (rooms[i][j] == -1 || rooms[i][j] == 0)
            return false;

        if (visited[i][j])
            return false;

        visited[i][j] = true;
        rooms[i][j] = dist;

        return true;
    }
}
