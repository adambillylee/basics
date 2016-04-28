/**
 * Created by adamli on 4/27/16.
 */
public class SerializeAndDeserializeBinaryTree {
    StringBuilder sb = new StringBuilder();
    int ind = 0;

    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        buildCodex(root, sb);

        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private void buildCodex(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(',');
            return;
        }

        sb.append(root.val);
        sb.append(',');
        buildCodex(root.left, sb);
        buildCodex(root.right, sb);
    }

    public TreeNode deserialize(String codex) {
        if (codex == null || codex.isEmpty()) {
            return null;
        }

        String[] strArr = codex.split(",");

        return buildTree(strArr);
    }

    private TreeNode buildTree(String strArr[]) {
        if (ind == strArr.length)
            return null;

        String c = strArr[ind];
        TreeNode node;

        if (c.equals("#")) {
            node = null;
            ind++;
            return node;
        } else {
            node = new TreeNode(Integer.parseInt(c));
            ind++;
        }

        node.left = buildTree(strArr);
        node.right = buildTree(strArr);

        return node;
    }
}
