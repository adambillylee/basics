import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by adamli on 5/3/16.
 */
public class RemoveDupLettersAndKeepOrder {
    // count all chars in string
    private HashMap<Character, Integer> count = new HashMap();
    // stack that keep track of result
    private Stack<Character> stack = new Stack();
    // set that synced with stack and used for deduplication
    private HashSet<Character> set = new HashSet<>();


    public String removeDuplicateLetters(String s) {

        // count all chars into a count
        buildCountMap(s);

        // loop through all chars in string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // dedup
            if (set.contains(c)) {
                count.put(c, count.get(c) - 1);
                continue;
            }

            // clean up the stack before pushing new chars
            cleanUpStack(c);

            // add new char into stack and sync the set
            stack.push(c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    // clean up the stack before pushing new chars
    private void cleanUpStack(char c) {
        while (shouldPopFromStack(c)) {
            char head = stack.peek();

            stack.pop();
            count.put(head, count.get(head) - 1);
            set.remove(head);
        }
    }

    // shall I pop stack head or not?
    private boolean shouldPopFromStack(char c) {
        // if stack is empty, do not pop
        if (stack.isEmpty())
            return false;

        // if stack head is smaller, do not pop
        if (stack.peek() < c)
            return false;

        // if head is the last char in string, do not pop
        if (count.get(stack.peek()) <= 1)
            return false;

        return true;
    }

    // count all chars into a count
    private void buildCountMap(String s) {
        // build count count
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(s.charAt(i), 1);
            }
        }
    }
}
