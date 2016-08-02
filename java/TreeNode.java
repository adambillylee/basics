/**
 * Created by adamli on 2/23/16.
 */
class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }

    public void print() {
        System.out.println();
        System.out.println(this.toString());
    }
}
