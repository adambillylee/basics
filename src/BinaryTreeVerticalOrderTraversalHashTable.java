import java.util.*;

/**
 * Created by adamli on 5/23/16.
 */
public class BinaryTreeVerticalOrderTraversalHashTable {
    private class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    // solve with hashmap
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // record max and min column
        int minCol = 0;
        int maxCol = 0;

        // create map of column -> nodes
        Map<Integer, List<Integer>> map = new HashMap();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        // use BFS to preserve vertical order
        while (!queue.isEmpty()) {
            Queue<Pair> next = new LinkedList<>();
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Pair curr = queue.poll();
                int col = curr.col;
                TreeNode node = curr.node;

                if (!map.containsKey(col)) {
                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);
                    map.put(col, new ArrayList<>());
                }

                map.get(col).add(node.val);

                if (node.left != null)
                    next.offer(new Pair(node.left, col - 1));
                if (node.right != null)
                    next.offer(new Pair(node.right, col + 1));

            }
            queue = next;
        }

        // loop from minCol to maxCol and convert map content to list
        List<List<Integer>> rst = new ArrayList<>();
        for (int col = minCol; col <= maxCol; col++) {
            rst.add(map.get(col));
        }

        return rst;
    }

}
