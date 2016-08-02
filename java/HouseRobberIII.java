/**
 * Created by adamli on 4/26/16.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;

        int rst[] = helper(root);

        return Math.max(rst[0], rst[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }

        /**
         * 0 in case of not rob
         * 1 in case of rob
         */
        int rst[] = new int[2];

        int left[] = helper(root.left);
        int right[] = helper(root.right);

        // if rob this
        rst[1] = left[0] + right[0] + root.val;

        // if not rob this
        rst[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return rst;
    }
}
