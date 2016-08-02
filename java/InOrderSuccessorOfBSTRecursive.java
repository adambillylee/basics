/**
 * Created by adamli on 6/14/16.
 */
public class InOrderSuccessorOfBSTRecursive {
    TreeNode lastLarger = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        return helper(root, p);
    }

    private TreeNode helper(TreeNode root, TreeNode p) {
        if (root.val == p.val) {
            if (root.right != null) {
                return getLeftMostChildFromRight(root.right);
            } else {
                return lastLarger;
            }
        } else if (root.val > p.val) {
            lastLarger = root;
            return helper(root.left, p);
        } else {
            return helper(root.right, p);
        }
    }

    private TreeNode getLeftMostChildFromRight(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
