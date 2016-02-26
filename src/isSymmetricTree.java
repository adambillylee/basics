/**
 * Created by adamli on 2/25/16.
 */
public class isSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;

        if (a == null && b != null)
            return false;

        if (a != null && b == null)
            return false;

        if (a.val != b.val)
            return false;

        boolean outerSymmetric = helper(a.left, b.right);
        boolean innerSymmetric = helper(a.right, b.left);

        if (!(innerSymmetric && outerSymmetric))
            return false;

        return true;
    }
}
