import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adamli on 6/9/16.
 */
public class WallAndGatesBFS {
    class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int[][] rooms;
    int m;
    int n;
    boolean visited[][];

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;

        this.rooms = rooms;
        this.m = rooms.length;
        this.n = rooms[0].length;
        this.visited = new boolean[m][n];

        Queue<Pair> queue = new LinkedList();

        // initialized queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(new Pair(i,j));
            }
        }

        //BFS
        int dist = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Queue<Pair> next = new LinkedList();

            for (int i=0; i<len; i++) {
                Pair curr = queue.poll();
                rooms[curr.i][curr.j] = dist;

                List<Pair> neighbours = extend(curr);
                next.addAll(neighbours);
            }

            queue = next;
            dist++;
        }
    }

    private List<Pair> extend(Pair curr) {
        List<Pair> rst = new ArrayList();
        int i = curr.i;
        int j = curr.j;

        if (valid(i+1, j))
            rst.add(new Pair(i+1,j));

        if (valid(i, j+1))
            rst.add(new Pair(i,j+1));

        if (valid(i-1, j))
            rst.add(new Pair(i-1,j));

        if (valid(i, j-1))
            rst.add(new Pair(i,j-1));

        return rst;
    }

    private boolean valid(int i, int j) {
        if (i < 0 || j < 0)
            return false;

        if (i >= m || j >= n)
            return false;

        if (visited[i][j])
            return false;

        if (rooms[i][j] != Integer.MAX_VALUE)
            return false;

        visited[i][j] = true;
        return true;
    }
}
