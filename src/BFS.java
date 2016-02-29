import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adamli on 2/28/16.
 */
public class BFS {
    public static List<Integer> bfs(TreeNode root) {
        List<Integer> rst = new ArrayList<>();

        if (root == null)
            return rst;

        // use queue
        Queue<TreeNode> queue = new LinkedList<>();

        // initialize: push root into queue
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode curr = queue.poll();
            rst.add(curr.val);

            for(int i=0; i<size; i++) {
                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }
        }

        return rst;
    }
}
