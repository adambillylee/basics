import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adamli on 3/15/16.
 */
public class AllAnagrams {
    /**
     * assume no dup chars in target
     *
     * @param input  long input string
     * @param target target to find anagrams with
     * @return arraylist with all anagrames
     */
    public static ArrayList<String> findAnagrames(String input, String target) {
        ArrayList<String> rst = new ArrayList<>();

        // sanity check
        if (input == null || input.length() == 0
                || target == null || target.length() == 0)
            return rst;


        int targetSize = target.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // cursor for
        int slow = 0;
        int fast = 0;
        int count = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        while (fast < input.length()) {
            // if current window size > target size, start removing head from window table
            if (fast - slow + 1 > targetSize) {
                char head = input.charAt(slow);

                // if curr in map, need to update counter
                if (map.containsKey(head)) {
                    // if head is a valid match, reduce counter by 1
                    if (window.get(head) <= map.get(head))
                        count--;

                    // update windows table
                    if (window.get(head) == 1) {
                        window.remove(head);
                    } else {
                        window.put(head, window.get(head) - 1);
                    }
                }

                // move slow by 1
                slow++;
            }

            // add curr into window table
            char curr = input.charAt(fast);
            if (map.containsKey(curr)) {
                if (window.containsKey(curr)) {
                    window.put(curr, window.get(curr) + 1);

                    // if head is valid match, add counter by 1
                    if (window.get(curr) <= map.get(curr))
                        count++;
                } else {
                    window.put(curr, 1);
                    count++;
                }
            }

            if (count == targetSize) {
                /**
                 * substring[startInd, endInd)
                 * startInd: inclusive
                 * endInd: exclusive
                 */
                rst.add(input.substring(slow, fast + 1));
            }

            fast++;
        }

        return rst;
    }
}
