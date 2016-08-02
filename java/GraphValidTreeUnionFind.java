import java.util.Arrays;

/**
 * Created by adamli on 6/18/16.
 */
public class GraphValidTreeUnionFind {
    public boolean validTree(int n, int[][] edges) {
        int orig[] = new int[n];
        Arrays.fill(orig, -1);

        for (int i = 0; i < edges.length; i++) {
            int x = find(orig, edges[i][0]);
            System.out.format("find[%d] = %d\n", edges[i][0], x);
            int y = find(orig, edges[i][1]);
            System.out.format("find[%d] = %d\n", edges[i][1], y);

            /**
             * if two node share the same origin, there is a cycle
             */
            if (x == y)
                return false;

            orig[x] = y;
            System.out.format("orig[%d] = %d\n", x, y);
            System.out.println();
        }

        // prevent the case where there is not enough edge to connect all nodes
        return edges.length == n - 1;
    }

    private int find(int[] nums, int i) {
        if (nums[i] == -1)
            return i;

        return find(nums, nums[i]);
    }
}
