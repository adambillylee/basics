import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThrones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s == null || s.length() == 0)
            return;

        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        boolean hasOdd = false;
        for (int i : map.values()) {
            if (i % 2 == 1) {
                if (s.length() % 2 == 0 || hasOdd) {
                    System.out.print("NO");
                    return;
                } else {
                    hasOdd = true;
                }
            }
        }

        System.out.print("YES");
    }
}