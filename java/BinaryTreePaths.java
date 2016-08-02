import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> rst = new ArrayList<String>();
        helper(root, new StringBuffer(), rst);
        return rst;
    }

    public static void helper(TreeNode root, StringBuffer path, List<String>rst) {
        if (root == null)
            return;

        int origLen = path.length();

        if (path.length() > 0)
            path.append("->");
        path.append(root.val);

        if (root.left == null && root.right == null)
            rst.add(path.toString());

        helper(root.left, path, rst);
        helper(root.right, path, rst);

        path.delete(origLen, path.length());
    }
}