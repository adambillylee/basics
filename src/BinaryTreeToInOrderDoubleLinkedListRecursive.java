/**
 * Created by adamli on 6/8/16.
 */
public class BinaryTreeToInOrderDoubleLinkedListRecursive {
    class DLinkedNode {
        int val;
        DLinkedNode left;
        DLinkedNode right;

        DLinkedNode(int val) {
            this.val = val;
        }
    }

    /**
     * prev node is global traversal regardless of the level of recursion
     */
    DLinkedNode prev = null;
    public DLinkedNode convertInOrder(TreeNode root) {
        if (root == null)
            return null;

        return helper(root);
    }

    private DLinkedNode helper(TreeNode root) {
        if (root == null)
            return null;

        // deal with left
        helper(root.left);

        // deal with current
        DLinkedNode curr = new DLinkedNode(root.val);
        curr.left = prev;

        if (prev != null)
            prev.right = curr;

        // the "prev" of right node is current node
        // so set prev = curr here
        prev = curr;
        helper(root.right);

        // return current node
        return curr;
    }
}
