import java.util.ArrayList;
import java.util.List;

/**
 * Created by adamli on 4/9/16.
 */
public class BinaryTreeInOrderTraversalRecur {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        helper(root, rst);
        return rst;
    }

    public static void helper(TreeNode root, List<Integer> rst) {
        if (root == null)
            return;

        helper(root.left, rst);
        rst.add(root.val);
        helper(root.right, rst);
    }
}
