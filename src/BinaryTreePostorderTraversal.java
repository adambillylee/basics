import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreePostorderTraversal {
    public static List<Integer> postorderTraversalTwoStack(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> visited = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            TreeNode tmp = curr.right;

            if (tmp == null) {
                rst.add(stack.pop().val);
            }else{
                if (!visited.isEmpty() && visited.peek() == curr) {
                    visited.pop();
                    rst.add(stack.pop().val);
                }else{
                    visited.push(curr);

                    while (tmp != null) {
                        stack.push(tmp);
                        tmp = tmp.left;
                    }
                }
            }
        }

        return rst;
    }
}
