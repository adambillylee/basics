import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfLines = scanner.nextInt();

        for (int i = 0; i < numOfLines; i++) {
            if (isValid(scanner.next())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('}', '{');
        brackets.put(')', '(');
        brackets.put('>', '<');
        brackets.put(']', '[');

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (brackets.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }

                char start = stack.pop();
                if (start != brackets.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}