/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LargestBSTSubtree {
    private class ReturnType {
        boolean valid;
        int size;
        int min;
        int max;

        ReturnType(boolean valid, int size, int min, int max) {
            this.valid = valid;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root).size;
    }

    public ReturnType helper(TreeNode root) {
        if (root == null)
            return new ReturnType(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        // if left or right is not bst, root cannot be bst, select max bst subtree size from left an right
        if (left.valid == false || right.valid == false)
            return new ReturnType(false, Math.max(left.size, right.size), 0, 0);

        // if left max >= root value, select max bst subtree size from left an right
        if (root.left != null && left.max >= root.val)
            return new ReturnType(false, Math.max(left.size, right.size), 0, 0);

        // if right min <= root value, select max bst subtree size from left an right
        if (root.right != null && right.min <= root.val)
            return new ReturnType(false, Math.max(left.size, right.size), 0, 0);

        // if root is bst, size = left + right + 1 for root, min = left min, max = right max
        return new ReturnType(true, 1 + left.size + right.size, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }
}