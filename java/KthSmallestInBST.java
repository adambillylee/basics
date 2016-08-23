/**
 * Created by adamli on 8/22/16.
 */
public class KthSmallestInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int target = k - 1;

        int count = countNodes(root.left);

        if (target < count) {
            return kthSmallest(root.left, k);
        } else if (target > count) {
            return kthSmallest(root.right, target - count);
        } else {
            return root.val;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
