import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by adamli on 4/9/16.
 */
public class TreeInOrderTraversalInterative {
    public static List<Integer> inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> rst = new ArrayList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            rst.add(tmp.val);

            if (tmp.right != null) {
                tmp = tmp.right;

                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
        }

        return rst;
    }
}
