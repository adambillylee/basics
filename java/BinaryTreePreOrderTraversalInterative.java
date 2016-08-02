import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreePreOrderTraversalInterative {
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return rst;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            rst.add(tmp.val);

            if (tmp.right != null)
                stack.push(tmp.right);

            if (tmp.left != null)
                stack.push(tmp.left);
        }

        return rst;
    }
}
