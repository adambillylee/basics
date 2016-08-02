/**
 * Created by adamli on 2/23/16.
 */
public class GetTreeHeight {
    public static int getHeight(TreeNode root) {
        // base case:
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        return currHeight;
    }
}
