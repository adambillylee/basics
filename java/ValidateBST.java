/**
 * Created by adamli on 4/9/16.
 */
public class ValidateBST {
    /**
     * recursive tree by tree check solution
     */
    static class ReturnType {
        boolean isValid;
        long min;
        long max;

        ReturnType(boolean isValid, long min, long max) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
        }
    }

    public static boolean validateRecurr(TreeNode root) {
        return validateRecurrHelper(root).isValid;
    }

    private static ReturnType validateRecurrHelper(TreeNode root) {
        if (root == null)
            return new ReturnType(true, Long.MAX_VALUE, Long.MIN_VALUE);

        ReturnType left = validateRecurrHelper(root.left);
        ReturnType right = validateRecurrHelper(root.right);

        boolean isValid = left.isValid && right.isValid;

        if (root.val <= left.max)
            isValid = false;

        if (root.val >= right.min)
            isValid = false;

        long min = Math.min(root.val, left.min);
        long max = Math.max(root.val, right.max);

        return new ReturnType(isValid, min, max);
    }


    /**
     * in order solution
     */
    TreeNode prev = null;

    public boolean validateInorder(TreeNode root) {
        return validateInOrderHelper(root);
    }

    private boolean validateInOrderHelper(TreeNode root) {
        if (root == null)
            return true;

        if (!validateInOrderHelper(root.left))
            return false;

        if (prev != null && root.val <= prev.val)
            return false;

        prev = root;
        return validateInOrderHelper(root.right);
    }
}
