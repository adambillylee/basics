/**
 * Created by adamli on 8/17/16.
 */
public class HouseRobberIII {
    class ReturnType {
        int rob;
        int notRob;

        public ReturnType() {
        }

        public ReturnType(int rob, int notRob) {
            this.rob = rob;
            this.notRob = notRob;
        }
    }

    public int rob(TreeNode root) {
        ReturnType rst = dfs(root);

        return Math.max(rst.rob, rst.notRob);
    }

    private ReturnType dfs(TreeNode root) {
        if (root == null)
            return new ReturnType(0, 0);

        ReturnType left = dfs(root.left);
        ReturnType right = dfs(root.right);

        // rob case: max of left not rob + right not rob + current value
        ReturnType rst = new ReturnType();
        rst.rob = left.notRob + right.notRob + root.val;

        // not rob case: max of left + max of right, both side can either be robbed or not
        int leftMax = Math.max(left.notRob, left.rob);
        int rightMax = Math.max(right.notRob, right.rob);
        rst.notRob = leftMax + rightMax;

        return rst;
    }
}
