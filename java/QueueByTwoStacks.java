import java.util.Stack;

/**
 * Created by adamli on 2/21/16.
 */
public class QueueByTwoStacks {
    static Stack<Integer> s1 = new Stack();
    static Stack<Integer> s2 = new Stack();

    public static void offer(int input) {
        s1.add(input);
    }

    public static int poll() {
        if (s2.isEmpty()) {
            while (!s1.empty()) {
                s2.add(s1.pop());
            }
        }

        return s2.pop();
    }
}
