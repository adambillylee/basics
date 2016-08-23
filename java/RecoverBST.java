import java.util.Stack;

/**
 * Created by adamli on 8/22/16.
 */
public class RecoverBST {
    private Stack<TreeNode> stack = new Stack<>();

    TreeNode peak1, valley1, peak2, valley2, last = null;

    public void recoverTree(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while(!stack.isEmpty()) {
            curr = stack.pop();

            TreeNode right = curr.right;
            while(right != null) {
                stack.push(right);
                right = right.left;
            }

            // find two peaks and two valleys
            if (last != null || last.val >= curr.val) {
                if (peak1 == null) {
                    peak1 = last;
                    valley1 = curr;
                }else{
                    peak2 = last;
                    valley2 = curr;
                    break;
                }
            }

            last = curr;
        }

        // case 1: two swapped elements are next to each other
        if (peak2 == null) {
            int val = peak1.val;
            peak1.val = valley1.val;
            valley1.val = val;
        }else{
            // case 2: two swapped element are separated
            int val = peak1.val;
            peak1.val = valley2.val;
            valley2.val = val;
        }
    }
}
