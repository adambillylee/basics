import java.util.Stack;

/**
 * Created by adamli on 4/26/16.
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i<tokens.length;i++) {
            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    n2 = stack.pop();
                    n1 = stack.pop();
                    stack.push(n1 / n2);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
