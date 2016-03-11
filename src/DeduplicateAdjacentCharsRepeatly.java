import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by adamli on 3/8/16.
 */
public class DeduplicateAdjacentCharsRepeatly {
    public static String dedup(String input) {
        if (input == null || input.length() == 0)
            return "";

        ArrayList<Character> stack = new ArrayList<>();
        char[] charArray = input.toCharArray();

        int i = 0;

        while(i < input.length()) {
            if (stack.isEmpty()) {
                stack.add(charArray[i++]);
                continue;
            }

            char curr = stack.get(stack.size()-1);
            if (curr == charArray[i]) {
                while (curr == charArray[i]) {
                    i++;
                }

                stack.remove(stack.size()-1);
                continue;
            }

            stack.add(charArray[i++]);
        }

        StringBuilder sb = new StringBuilder();
        for(char ele : stack) {
            sb.append(ele);
        }

        return sb.toString();
    }
}
