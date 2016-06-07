/**
 * Created by adamli on 6/6/16.
 */
public class BinaryTreeLongestConsecutiveSequence {
    class ReturnType {
        // longest consecutive sequence from bottom up to this node
        int length;

        // value of this tree node, for its parents to compare
        int val;

        public ReturnType(int length, int val) {
            this.length = length;
            this.val = val;
        }
    }

    int max = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        helper(root);

        return max;
    }

    private ReturnType helper(TreeNode root) {
        // base case
        if (root == null)
            return new ReturnType(0, 0);

        // divide
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        // if this current node value is consecutive sequence of current node
        int tmp = 0;
        if (left.length != 0 && left.val - root.val == 1) {
            tmp = left.length + 1;
            max = Math.max(tmp, max);
        }

        if (right.length != 0 && right.val - root.val == 1) {
            tmp = Math.max(tmp, right.length + 1);
            max = Math.max(tmp, max);
        }

        if (tmp > 0)
            return new ReturnType(tmp, root.val);
        else
            return new ReturnType(1, root.val);
    }
}
