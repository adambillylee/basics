/**
 * Created by adamli on 2/23/16.
 */
public class isBalancedTree {
    public static boolean isBalanced(TreeNode root) {
        boolean isBalanced = helper(root).isBalanced;

        return isBalanced;
    }

    public static ReturnType helper(TreeNode root) {
        // base case:
        if (root == null)
            return new ReturnType(true, 0);

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        int depth = Math.max(left.height, right.height) + 1;

        boolean isBalanced = true;
        if (Math.abs(left.height - right.height) > 1) {
            isBalanced = false;
        }

        if (!left.isBalanced || !right.isBalanced)
            isBalanced = false;

        return new ReturnType(isBalanced, depth);
    }
}

class ReturnType{
    public boolean isBalanced;
    public int height;

    ReturnType(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}
