/**
 * Created by adamli on 2/23/16.
 */
public class PreOrderTraverse {
    public static void preOrder(TreeNode root) {
        // base case:
        if(root == null)
            return;

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
