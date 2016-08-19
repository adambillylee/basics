import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adamli on 8/18/16.
 */
public class Perimeter {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxArea(int input[][], int x, int y) {
        if (input == null || input.length == 0 || input[0].length == 0)
            return 0;

        return bfs(input, x, y);
    }

    private int bfs(int[][] input, int x, int y) {
        int area = 0;
        Pair start = new Pair(x, y);

        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            input[curr.x][curr.y] = 2;

            if (isOnBoundary(input, curr.x, curr.y))
                area++;

            queue.addAll(expend(curr, input));
        }

        return area;
    }

    private List<Pair> expend(Pair curr, int input[][]) {
        List<Pair> rst = new ArrayList<>();

        int x = curr.x;
        int y = curr.y;
        int M = input.length;
        int N = input[0].length;

        if (x - 1 >= 0 && input[x - 1][y] == 1)
            rst.add(new Pair(x - 1, y));

        if (y - 1 >= 0 && input[x][y - 1] == 1)
            rst.add(new Pair(x, y - 1));

        if (x + 1 < M && input[x + 1][y] == 1)
            rst.add(new Pair(x + 1, y));

        if (y + 1 < N && input[x][y + 1] == 1)
            rst.add(new Pair(x, y + 1));

        return rst;
    }

    private boolean isOnBoundary(int input[][], int x, int y) {
        int M = input.length;
        int N = input[0].length;

        if (M == 1 && N == 1)
            return true;

        if ((x - 1 >= 0 && input[x - 1][y] == 0) || x - 1 < 0)
            return true;

        if ((y - 1 >= 0 && input[x][y - 1] == 0) || y - 1 < 0)
            return true;

        if ((x + 1 < M && input[x + 1][y] == 0) || x + 1 == M)
            return true;

        if ((y + 1 < N && input[x][y + 1] == 0) || y + 1 == N)
            return true;

        return false;
    }
}
