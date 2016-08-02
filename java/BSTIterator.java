import java.util.Stack;

/**
 * Created by adamli on 4/19/16.
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack();

        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int rst;

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            rst = curr.val;

            if (curr.right != null) {
                TreeNode tmp = curr.right;

                while(tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }

            return rst;
        }

        return -1;
    }
}
