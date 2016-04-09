/**
 * Created by adamli on 4/9/16.
 */
public class ValidateBST {
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

    public static boolean validate(TreeNode root) {
        return helper(root).isValid;
    }

    private static ReturnType helper(TreeNode root) {
        if (root == null)
            return new ReturnType(true, Long.MAX_VALUE, Long.MIN_VALUE);

        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);

        boolean isValid = left.isValid && right.isValid;

        if (root.val <= left.max)
            isValid = false;

        if (root.val >= right.min)
            isValid = false;

        long min = Math.min(root.val, left.min);
        long max = Math.max(root.val, right.max);

        return new ReturnType(isValid, min, max);
    }
}
