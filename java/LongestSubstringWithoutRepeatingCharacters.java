import java.util.HashMap;

/**
 * Created by adamli on 3/14/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * return longest non-dup substring from input
     * @param input input string
     * @return longest non-dup substring from input
     */
    public static String longestSubStringNoDups(String input) {
        if (input == null || input.length()==0)
            return input;

        // index of best solution so far (input[l~r] is current best solution)
        int l = 0;
        int r = 0;

        // two moving cursors of sliding window (input[slow~fast] is current solution)
        int slow = 0;
        int fast = 0;

        // use hashmap to keep un-dupped char and its index in [slow~fast]
        HashMap<Character, Integer> map = new HashMap<>();
        while (fast < input.length()) {
            char curr = input.charAt(fast);

            /**
             * if curr char has no dup in [slow~fast]
             */
            if (!map.containsKey(curr)) {
                // add curr char and index into hashmap
                map.put(curr, fast);
            }else{
                /**
                 * if curr char is a duplication
                 * 1. move slow all the way up next to previous curr char position (look up in hashmap)
                 * 2. delete all char and index from hashmap all the way up
                 */
                int prevInd = map.get(curr);
                while(slow <= prevInd) {
                    map.remove(input.charAt(slow));
                    slow++;
                }

                map.put(curr, fast);
            }

            // decide if we should update current best solution
            if (fast - slow > r - l) {
                r = fast;
                l = slow;
            }

            fast++;
        }

        /**
         * java substring(int startInd, int endInd)
         * startInd: inclusive
         * endInd: exclusive
         * get r+1 since we need input[l~r]
         */
        return input.substring(l, r+1);
    }
}
