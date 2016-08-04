/**
 * Created by adamli on 8/3/16.
 */
public class ExpressionTreeNode {
    char c;
    ExpressionTreeNode left;
    ExpressionTreeNode right;

    ExpressionTreeNode(char c) {
        this.c = c;
    }

    ExpressionTreeNode(int i) {
        this.c = (char)(i + '0');
    }

    public boolean isDigit() {
        if (c - '0' >= 0 && c - '0' <= 9)
            return true;
        else
            return false;
    }

    public int getDigit() {
        if (isDigit()) {
            return c - '0';
        } else {
            return -1;
        }
    }

    @Override
    public String toString(){
        return "" + c;
    }

    public String getExpression() {
        return dfs(this);
    }

    private String dfs(ExpressionTreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(dfs(root.left));
        sb.append(dfs(root.right));
        sb.append(root.c);

        return sb.toString();
    }
}
