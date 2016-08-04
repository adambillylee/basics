import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by adamli on 8/3/16.
 */
public class SolveExpression {
    ExpressionTreeNode root = null;

    public void createTree(String reversePolish) throws Exception {
        char[] charArray = reversePolish.toCharArray();
        Deque<ExpressionTreeNode> stack = new ArrayDeque<>();

        for (char c : charArray) {
            ExpressionTreeNode tmp = new ExpressionTreeNode(c);
            if (!isDigit(c)) {
                tmp.right = stack.pop();
                tmp.left = stack.pop();
            }
            stack.push(tmp);
        }

        this.root = stack.pop();
    }

    public int solveTree(ExpressionTreeNode root) throws Exception {
        if (root.isDigit())
            return root.getDigit();

        int left = solveTree(root.left);
        int right = solveTree(root.right);
        return getResult(left, right, root.c);
    }

    public int solve() throws Exception {
        int rst = solveTree(root);
        System.out.println(rst);
        return rst;
    }

    private int getResult(int a, int b, char c) throws Exception {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new Exception("not a valid operator");
        }
    }

    private boolean isDigit(char c) {
        if (c - '0' >= 0 && c - '0' <= 9)
            return true;
        else
            return false;
    }
}
